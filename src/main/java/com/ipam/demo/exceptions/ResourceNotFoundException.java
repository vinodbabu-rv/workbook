package com.ipam.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource Not Found Vinod");
    }

    public ResourceNotFoundException(String id){
        super(id);
    }
}
