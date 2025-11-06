package com.warehouse;

public class Client {
    private static int nextId = 1;
    private final String id;
    private String name;
    private String address;
    private double balance = 0.0;
    private WishList wishList;

    public Client(String name, String address) {
        if (name == null || name.isBlank() || address == null || address.isBlank())
            throw new IllegalArgumentException("Name/address required");
        this.id = "C" + (nextId++);
        this.name = name;
        this.address = address;
        this.wishList = new WishList();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public WishList getWishList() { return wishList; }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name required");
        this.name = name;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank())
            throw new IllegalArgumentException("Address required");
        this.address = address;
    }

    public void adjustBalance(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return String.format("com.warehouse.Client[ID=%s, Name=%s, Address=%s, Balance=%.2f]",
                id, name, address, balance);
    }
}
