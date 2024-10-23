package com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Controller;
import lombok.Data;

@Data
public class EdgeRequest {
    private String sourceId;
    private String targetId;
    private double weight;
}
