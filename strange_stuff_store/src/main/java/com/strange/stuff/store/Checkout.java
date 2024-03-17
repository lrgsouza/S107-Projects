package com.strange.stuff.store;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Map<Product, Integer> cart; // Usaremos um mapa para rastrear a quantidade de cada produto no carrinho
    
    public Checkout() {
        cart = new HashMap<>();
    }
    
    // Add product to cart
    public void addToCart(Product product, int quantity) {
        cart.put(product, quantity);
    }
    
    // Calculate total in cart
    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
    
    // Finish shopping
    public void completePurchase() {
        // Check if there is enough stock for each item in the cart
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantityInCart = entry.getValue();
            if (product.getQuantity() < quantityInCart) {
                System.out.println("Sorry, the item " + product.getName() + " is sold out.");
                return;
            }
        }
        
        // Update stock
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantityInCart = entry.getValue();
            total += product.getPrice() * quantityInCart;
            product.setQuantity(product.getQuantity() - quantityInCart); // Reduce stock
        }
        
        System.out.println("Purchase finished. The total is: $" + total);
    }
    
    // Clean the cart up
    public void clearCart() {
        cart.clear();
    }
    
    // Show items in cart
    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in cart:");
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("- " + product.getName() + " ($" + product.getPrice() + ") x " + quantity);
            }
        }
    }
}
