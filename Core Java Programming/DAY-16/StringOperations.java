package com.day16;

public class StringOperations {

    public static String concatReverseMiddle(String str1, String str2, int length) {
        // Concatenate the two strings
        String concatenated = str1 + str2;

        // Reverse the concatenated string
        String reversed = new StringBuilder(concatenated).reverse().toString();

        // Determine the start position for the middle substring
        int totalLength = reversed.length();
        int start = (totalLength - length) / 2;

        // Handle edge cases
        if (totalLength == 0 || length <= 0) {
            return "";
        }
        if (length >= totalLength) {
            return reversed;
        }

        // Extract and return the middle substring
        return reversed.substring(start, start + length);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(concatReverseMiddle("hello", "world", 5)); // Output: "oworl"
        System.out.println(concatReverseMiddle("java", "programming", 3)); // Output: "mav"
        System.out.println(concatReverseMiddle("test", "", 4)); // Output: "tset"
        System.out.println(concatReverseMiddle("", "case", 2)); // Output: "es"
        System.out.println(concatReverseMiddle("short", "example", 20)); // Output: "elpmaxeshtros"
    }
}
