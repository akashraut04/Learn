package com.example.demo.First.project.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException() {
        super("Not Found");
    }
}
