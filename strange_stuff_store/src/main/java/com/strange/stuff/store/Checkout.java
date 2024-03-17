package com.strange.stuff.store;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private List<Product> cart;
    
    public Checkout() {
        cart = new ArrayList<>();
    }
    
    // Add product to cart
    public void addToCart(Product product) {
        cart.add(product);
    }
    
    // Calculate total in cart
    public double calculateTotal() {
        double total = 0.0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }
    
    // Finish shopping
    public void completePurchase() {
        // Verifica se há estoque suficiente para cada item no carrinho
        for (Product product : cart) {
            if (product.getQuantity() < 1) {
                System.out.println("sorry, the item " + product.getName() + " is sold out.");
                return;
            }
        }
        
        // Update stock
        double total = 0.0;
        for (Product product : cart) {
            total += product.getPrice();
            product.setQuantity(product.getQuantity() - 1); // Reduce stock
        }
        
        System.out.println("Purchase fineshed. The total is: $" + total);
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
            for (Product product : cart) {
                System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
            }
        }
    }
}
