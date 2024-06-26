package com.search;
//Assignmnet-2
public class management {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        System.out.println("All books in the library:");
        library.displayAllBooks();

        String searchTitle = "1984";
        Book foundBookLinear = library.linearSearch(searchTitle);
        System.out.println("\nLinear Search - Book found: " + foundBookLinear);

        Book foundBookBinary = library.binarySearch(searchTitle);
        System.out.println("\nBinary Search - Book found: " + foundBookBinary);
        
        long startTime = System.nanoTime();
        library.linearSearch(searchTitle);
        long endTime = System.nanoTime();
        System.out.println("\nLinear Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        library.binarySearch(searchTitle);
        endTime = System.nanoTime();
        System.out.println("Binary Search Time: " + (endTime - startTime) + " ns");
    }
}
