package com.liststackqueue;
//Assignment-1
import java.util.Stack;
import java.util.LinkedList;

public class purchase {
    private Stack<LinkedList<String>> history;

    public purchase() {
        history = new Stack<>();
    }

    public void savePurchase(LinkedList<String> cart) {
        history.push(cart);
    }

    public LinkedList<String> undoLastPurchase() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public void viewHistory() {
        System.out.println("Purchase History:");
        for (LinkedList<String> cart : history) {
            System.out.println(cart);
        }
    }
}
