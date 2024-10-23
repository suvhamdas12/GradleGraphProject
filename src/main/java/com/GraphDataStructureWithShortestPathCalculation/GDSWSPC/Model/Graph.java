package com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Model;

import java.util.*;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodes;
    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        this.nodes = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.put(node.getId(), node);
        adjacencyList.put(node.getId(), new ArrayList<>());
    }

    public void addEdge(Edge edge) {
        if (!nodes.containsKey(edge.getSourceId()) || !nodes.containsKey(edge.getTargetId())) {
            throw new IllegalArgumentException("Source or target node does not exist");
        }
        adjacencyList.get(edge.getSourceId()).add(edge);
    }

    public List<Node> findShortestPath(String startId, String endId) {
        if (!nodes.containsKey(startId) || !nodes.containsKey(endId)) {
            throw new IllegalArgumentException("Start or end node does not exist");
        }

        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(
                Comparator.comparingDouble(distances::get));

        // Initialize distances
        nodes.keySet().forEach(nodeId -> distances.put(nodeId, Double.POSITIVE_INFINITY));
        distances.put(startId, 0.0);
        queue.add(startId);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(endId)) {
                break;
            }

            for (Edge edge : adjacencyList.get(current)) {
                double newDist = distances.get(current) + edge.getWeight();

                if (newDist < distances.get(edge.getTargetId())) {
                    distances.put(edge.getTargetId(), newDist);
                    previousNodes.put(edge.getTargetId(), current);
                    queue.add(edge.getTargetId());
                }
            }
        }

        if (!previousNodes.containsKey(endId)) {
            throw new IllegalStateException("No path exists between the nodes");
        }

        // Reconstruct path
        List<Node> path = new ArrayList<>();
        String current = endId;
        while (current != null) {
            path.add(0, nodes.get(current));
            current = previousNodes.get(current);
        }

        return path;
    }

    public Node getNode(String id) {
        return nodes.get(id);
    }

    public Collection<Node> getAllNodes() {
        return nodes.values();
    }

    public List<Edge> getEdges(String nodeId) {
        return adjacencyList.getOrDefault(nodeId, new ArrayList<>());
    }
}
