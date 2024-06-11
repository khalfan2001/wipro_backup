package com.day28;

import java.util.Arrays;

//Define the SortingStrategy Interface
interface SortingStrategy {
 void sort(int[] numbers);
}

//Implement the BubbleSortStrategy Class
class BubbleSortStrategy implements SortingStrategy {
 @Override
 public void sort(int[] numbers) {
     int n = numbers.length;
     for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
             if (numbers[j] > numbers[j + 1]) {
                 // Swap numbers[j] and numbers[j+1]
                 int temp = numbers[j];
                 numbers[j] = numbers[j + 1];
                 numbers[j + 1] = temp;
             }
         }
     }
     System.out.println("Sorted using BubbleSort: " + Arrays.toString(numbers));
 }
}

//Implement the QuickSortStrategy Class
class QuickSortStrategy implements SortingStrategy {
 @Override
 public void sort(int[] numbers) {
     quickSort(numbers, 0, numbers.length - 1);
     System.out.println("Sorted using QuickSort: " + Arrays.toString(numbers));
 }

 private void quickSort(int[] numbers, int low, int high) {
     if (low < high) {
         int pi = partition(numbers, low, high);
         quickSort(numbers, low, pi - 1);
         quickSort(numbers, pi + 1, high);
     }
 }

 private int partition(int[] numbers, int low, int high) {
     int pivot = numbers[high];
     int i = (low - 1);
     for (int j = low; j < high; j++) {
         if (numbers[j] < pivot) {
             i++;
             int temp = numbers[i];
             numbers[i] = numbers[j];
             numbers[j] = temp;
         }
     }
     int temp = numbers[i + 1];
     numbers[i + 1] = numbers[high];
     numbers[high] = temp;
     return i + 1;
 }
}

//Implement the Context Class
class Context {
 private SortingStrategy strategy;

 public void setStrategy(SortingStrategy strategy) {
     this.strategy = strategy;
 }

 public void executeStrategy(int[] numbers) {
     strategy.sort(numbers);
 }
}

//Main Class
public class Stratigy {
 public static void main(String[] args) {
     Context context = new Context();

     int[] numbers = { 64, 34, 25, 12, 22, 11, 90 };

     // Using BubbleSortStrategy
     context.setStrategy(new BubbleSortStrategy());
     context.executeStrategy(numbers.clone());  // Clone to keep original array unsorted

     // Using QuickSortStrategy
     context.setStrategy(new QuickSortStrategy());
     context.executeStrategy(numbers.clone());  // Clone to keep original array unsorted
 }
}
