package com.warehouse;

public class WishListItem
{
    private Product product;
    private int quantity;

    public WishListItem(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct()
    {
        return product;
    }

    public int getQuantity()
    {
        return quantity;
    }

    @Override
    public String toString()
    {
        return "com.warehouse.WishListItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
}
