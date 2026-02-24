package com.lab02.task3;

public class Product {
    private final Long id;
    private final String category;
    private int viewCount;

    public Product (Long id, String category, int viewCount) {
        this.id = id;
        this.category = category;
        this.viewCount = viewCount;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
