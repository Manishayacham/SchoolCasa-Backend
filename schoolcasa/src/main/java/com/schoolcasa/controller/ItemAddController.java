package com.schoolcasa.controller;

import com.schoolcasa.model.ItemListing;
import com.schoolcasa.service.ItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class ItemAddController {

    @Autowired
    private ItemAddService itemAddService;

    @PostMapping("/postItem")
    public String addItem(@RequestParam(required = false) MultipartFile file, @RequestParam String productName, @RequestParam double price, @RequestParam String address,
                          @RequestParam String description, @RequestParam String category, @RequestParam String age,
                          @RequestParam String warranty) {
        System.out.println("Obtained request " + productName);
        try {
            ItemListing itemListing = itemAddService.addItem(file,productName, price, address, description, category, age, warranty);
            if (itemListing != null) {
                return "Item added";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Item add failed";

    }
}
