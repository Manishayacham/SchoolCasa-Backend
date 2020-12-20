package com.schoolcasa.controller;

import com.schoolcasa.model.ItemListing;
import com.schoolcasa.service.ItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ItemAddController {

    @Autowired
    private ItemAddService itemAddService;

    @PostMapping("/postItem")
    public String addItem(@RequestParam String productName, @RequestParam double price, @RequestParam String address, @RequestParam String description, @RequestParam String category, @RequestParam String age, @RequestParam String warranty, @RequestParam String imageurl) {
        try {
            ItemListing itemListing = itemAddService.addItem(productName, price,address, description, category,age, warranty,imageurl);
            if (itemListing != null) {
                return "Item added";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Item add failed";

    }
}
