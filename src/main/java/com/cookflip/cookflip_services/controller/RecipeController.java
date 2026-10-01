/** this belongs to controller **/
package com.cookflip.cookflip_services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// importing models
import com.cookflip.cookflip_services.models.Recipe;
import com.cookflip.cookflip_services.services.RecipeService;

// importing list ( hold array ? )
import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public ResponseEntity <List<Recipe>> getRecipes() {
        // create instance
        List<Recipe> recipes = recipeService.getAllRecipes();

        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recipes/{id}")
    // Recipe is model
    // no list, we want 1
    public ResponseEntity<Recipe> getRecipesById(@PathVariable int id) {
       Recipe recipeId = recipeService.getRecipesById(id);

       return ResponseEntity.ok(recipeId);
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
        Recipe addedRecipes = recipeService.addRecipe(recipe);

        return ResponseEntity.status(201).body(addedRecipes);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id){
        recipeService.deleteRecipe(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody Recipe recipe){
       Recipe updatedRecipe = recipeService.updateRecipeById(id, recipe);

        return ResponseEntity.status(HttpStatus.OK).body(updatedRecipe);
    }
}