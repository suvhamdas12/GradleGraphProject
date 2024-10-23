package com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Model;

public class Edge {
    private String sourceId;
    private String targetId;
    private double weight;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Edge(String sourceId, String targetId, double weight) {
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.weight = weight;
    }
}
