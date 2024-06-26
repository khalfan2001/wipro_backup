package com.liststackqueue;
//Assignment-1
public class main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        purchase history = new purchase();
        Cservice service = new Cservice();

        cart.addItem("Laptop");
        cart.addItem("Smartphone");
        cart.viewCart();

        history.savePurchase(cart.getCart());
        cart.clearCart();
        cart.viewCart(); 
        history.viewHistory();

        service.addRequest("Refund for order number:#5703");
        service.addRequest("Issue with product quality");
        service.viewPendingRequests();
        String processedRequest = service.processNextRequest();
        System.out.println("Processed Request: " + processedRequest);
        service.viewPendingRequests();
    }
}
