package com.example.crudsteels.services;

import com.example.crudsteels.models.ValidationError;

import java.util.List;

public interface HelperFunctions
{
    List<ValidationError> getConstraintViolation(Throwable cause);

    boolean isAuthorizedToMakeChange(String username);
}
