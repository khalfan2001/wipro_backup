package com.day28;

interface SensitiveObject {
    String getSecretKey(String password);
}

// Implement the SensitiveObjectImpl Class
class SensitiveObjectImpl implements SensitiveObject {
    private String secretKey = "ThisIsASecretKey";

    @Override
    public String getSecretKey(String password) {
        // No direct access in the implementation class, controlled by Proxy
        return secretKey;
    }
}

// Create the SensitiveObjectProxy Class
class SensitiveObjectProxy implements SensitiveObject {
    private SensitiveObjectImpl sensitiveObject;
    private String correctPassword;

    public SensitiveObjectProxy(String correctPassword) {
        this.sensitiveObject = new SensitiveObjectImpl();
        this.correctPassword = correctPassword;
    }

    @Override
    public String getSecretKey(String password) {
        if (password.equals(correctPassword)) {
            return sensitiveObject.getSecretKey(password);
        } else {
            throw new SecurityException("Access Denied: Incorrect Password");
        }
    }
}

// Main Class
public class Proxy {
    public static void main(String[] args) {
        String correctPassword = "securePassword";
        SensitiveObject proxy = new SensitiveObjectProxy(correctPassword);

        try {
            System.out.println("Attempting access with correct password:");
            String secretKey = proxy.getSecretKey("securePassword");
            System.out.println("Secret Key: " + secretKey);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Attempting access with incorrect password:");
            String secretKey = proxy.getSecretKey("wrongPassword");
            System.out.println("Secret Key: " + secretKey);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
