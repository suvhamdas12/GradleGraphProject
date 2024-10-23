package com.GraphDataStructureWithShortestPathCalculation.GDSWSPC.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ErrorResponse {
    private int status;
    private String message;
    private String details;

    // Constructor
    public ErrorResponse(int status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}