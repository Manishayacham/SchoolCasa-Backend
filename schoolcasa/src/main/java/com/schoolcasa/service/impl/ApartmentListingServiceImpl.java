package com.schoolcasa.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.schoolcasa.model.ApartmentListing;
import com.schoolcasa.repository.ApartmentListingRepository;
import com.schoolcasa.service.ApartmentListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class ApartmentListingServiceImpl implements ApartmentListingService {
    private ApartmentListingRepository apartmentListingRepository;

    @Autowired
    ApartmentListingServiceImpl(ApartmentListingRepository apartmentListingRepository) {
        this.apartmentListingRepository = apartmentListingRepository;
    }

    @Value("${bucketName}")
    private String bucketName;

    @Value("${endpointUrl}")
    private String endpointUrl;

    @Autowired
    private AmazonS3 amazonS3;

    @Override
    public ApartmentListing addApartmentListing(int bedrooms, String bathrooms, double rent, String address,
                                                String description, boolean isParkingAvailable, Date availableDate,
                                                MultipartFile image1, MultipartFile image2, MultipartFile image3,
                                                String latitude, String longitude) {
        ApartmentListing apartmentListing = new ApartmentListing();
        apartmentListing.setBedrooms(bedrooms);
        apartmentListing.setBathrooms(bathrooms);
        apartmentListing.setRent(rent);
        apartmentListing.setAddress(address);
        apartmentListing.setDescription(description);
        apartmentListing.setParkingAvailable(isParkingAvailable);
        apartmentListing.setAvailableDate(availableDate);
        String imageUrl = "";
        if (image1 != null) {
            imageUrl = uploadFile(image1);
            apartmentListing.setImageURL1(imageUrl);
        }
        if (image2 != null) {
            imageUrl = uploadFile(image2);
            apartmentListing.setImageURL2(imageUrl);
        }
        if (image3 != null) {
            imageUrl = uploadFile(image3);
            apartmentListing.setImageURL3(imageUrl);
        }
        apartmentListing.setLatitude(latitude);
        apartmentListing.setLongitude(longitude);
        return apartmentListingRepository.save(apartmentListing);
    }

    private String uploadFile(MultipartFile multipartFile) {
        String fileUrl = "";
        String status = null;
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = multipartFile.getOriginalFilename();
            fileUrl = endpointUrl + "/" + fileName;
            status = uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            System.out.println("Image Upload Failed:" + e.getMessage());
            return ("Image Upload Failed" + HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return fileUrl;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convertFile);
        fos.write(file.getBytes());
        fos.close();
        return convertFile;
    }

    private String uploadFileTos3bucket(String fileName, File file) {
        try {
            amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (AmazonServiceException e) {
            return "uploadFileTos3bucket().Uploading failed :" + e.getMessage();
        }
        return "Uploading Successful ";
    }
}
