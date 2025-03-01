package com.example.item_service.service;

import com.example.item_service.entities.Item;
import com.example.item_service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateInventory(String itemId, int newInventory) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setInventory(newInventory);
            return itemRepository.save(item);
        }
        return null;
    }
}
