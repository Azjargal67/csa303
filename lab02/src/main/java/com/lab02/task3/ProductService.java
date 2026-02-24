package com.lab02.task3;

import java.util.Date;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;
    private final PopularityRepository popularityRepository;
    private final CacheService cacheService;
    private final SearchHistoryService searchHistoryService;

    public ProductService(ProductRepository productRepository,
                          PopularityRepository popularityRepository,
                          CacheService cacheService,
                          SearchHistoryService searchHistoryService) {
        this.productRepository = productRepository;
        this.popularityRepository = popularityRepository;
        this.cacheService = cacheService;
        this.searchHistoryService = searchHistoryService;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);

        incrementViews(products);
        productRepository.saveAll(products);

        updatePopularity(category, products);
        cacheProducts(category, products);
        recordSearch(category, products.size());

        return products;
    }

    private void incrementViews(List<Product> products) {
        for (Product p : products) {
            p.setViewCount(p.getViewCount() + 1);
        }
    }

    private void updatePopularity(String category, List<Product> products) {
        PopularityData data = new PopularityData();
        data.setCategory(category);
        data.setProductCount(products.size());
        data.setLastAccessed(new Date());
        popularityRepository.save(data);
    }

    private void cacheProducts(String category, List<Product> products) {
        cacheService.put("products_" + category, products);
    }

    private void recordSearch(String category, int count) {
        searchHistoryService.recordSearch(category, count);
    }
}