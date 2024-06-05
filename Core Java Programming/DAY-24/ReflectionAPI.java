package com.day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class MyClass {
    private String privateField = "Initial Value";

    public MyClass() {}

    public void publicMethod() {
        System.out.println("Public Method Called");
    }

    private void privateMethod() {
        System.out.println("Private Method Called");
    }
}

public class ReflectionAPI {
    public static void main(String[] args) {
        try {
            Class<MyClass> clazz = MyClass.class;

            // Inspect constructors
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }

            // Inspect methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println("  " + method);
            }

            // Inspect fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println("  " + field);
            }

            // Modify private field access level and set its value
            Field privateField = clazz.getDeclaredField("privateField");
            privateField.setAccessible(true);
            MyClass myClassInstance = new MyClass();
            privateField.set(myClassInstance, "New Value");

            // Verify the new value of the private field
            System.out.println("\nModified private field value: " + privateField.get(myClassInstance));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}