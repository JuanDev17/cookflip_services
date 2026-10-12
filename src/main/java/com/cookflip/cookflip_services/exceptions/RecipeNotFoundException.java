package com.cookflip.cookflip_services.exceptions;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(int id) {
        super("Recipe with ID " + id + " was not found");
    }
}