package com.liststackqueue;
//Assignment-1
import java.util.LinkedList;

public class ShoppingCart {
    private LinkedList<String> cart;

    public ShoppingCart() {
        cart = new LinkedList<>();
    }

    public void addItem(String item) {
        cart.add(item);
    }

    public void removeItem(String item) {
        cart.remove(item);
    }

    public void viewCart() {
        System.out.println("Shopping Cart Items:");
        for (String item : cart) {
            System.out.println(item);
        }
    }

    public LinkedList<String> getCart() {
        return new LinkedList<>(cart);
    }

    public void clearCart() {
        cart.clear();
    }
}
