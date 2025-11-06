package com.test;

import com.warehouse.*;

public class ProductListTestDriver {
    public static void main(String[] args) {
        WarehouseSystem ws = new WarehouseSystem();
        ProductList products = ws.getInventory();

        // Add products using your constructor
        products.insert(new Product("Widget A", 10, 12.99));
        products.insert(new Product("Widget B", 0, 9.50));

        System.out.println("== Products ==");
        for (Product p : products) {
            // Use getters that exist in your Product class
            System.out.println(
                p.getId() + " | " + p.getName()
                + " | stock=" + p.getStockQty()
                + " | $" + String.format("%.2f", p.getSalePrice())
            );
        }

        // Find the first product by id and print a quick confirmation
        String firstId = products.iterator().hasNext() ? products.iterator().next().getId() : null;
        if (firstId != null) {
            Product found = products.findById(firstId);
            System.out.println("\nFind by id (" + firstId + "): "
                + (found != null ? "Found " + found.getName() : "Not found"));
        } else {
            System.out.println("\nNo products in list.");
        }
    }
}
