package com.test;
import com.warehouse.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class MainTest {

    // Helper methods
    public static String getToken(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            } catch (IOException ioe) {
                System.exit(0);
            }
        }
    }

    public static boolean yesOrNo(String prompt) {
        String ans = getToken(prompt + " (Y|y)[es] or anything else for no");
        return ans.length() > 0 && (ans.charAt(0) == 'y' || ans.charAt(0) == 'Y');
    }

    // Demo runner
    public static void main(String[] args) {
        System.out.println("=== WarehouseSystem Quick Tester ===");

        // Create the system
        WarehouseSystem warehouse = new WarehouseSystem(); // has clientList + inventory
        System.out.println("Created WarehouseSystem.");

        // Add a Client
        String cname = "Alice";
        String caddr = "123 Main St";
        Client client = new Client(cname, caddr);
        warehouse.getClientList().insert(client); // insert into ClientList
        String clientId = client.getId();
        System.out.println("[Client] Added: " + client);
        System.out.println("[Client] Find by ID should return same client: "
                + warehouse.getClientList().findById(clientId));

        // Add a Product
        String pname = "Laptop";
        int stock = 10;
        double price = 1200.0;
        Product product = new Product(pname, stock, price);
        warehouse.getInventory().insert(product); // insert into ProductList
        String productId = product.getId();
        System.out.println("[Product] Added: " + product);
        System.out.println("[Product] Find by ID should return same product: "
                + warehouse.getInventory().findById(productId));

        // Add a Wishlist item for the client
        WishList wishList = client.getWishList();
        wishList.addItem(product, 2); // quantity 2

        // List wishlist contents
        System.out.println("[WishList] Listing items for client " + clientId + ":");
        int count = 0;
        for (Iterator<WishListItem> it = wishList.getItems(); it.hasNext(); ) {
            WishListItem item = it.next();
            count++;
            System.out.println("  - " + item.getProduct().getId() + " "
                    + item.getProduct().getName() + " qty=" + item.getQuantity());
        }
        System.out.println("Wishlist should have 1 item -> observed: " + count);

        // Add more via prompts (like the example tester)
        if (yesOrNo("Add another client?")) {
            String n = getToken("Enter name:");
            String a = getToken("Enter address:");
            Client c2 = new Client(n, a);
            warehouse.getClientList().insert(c2);
            System.out.println("[Client] Added: " + c2);
        }

        if (yesOrNo("Add another product?")) {
            String n = getToken("Enter product name:");
            int q = Integer.parseInt(getToken("Enter stock qty (int):"));
            double p = Double.parseDouble(getToken("Enter price (double):"));
            Product p2 = new Product(n, q, p);
            warehouse.getInventory().insert(p2);
            System.out.println("[Product] Added: " + p2);
        }

        // Final summaries
        System.out.println("\n=== Summary Checks ===");
        System.out.println((warehouse.getClientList().findById(clientId) != null)
                ? "OK: Client inserted & found"
                : "FAIL: Client not found");

        System.out.println((warehouse.getInventory().findById(productId) != null)
                ? "OK: Product inserted & found"
                : "FAIL: Product not found");

        System.out.println((count > 0)
                ? "OK: Wishlist has " + count + " item(s)"
                : "WARN: Wishlist appears empty (check WishList.addItem to store items)");

        System.out.println("\nDone.");
    }
}

