package com.irctc.exceptions;

// CustomException class extends the Exception class to create a custom exception type.
public class CustomException extends Exception {
    
    // Constructor that accepts a message for the exception.
    public CustomException(String message) {
        // Calls the constructor of the superclass (Exception) with the provided message.
        super(message);
    }
}
