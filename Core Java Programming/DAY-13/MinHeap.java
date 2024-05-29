package com.Day13;

public class MinHeap {
	 private int[] heap;
	 private int size;
	 private int capacity;
	 public MinHeap(int capacity) {
	 this.capacity = capacity;
	 this.size = 0;
	 this.heap = new int[capacity];
	 }
	 private int parent(int index) {
	 return (index - 1) / 2;
	 }
	 private int leftChild(int index) {
	 return 2 * index + 1;
	 }
	 private int rightChild(int index) {
	 return 2 * index + 2;
	 }
	 public void insert(int key) {
	 if (size == capacity) {
	 throw new IllegalStateException("Heap is full");
	 }
	 heap[size] = key;
	 int current = size;
	 size++;
	 while (current != 0 && heap[parent(current)] > heap[current]) {
	 swap(current, parent(current));
	 current = parent(current);
	 } }
	 public int extractMin() {
	 if (size == 0) {
	 throw new IllegalStateException("Heap is empty");
	 }
	 if (size == 1) {
	 size--;
	 return heap[0];
	 }
	 int root = heap[0];
	 heap[0] = heap[size - 1];
	 size--;
	 heapify(0);
	 return root;
	 }
	 public int getMin() {
	 if (size == 0) {
	 throw new IllegalStateException("Heap is empty");
	 }
	 return heap[0];
	 }
	 private void heapify(int i) {
	 int smallest = i;
	 int left = leftChild(i);
	 int right = rightChild(i);
	 if (left < size && heap[left] < heap[smallest]) {
	 smallest = left;
	 }
	 if (right < size && heap[right] < heap[smallest]) {
	 smallest = right;
	 }
	 if (smallest != i) {
	 swap(i, smallest);
	 heapify(smallest);
	 } }
	 private void swap(int i, int j) {
	 int temp = heap[i];
	 heap[i] = heap[j];
	 heap[j] = temp;
	 }
	 public static void main(String[] args) {
	 MinHeap minHeap = new MinHeap(10);
	 minHeap.insert(3);
	 minHeap.insert(2);
	 minHeap.insert(1);
	 minHeap.insert(15);
	 minHeap.insert(5);
	 minHeap.insert(4);
	 minHeap.insert(45);
	 System.out.println("Minimum element: " + minHeap.getMin()); // Output: 1
	 System.out.println("Extracted min: " + minHeap.extractMin()); // Output: 1
	 System.out.println("Minimum element: " + minHeap.getMin()); // Output: 2
	 System.out.println("Extracted min: " + minHeap.extractMin()); // Output: 2
	 System.out.println("Minimum element: " + minHeap.getMin()); // Output: 3
	 } }