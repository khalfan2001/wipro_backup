package com.day24;

import java.util.function.*;

class Person1 {
    String name;
    int age;

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Person1 person = new Person1("John Doe", 25);

        Predicate<Person1> isAdult = p -> p.age >= 18;
        Function<Person1, String> getName = p -> p.name;
        Consumer<Person1> printName = p -> System.out.println(p.name);
        Supplier<Person1> newPerson = () -> new Person1("Jane Doe", 30);

        System.out.println("Is the person an adult? " + isAdult.test(person));
        System.out.println("The person's name is: " + getName.apply(person));
        printName.accept(person);
        Person1 newPersonObj = newPerson.get();
        System.out.println("A new person has been created with name: " + newPersonObj.name);
    }
}