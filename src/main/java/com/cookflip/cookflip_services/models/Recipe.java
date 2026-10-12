package com.cookflip.cookflip_services.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Recipe {
    // private variables
    @Id
    // Hibernate/JPA is telling PostgreSQL to use its identity mechanism to generate the ID.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Title field can't be blanked")
    private String title;
    @NotBlank(message = "Description field can't be blanked")
    private String description;
    @Min(value = 1, message = "Cook time must be at least one minute.")
    private int cookTime;

    // JPA needs this to create empty object
    protected Recipe(){
    }


    // recipe shape - object
    // Java is expecting this shape.
    // constructor
    public Recipe(String title, String description, int cookTime){
        this.title = title;
        this.description = description;
        this.cookTime = cookTime;
    }

    // getters to access ( make public to be shared )
    public int getId() {
        return id;
    }

    public String getTitle(){
        //return title;
        return this.title;
    }

    public String getDescription(){
        return description;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCookTime(int cookTime){
        this.cookTime = cookTime;
    }



}
