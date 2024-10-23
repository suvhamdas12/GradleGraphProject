package com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Controller;

import com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Model.Edge;
import com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Model.Graph;
import com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Model.Node;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/graph")
public class GraphController {
    private final Graph graph = new Graph();

    @PostMapping("/nodes")
    public ResponseEntity<Node> addNode(@RequestBody NodeRequest request) {
        Node node = new Node(request.getLabel());
        graph.addNode(node);
        return ResponseEntity.ok(node);
    }

    @PostMapping("/edges")
    public ResponseEntity<Edge> addEdge(@RequestBody EdgeRequest request) {
        Edge edge = new Edge(request.getSourceId(), request.getTargetId(), request.getWeight());
        graph.addEdge(edge);
        return ResponseEntity.ok(edge);
    }

    @GetMapping("/shortestPath")
    public ResponseEntity<List<Node>> findShortestPath(
            @RequestParam String startId,
            @RequestParam String endId) {
        List<Node> path = graph.findShortestPath(startId, endId);
        return ResponseEntity.ok(path);
    }

    @GetMapping("/nodes")
    public ResponseEntity<List<Node>> getAllNodes() {
        return ResponseEntity.ok(List.copyOf(graph.getAllNodes()));
    }
}
