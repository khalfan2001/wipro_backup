package com.day17;

public class KMPAlgorithm {
      private static int[] computeLPSArray(String pattern) {
        int length = 0; 
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0; 
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // (pattern[i] != pattern[length])
                if (length != 0) {
                    length = lps[length - 1];
                    // Note that we do not increment i here
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to search the pattern in the text using the KMP algorithm
    public static void KMPSearch(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();

        // Preprocess the pattern (calculate lps array)
        int[] lps = computeLPSArray(pattern);

        int i = 0;
        int j = 0;
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                System.out.println("Found pattern at index: " + (i - j));
                j = lps[j - 1];
            }
            // mismatch after j matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABAB";
        //String pattern = "ABC";//output: index 12
        KMPSearch(pattern, text);
    }
}