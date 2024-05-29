package com.day17;

public class RabinKarpAlgorithm {

    private static final int PRIME = 101; 

   
    private static long calculateHash(String str, int length) {
        long hashValue = 0;
        for (int i = 0; i < length; i++) {
            hashValue += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hashValue;
    }

    
    private static long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash /= PRIME;
        newHash += str.charAt(newIndex) * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    
    public static void search(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        long patternHash = calculateHash(pattern, patternLength);
        long textHash = calculateHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && text.substring(i, i + patternLength).equals(pattern)) {
                System.out.println("Pattern found at index " + i);
            }
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, i, i + patternLength, textHash, patternLength);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABAB";
        //Sting pattern = "BDA";
        search(pattern, text);
    }
}
