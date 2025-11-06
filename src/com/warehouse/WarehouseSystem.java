package com.warehouse;

public class WarehouseSystem
{
    private ClientList clientList;
    private ProductList inventory;

    public  WarehouseSystem()
    {
        clientList = new ClientList();
        inventory = new ProductList();
    }

    public ClientList getClientList()
    {
        return clientList;
    }

    public ProductList getInventory()
    {
        return inventory;
    }

}
