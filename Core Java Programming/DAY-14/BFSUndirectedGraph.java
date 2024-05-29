package com.Day14;
import java.util.*;

public class BFSUndirectedGraph {
    private int numVertices; // Number of vertices in the graph
    private LinkedList<Integer> adjList[]; // Adjacency list

    // Constructor
    public BFSUndirectedGraph(int vertices) {
        numVertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjList[v].add(w); // Add w to v's list.
        adjList[w].add(v); // Add v to w's list since it's undirected
    }

    // BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited (false)
        boolean visited[] = new boolean[numVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFSUndirectedGraph g = new BFSUndirectedGraph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println("Following is Breadth First Traversal " +
                           "(starting from vertex 0):");
        g.BFS(0);
    }
}
