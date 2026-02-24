package com.lab02.task3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void getProductsByCategory_incrementsViews_and_callsSideEffects() {
        // "DB"-ийн оронд ашиглах list
        List<Product> db = new ArrayList<>();
        db.add(new Product(1L, "books", 0));
        db.add(new Product(2L, "books", 10));

        AtomicInteger saveAllCalls = new AtomicInteger(0);
        AtomicInteger popularityCalls = new AtomicInteger(0);
        AtomicInteger cacheCalls = new AtomicInteger(0);
        AtomicInteger historyCalls = new AtomicInteger(0);

        ProductRepository productRepo = new ProductRepository() {
            @Override
            public List<Product> findByCategory(String category) {
                return db;
            }

            @Override
            public void saveAll(List<Product> products) {
                saveAllCalls.incrementAndGet();
            }
        };

        PopularityRepository popularityRepo = data -> popularityCalls.incrementAndGet();
        CacheService cacheService = (key, value) -> cacheCalls.incrementAndGet();
        SearchHistoryService historyService = (category, count) -> historyCalls.incrementAndGet();

        ProductService service = new ProductService(
                productRepo,
                popularityRepo,
                cacheService,
                historyService
        );

        List<Product> result = service.getProductsByCategory("books");

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getViewCount());   // 0 -> 1
        assertEquals(11, result.get(1).getViewCount());  // 10 -> 11

        assertEquals(1, saveAllCalls.get());
        assertEquals(1, popularityCalls.get());
        assertEquals(1, cacheCalls.get());
        assertEquals(1, historyCalls.get());
    }
}