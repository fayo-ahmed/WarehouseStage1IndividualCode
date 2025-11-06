package com.warehouse;

import java.util.ArrayList;
import java.util.Iterator;

public class WishList
{
    private ArrayList<WishListItem> wishListItems;

    public WishList()
    {
        wishListItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity)
    {
        WishListItem item = new WishListItem(product, quantity);
        wishListItems.add(item);
    }

    public Iterator<WishListItem> getItems()
    {
        return wishListItems.iterator();
    }
}
