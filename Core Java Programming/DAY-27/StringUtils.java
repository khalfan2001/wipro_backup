package com.day27;
//Task-3 code testcases should writen
public class StringUtils {

    // Returns true if the string is null or empty
    public boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Reverses the given string
    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    // Checks if the string is a palindrome
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversedStr = reverse(str);
        return str.equals(reversedStr);
    }
}
