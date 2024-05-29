package com.day17;

public class BoyerMooreAlgorithm {

    
    public static int lastOccurrence(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        if (patternLength > textLength) {
            return -1;
        }

        int[] lastOccurrence = new int[256]; 
        for (int i = 0; i < 256; i++) {
            lastOccurrence[i] = -1; 
        }

       
        for (int i = 0; i < patternLength; i++) {
            lastOccurrence[pattern.charAt(i)] = i;
        }

        int index = patternLength - 1; 
        int patternIndex = patternLength - 1; 
        while (index < textLength) {
            char currentChar = text.charAt(index);
            if (currentChar == pattern.charAt(patternIndex)) {
                if (patternIndex == 0) {
                    return index; 
                }
                index--;
                patternIndex--;
            } else {
               
                int shift = patternIndex - lastOccurrence[currentChar];
                index += Math.max(1, shift); 
                patternIndex = patternLength - 1; 
            }
        }

        return -1; // Pattern not found
    }

    public static void main(String[] args) {
        String text = "ABACADABRAC";
        String pattern = "ABRA";
        //String pattern = "RAC";
        int lastIndex = lastOccurrence(text, pattern);
        if (lastIndex != -1) {
            System.out.println("Last occurrence found at index: " + lastIndex);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
