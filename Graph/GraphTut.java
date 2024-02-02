package Graph;

import java.util.*;

public class GraphTut {
    class Vertex {
        String label;

        Vertex(String label) {
            this.label = label;
        }
    }

    // adjacency List

    private Map<Vertex, List<Vertex>> adjVertices;

    // adding a vertex to graph
    void addVertex(String label) {
        adjVertices.put(new Vertex(label), new ArrayList<>());
    }

    // removing a vertex
    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }

    // adding a edge
    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    //removing an edge
    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    GraphTut createGraph() {
        GraphTut graph = new GraphTut();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    // To get the adjacent vertices
    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    // depth first search traversal
    Set<String> depthFirstTraversal(GraphTut graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            String vertex = stack.pop();
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                for(Vertex v: graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    //breadth first search traversal
    Set<String> breadthFirstTraversal(GraphTut graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }


}
