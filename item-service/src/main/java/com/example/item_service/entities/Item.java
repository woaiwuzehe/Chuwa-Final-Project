package com.example.item_service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {

    @Id
    private String id;                 // 商品ID，由 MongoDB 自动生成
    private String itemName;           // 商品名称
    private double unitPrice;          // 单价
    private String upc;                // 通用产品码
    private String imageUrl;           // 商品图片链接
    private int inventory;             // 库存数量

    public Item() {}

    public Item(String itemName, double unitPrice, String upc, String imageUrl, int inventory) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.upc = upc;
        this.imageUrl = imageUrl;
        this.inventory = inventory;
    }

    // Getter & Setter method
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getUpc() {
        return upc;
    }
    public void setUpc(String upc) {
        this.upc = upc;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
