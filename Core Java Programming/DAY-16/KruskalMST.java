package com.day16;

import java.util.*;

//Edge class to represent an edge in the graph
class Edge implements Comparable<Edge> {
 int src, dest, weight;

 public Edge(int src, int dest, int weight) {
     this.src = src;
     this.dest = dest;
     this.weight = weight;
 }

 @Override
 public int compareTo(Edge compareEdge) {
     return this.weight - compareEdge.weight;
 }
}

//Subset class for Union-Find
class Subset {
 int parent, rank;
}

public class KruskalMST {
 int V, E; // Number of vertices and edges
 Edge[] edges; // Array of edges

 // Constructor to create a graph with V vertices and E edges
 public KruskalMST(int v, int e) {
     V = v;
     E = e;
     edges = new Edge[E];
 }

 // Function to find the subset of an element i (uses path compression)
 int find(Subset[] subsets, int i) {
     if (subsets[i].parent != i)
         subsets[i].parent = find(subsets, subsets[i].parent);
     return subsets[i].parent;
 }

 // Function to do union of two subsets x and y (uses union by rank)
 void union(Subset[] subsets, int x, int y) {
     int xroot = find(subsets, x);
     int yroot = find(subsets, y);

     // Attach smaller rank tree under root of high rank tree
     if (subsets[xroot].rank < subsets[yroot].rank)
         subsets[xroot].parent = yroot;
     else if (subsets[xroot].rank > subsets[yroot].rank)
         subsets[yroot].parent = xroot;
     else {
         subsets[yroot].parent = xroot;
         subsets[xroot].rank++;
     }
 }

 // Function to construct MST using Kruskal's algorithm
 void kruskalMST() {
     // Result array to store the resultant MST
     Edge[] result = new Edge[V];
     int e = 0; // Index variable, used for result[]
     int i = 0; // Index variable, used for sorted edges

     for (i = 0; i < V; ++i)
         result[i] = new Edge(0, 0, 0);

     // Step 1: Sort all the edges in non-decreasing order of their weight
     Arrays.sort(edges);

     // Allocate memory for creating V subsets
     Subset[] subsets = new Subset[V];
     for (i = 0; i < V; ++i)
         subsets[i] = new Subset();

     // Create V subsets with single elements
     for (int v = 0; v < V; ++v) {
         subsets[v].parent = v;
         subsets[v].rank = 0;
     }

     i = 0; // Index used to pick the smallest edge

     // Number of edges to be taken is equal to V-1
     while (e < V - 1) {
         // Step 2: Pick the smallest edge. And increment the index for next iteration
         Edge nextEdge = edges[i++];

         int x = find(subsets, nextEdge.src);
         int y = find(subsets, nextEdge.dest);

         // If including this edge does not cause a cycle, include it in the result
         // and increment the index of the result for the next edge
         if (x != y) {
             result[e++] = nextEdge;
             union(subsets, x, y);
         }
         // Else discard the nextEdge
     }

     // Print the contents of the result[] to display the built MST
     System.out.println("Following are the edges in the constructed MST:");
     int minimumCost = 0;
     for (i = 0; i < e; ++i) {
         System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
         minimumCost += result[i].weight;
     }
     System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
 }

 public static void main(String[] args) {
     int V = 4; // Number of vertices in graph
     int E = 5; // Number of edges in graph
     KruskalMST graph = new KruskalMST(V, E);

     // add edge 0-1
     graph.edges[0] = new Edge(0, 1, 10);
     // add edge 0-2
     graph.edges[1] = new Edge(0, 2, 6);
     // add edge 0-3
     graph.edges[2] = new Edge(0, 3, 5);
     // add edge 1-3
     graph.edges[3] = new Edge(1, 3, 15);
     // add edge 2-3
     graph.edges[4] = new Edge(2, 3, 4);

     graph.kruskalMST();
 }
}
