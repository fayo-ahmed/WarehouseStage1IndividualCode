package com.warehouse;

public class Product {
    private static int nextId = 1;
    private final String id;
    private final String name;
    private int stockQty;
    private final double salePrice;

    public Product(String name, int stockQty, double salePrice) {
        if (name == null || name.isBlank() || stockQty < 0 || salePrice <= 0)
            throw new IllegalArgumentException("Invalid product fields");
        this.id = "P" + (nextId++);
        this.name = name;
        this.stockQty = stockQty;
        this.salePrice = salePrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStockQty() {
        return stockQty;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setStockQty(int qty) {
        if (qty < 0)
            throw new IllegalArgumentException("Stock cannot be negative");
        this.stockQty = qty;
    }

    @Override
    public String toString() {
        return String.format("com.warehouse.Product[ID=%s, Name=%s, StockQty=%d, SalePrice=%.2f]",
                id, name, stockQty, salePrice);
    }
}
