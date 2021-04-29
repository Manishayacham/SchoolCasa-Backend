package com.schoolcasa.app.service.impl;

import com.amazonaws.services.simpledb.model.Item;
import com.schoolcasa.model.ItemListing;
import com.schoolcasa.repository.ItemRepository;
import com.schoolcasa.service.impl.ItemAddServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemAddServiceTest {
    @MockBean
    ItemRepository itemRepository;

    @Autowired
    ItemAddServiceImpl itemAddService;

    @Test
    public void addItemTest(){
        ItemListing itemListing = new ItemListing();
        given(itemRepository.save(any())).willReturn(itemListing);
        assertEquals(itemAddService.addItem(null,"laptop",200.0,"1 Washington Sq, San Jose",
                "1year old laptop", "Electronics","1 year","No","xyz@sjsu.edu"),itemListing);
    }

    @Test
    public void deleteItemListingTest(){
        assertEquals(itemAddService.deleteItemListing(1),"Deletion successful");
    }

    @Test
    public void editItemListingTest(){
        ItemListing itemListing = new ItemListing();
        given(itemRepository.save(itemListing)).willReturn(itemListing);
        given(itemRepository.getItemListingById(1)).willReturn(itemListing);
        assertEquals(itemAddService.editItemListing(1,"Lamp",234.0,"1 Washington drive, San Jose, CA,USA",
                "good condition","Furniture","1year","No","xyz@sjsu.edu"),itemListing);
    }
}
