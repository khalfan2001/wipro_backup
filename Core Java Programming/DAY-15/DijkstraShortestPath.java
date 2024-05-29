package com.day15;

import java.util.*;

public class DijkstraShortestPath {
    // Class to represent a node in the graph
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Class to represent the graph
    static class Graph {
        private int numVertices;
        private List<List<Node>> adjList;

        public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adjList.get(u).add(new Node(v, weight));
            adjList.get(v).add(new Node(u, weight)); // If the graph is undirected
        }

        public void dijkstra(int start) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] distances = new int[numVertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[start] = 0;
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int u = current.vertex;

                for (Node neighbor : adjList.get(u)) {
                    int v = neighbor.vertex;
                    int weight = neighbor.distance;
                    int newDist = distances[u] + weight;

                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                        pq.add(new Node(v, newDist));
                    }
                }
            }

            // Print the shortest distances
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < numVertices; i++) {
                System.out.println(i + " \t\t " + distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 9;
        Graph graph = new Graph(numVertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        int startVertex = 0;
        graph.dijkstra(startVertex);
    }
}
