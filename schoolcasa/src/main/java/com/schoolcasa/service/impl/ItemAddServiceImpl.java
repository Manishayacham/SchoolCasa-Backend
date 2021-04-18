package com.schoolcasa.service.impl;

import com.amazonaws.AmazonServiceException;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.schoolcasa.model.ItemListing;
import com.schoolcasa.repository.ItemRepository;
import com.schoolcasa.service.ItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class ItemAddServiceImpl implements ItemAddService {

    @Value("${bucketName}")
    private String bucketName;

    @Value("${endpointUrl}")
    private String endpointUrl;

    @Autowired
    private AmazonS3 amazonS3;

    private ItemRepository itemRepository;

    @Autowired
    ItemAddServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemListing addItem(MultipartFile multipartFile, String productName, double price, String address, String description, String category, String age, String warranty, String email) {

        ItemListing itemListing = new ItemListing();
        itemListing.setProductName(productName);
        itemListing.setAge(age);
        itemListing.setPrice(price);
        itemListing.setAddress(address);
        itemListing.setDescription(description);
        itemListing.setWarranty(warranty);
        itemListing.setCategory(category);
        itemListing.setEmail(email);
        String imageUrl = "";

        if (multipartFile != null) {
            imageUrl = uploadFile(multipartFile);
            itemListing.setImageURL(imageUrl);
        }

        return itemRepository.save(itemListing);
    }

    public String uploadFile(MultipartFile multipartFile) {
        String fileUrl = "";
        String status = null;
        try {
//            System.out.println("inside uploadFile ");
            File file = convertMultiPartToFile(multipartFile);

            String fileName = multipartFile.getOriginalFilename();

            System.out.println("filename" + fileName);
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

    @Override
    public String deleteItemListing(int id) {
        try {
            itemRepository.deleteById(id);
        } catch (Exception e) {
            return "Deletion unsuccessful, id is not present in DB.";
        }
        return "Deletion successful";
    }

    @Override
    public ItemListing editItemListing(int id, String productName, double price,
                                       String address, String description,
                                       String category, String age,
                                       String warranty, String email) {
        Optional<ItemListing> itemListingOptional = itemRepository.findById(id);
        if (itemListingOptional.isPresent()) {
            ItemListing itemListing = new ItemListing();
            itemListing.setId(id);
            itemListing.setProductName(productName);
            itemListing.setAge(age);
            itemListing.setPrice(price);
            itemListing.setAddress(address);
            itemListing.setDescription(description);
            itemListing.setWarranty(warranty);
            itemListing.setCategory(category);
            itemListing.setEmail(email);
            return itemRepository.save(itemListing);
        }
        return null;
    }
}
