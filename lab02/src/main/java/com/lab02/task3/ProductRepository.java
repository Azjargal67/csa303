package com.lab02.task3;

import java.util.List;

public interface ProductRepository {
    List<Product> findByCategory(String category);
    void saveAll(List<Product> products);
}