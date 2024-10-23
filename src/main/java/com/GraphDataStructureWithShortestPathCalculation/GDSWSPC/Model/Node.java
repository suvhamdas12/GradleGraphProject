package com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Model;

import java.util.UUID;

public class Node {
    private String id;
    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Node(String label) {
        this.id = UUID.randomUUID().toString();
        this.label = label;
    }
}
