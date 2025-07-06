package org.example.inventory.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.inventory.filter.factory.*;
import org.example.inventory.filter.model.Product;
import org.example.inventory.filter.repository.InMemoryInventoryRepositoryImpl;
import org.example.inventory.filter.repository.InventoryRepository;
import org.example.inventory.filter.service.InventoryManager;
import org.example.inventory.filter.strategy.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverClass {
    public static void main(String[] args) throws JsonProcessingException {
        // 1. Sample products
        List<Product> products = List.of(
                new Product("1", "Nike Shoe", 900.0, "Men"),
                new Product("2", "Adidas Shirt", 1200.0, "Men"),
                new Product("3", "Puma Shoe", 800.0, "Women"),
                new Product("4", "Roadster Jacket", 2000.0, "Men"),
                new Product("5", "Zara Dress", 700.0, "Women")
        );


        // 2. Add products to repository
        InventoryRepository repository = new InMemoryInventoryRepositoryImpl();
        products.forEach(repository::addProductToInventory);

        // 4. Register all factories
        List<IFilterTypeDataFactory> factoryList = new ArrayList<>();
        factoryList.add(new NameFilterTypeDataFactory());
        factoryList.add(new PriceFilterTypeDataFactory());
        factoryList.add(new CategoryFilterTypeDataFactory());
        factoryList.add(new ANDFilterTypeDataFactory());
        factoryList.add(new ORFilterTypeDataFactory());

        FilterTypeDataRegistry registry = new FilterTypeDataRegistry(factoryList);

        // 3. Register all strategies
        List<IFilterStrategy> basicStrategies = List.of(
                new NameFilterStrategy(),
                new PriceFilterStrategy(),
                new CategoryFilterStrategy()
        );

        List<IFilterStrategy> allStrategies = new ArrayList<>(basicStrategies);

        allStrategies.add(new ANDFilteringStrategy(basicStrategies, registry));
        allStrategies.add(new ORFilteringStrategy(basicStrategies, registry));

        // 5. Inventory Manager
        InventoryManager manager = new InventoryManager(repository, allStrategies, registry);

        // 6. Sample filter (JSON)
        String jsonFilter = """
                {
                  "and": [
                    { "name": "Shoe" },
                    { "price": { "lt": 1000 } },
                    {
                      "or": [
                        { "category": "Men" },
                        { "category": "Women" }
                      ]
                    }
                  ]
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> filterMap = objectMapper.readValue(jsonFilter, Map.class);

        // 7. Apply filtering
        List<Product> filteredProducts = manager.filterProducts(filterMap);

        // 8. Output
        System.out.println("✅ Filtered Products:");
        for (Product product : filteredProducts) {
            System.out.println(product);
        }
    }
}
