package Graph;

import java.util.*;
import java.util.LinkedList;

public class GraphTutorial {
    // Implementng adjacency List

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src=src;
            this.dest= dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Before the arrayList is null So can't assign elements
        // So the below loop empties the arrayList
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2, 2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }

    // BFS Traversal
    public static void bfsTraversal(ArrayList<Edge> graph[], int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        queue.add(0);

        while(!queue.isEmpty()) {
            int curr = queue.remove();
            if(!visited[curr]) {
                System.out.println(curr);
                visited[curr] = true;

                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }


    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        // print 2's neighbours
        for(int i=0; i<graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.weight + " ");
        }
    }
}
