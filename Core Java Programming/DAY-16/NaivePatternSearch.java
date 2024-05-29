package com.day16;
import java.util.*;
public class NaivePatternSearch {

    public static void naivePatternSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int comparisonCount = 0;

        // List to store the starting indices of matches
        List<Integer> matchIndices = new ArrayList<>();

        // Slide the pattern over text one by one
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            // For current index i, check for pattern match
            for (j = 0; j < patternLength; j++) {
                comparisonCount++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            // If pattern[0...patternLength-1] = text[i, i+1, ...i+patternLength-1]
            if (j == patternLength) {
                matchIndices.add(i);
            }
        }

        // Output the results
        System.out.println("Pattern found at indices: " + matchIndices);
        System.out.println("Total comparisons made: " + comparisonCount);
    }

    public static void main(String[] args) {
        // Test cases
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
       
        naivePatternSearch(text, pattern);
    }
}