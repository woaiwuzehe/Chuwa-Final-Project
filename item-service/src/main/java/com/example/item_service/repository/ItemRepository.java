package com.example.item_service.repository;

import com.example.item_service.entities.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    // optional，find by upc
    Item findByUpc(String upc);
}
