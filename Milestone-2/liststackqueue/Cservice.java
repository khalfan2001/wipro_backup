package com.liststackqueue;
//Assignment-1
import java.util.LinkedList;
import java.util.Queue;

public class Cservice {
    private Queue<String> serviceRequests;

    public Cservice() {
        serviceRequests = new LinkedList<>();
    }

    public void addRequest(String request) {
        serviceRequests.add(request);
    }

    public String processNextRequest() {
        return serviceRequests.poll();
    }

    public void viewPendingRequests() {
        System.out.println("Pending Customer Service Requests:");
        for (String request : serviceRequests) {
            System.out.println(request);
        }
    }
}
