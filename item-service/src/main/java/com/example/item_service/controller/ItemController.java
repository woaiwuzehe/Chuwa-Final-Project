package com.example.item_service.controller;

import com.example.item_service.entities.Item;
import com.example.item_service.payload.InventoryUpdateRequest;
import com.example.item_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id){
        Optional<Item> itemOpt = itemService.getItemById(id);
        if(itemOpt.isPresent()){
            return ResponseEntity.ok(itemOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.ok(createdItem);
    }


    @PutMapping("/updateInventory")
    public ResponseEntity<Item> updateInventory(@RequestBody InventoryUpdateRequest request){
        Item updatedItem = itemService.updateInventory(request.getItemId(), request.getNewInventory());
        if(updatedItem != null){
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}