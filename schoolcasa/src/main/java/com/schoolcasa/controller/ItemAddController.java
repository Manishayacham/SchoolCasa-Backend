package com.schoolcasa.controller;

import com.schoolcasa.model.ItemListing;
import com.schoolcasa.service.ItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class ItemAddController {

    @Autowired
    private ItemAddService itemAddService;

    @PostMapping("/postItem")
    public String addItem(@RequestParam(required = false) MultipartFile file, @RequestParam String productName, @RequestParam double price, @RequestParam String address,
                          @RequestParam String description, @RequestParam String category, @RequestParam String age,
                          @RequestParam String warranty,
                          @RequestParam String email) {
        System.out.println("Obtained request " + productName);
        try {
            ItemListing itemListing = itemAddService.addItem(file, productName, price, address, description, category, age, warranty, email);
            if (itemListing != null) {
                return "Item added";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Item add failed";
    }

    @DeleteMapping("/deleteItemListing/{id}")
    public String deleteItemListing(@PathVariable int id){
        return itemAddService.deleteItemListing(id);
    }

    @PutMapping("/editItemListing")
    public String addItem(@RequestParam int id, @RequestParam String productName,
                          @RequestParam double price, @RequestParam String address,
                          @RequestParam String description, @RequestParam String category,
                          @RequestParam String age, @RequestParam String warranty,
                          @RequestParam String email) {
        try {
            ItemListing itemListing = itemAddService.editItemListing(id,productName, price, address, description, category, age, warranty, email);
            if (itemListing != null) {
                return "Item listing edit successful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Item listing edit failed";
    }
}
