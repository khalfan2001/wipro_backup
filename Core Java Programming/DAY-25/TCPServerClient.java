package com.day25;

import java.io.*;
import java.net.*;

class Calculation implements Serializable {
    private static final long serialVersionUID = 1L;

    private double number1;
    private double number2;
    private String operation;

    public Calculation(double number1, double number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public double performOperation() {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    throw new ArithmeticException("Division by zero!");
                }
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", operation='" + operation + '\'' +
                '}';
    }
}

public class TCPServerClient {
    public static void main(String[] args) {
        final int portNumber = 12345;
        final String hostName = "localhost";

        // Server
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                System.out.println("Server: Waiting for client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Server: Client connected.");

                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                Calculation calculation = (Calculation) inputStream.readObject();

                System.out.println("Server: Received calculation: " + calculation);

                double result = calculation.performOperation();

                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                outputStream.writeDouble(result);
                outputStream.flush();

                System.out.println("Server: Result sent to client: " + result);

                clientSocket.close();
                System.out.println("Server: Connection closed.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        // Client
        Thread clientThread = new Thread(() -> {
            try (Socket socket = new Socket(hostName, portNumber)) {
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                Calculation calculation = new Calculation(2, 2, "+");
                outputStream.writeObject(calculation);
                outputStream.flush();
                System.out.println("Client: Calculation sent to server: " + calculation);

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                double result = inputStream.readDouble();
                System.out.println("Client: Received result from server: " + result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Start server and client threads
        serverThread.start();
        clientThread.start();
    }
}