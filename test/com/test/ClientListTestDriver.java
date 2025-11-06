package com.test;

import com.warehouse.*;

public class ClientListTestDriver {
    public static void main(String[] args) {
        WarehouseSystem ws = new WarehouseSystem();
        ClientList clients = ws.getClientList();

        // Add a couple clients using your constructor
        clients.insert(new Client("Alice Lee", "10 Pine St"));
        clients.insert(new Client("Bob Kim", "200 Oak Ave"));

        System.out.println("== Clients ==");
        for (Client c : clients) {
            // Use getters that exist in your Client class
            System.out.println(
                c.getId() + " | " + c.getName() + " | " + c.getAddress()
                + " | balance=" + String.format("%.2f", c.getBalance())
            );
        }

        // Find the first client by id and print a quick confirmation
        String firstId = clients.iterator().hasNext() ? clients.iterator().next().getId() : null;
        if (firstId != null) {
            Client found = clients.findById(firstId);
            System.out.println("\nFind by id (" + firstId + "): "
                + (found != null ? "Found " + found.getName() : "Not found"));
        } else {
            System.out.println("\nNo clients in list.");
        }
    }
}
