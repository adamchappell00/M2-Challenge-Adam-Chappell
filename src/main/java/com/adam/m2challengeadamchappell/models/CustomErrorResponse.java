package com.adam.m2challengeadamchappell.models;

// Java Imports
import java.time.LocalDateTime;
import java.util.Objects;

// Dependency Imports
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

public class CustomErrorResponse {

    // Fields
    private String errorMessage;
    private int errorStatus;
    private String errorCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD HH:MM:SS")
    private LocalDateTime timestamp;

    // Constructor
    public CustomErrorResponse(HttpStatus httpStatus, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorStatus = httpStatus.value();
        this.errorCode = httpStatus.toString();
        this.timestamp = LocalDateTime.now();
    }

    // Unique Methods : NONE

    // Standard Methods - Equals, HashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomErrorResponse that = (CustomErrorResponse) o;
        return errorStatus == that.errorStatus && Objects.equals(errorMessage, that.errorMessage) && Objects.equals(errorCode, that.errorCode) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessage, errorStatus, errorCode, timestamp);
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorStatus=" + errorStatus +
                ", errorCode='" + errorCode + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
    // Standard Methods - Getters & Setters
    public String getErrorMessage() {return errorMessage;}
    public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}

    public int getErrorStatus() {return errorStatus;}
    public void setErrorStatus(int errorStatus) {this.errorStatus = errorStatus;}

    public String getErrorCode() {return errorCode;}
    public void setErrorCode(String errorCode) {this.errorCode = errorCode;}

    public LocalDateTime getTimestamp() {return timestamp;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}
}