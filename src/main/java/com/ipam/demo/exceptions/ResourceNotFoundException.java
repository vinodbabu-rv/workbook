package com.ipam.demo.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource Not Found");
    }

    public ResourceNotFoundException(UUID id){
        super(id.toString());
    }
}
