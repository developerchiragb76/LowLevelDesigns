package org.example.inventory.filter.repository;

import org.example.inventory.filter.model.Product;

import java.util.List;

public interface InventoryRepository {
    void addProductToInventory(Product product);
    List<Product> getAllProducts();
}
