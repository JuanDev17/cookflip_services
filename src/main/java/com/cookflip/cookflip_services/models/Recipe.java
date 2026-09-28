package com.cookflip.cookflip_services.models;

public class Recipe {
    // private variables
    private int id;
    private String title;
    private String description;
    private int cookTime;


    // recipe shape - object
    public Recipe(int id, String title, String description, int cookTime){
        this.id = id;
        this.title = title;
        this.description = description;
        this.cookTime = cookTime;
    }

    // getters to access ( make public to be shared )
    public int getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public int getCookTime() {
        return cookTime;
    }

}
