package com.example.crudsteels.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super("Error: Resource not Found!");
    }
}
