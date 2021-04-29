package com.schoolcasa.app.service.impl;

import com.schoolcasa.model.ItemListing;
import com.schoolcasa.repository.ItemRepository;
import com.schoolcasa.service.impl.ItemListingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemListingServiceTest {
    @MockBean
    ItemRepository itemRepository;

    @Autowired
    ItemListingServiceImpl itemListingService;

    @Test
    public void getItemsTest(){
        ItemListing itemListing1 = new ItemListing();
        ItemListing itemListing2 = new ItemListing();
        List<ItemListing> list = new ArrayList<>();
        list.add(itemListing1);
        list.add(itemListing2);
        given(itemRepository.findAll()).willReturn(list);
        assertEquals(itemListingService.getItems(),list);
    }

    @Test
    public void getMyItemsTest(){
        ItemListing itemListing1 = new ItemListing();
        ItemListing itemListing2 = new ItemListing();
        List<ItemListing> list = new ArrayList<>();
        list.add(itemListing1);
        list.add(itemListing2);
        given(itemRepository.getItemListByEmail("xyz@sjsu.edu")).willReturn(list);
        assertEquals(itemListingService.getMyItemListings("xyz@sjsu.edu"),list);
    }
}
