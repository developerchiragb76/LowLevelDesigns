package org.example.inventory.filter.repository;

import org.example.inventory.filter.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryInventoryRepositoryImpl implements InventoryRepository {
    private final Map<String, Product> productMap;

    public InMemoryInventoryRepositoryImpl() {
        this.productMap = new HashMap<>();
    }

    @Override
    public void addProductToInventory(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
}
