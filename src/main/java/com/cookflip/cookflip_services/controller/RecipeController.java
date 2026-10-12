/** this belongs to controller **/
package com.cookflip.cookflip_services.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// importing models
import com.cookflip.cookflip_services.models.Recipe;
import com.cookflip.cookflip_services.services.RecipeService;

import com.cookflip.cookflip_services.exceptions.RecipeNotFoundException;

// importing list ( hold array ? )
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

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
    public ResponseEntity<Recipe> getRecipesById(@PathVariable int id) {

        Recipe recipe = recipeService.getRecipeById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));

        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe){
        Recipe addedRecipes = recipeService.addRecipe(recipe);

        return ResponseEntity.status(HttpStatus.CREATED).body(addedRecipes);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {

        boolean deleted = recipeService.deleteRecipe(id);

        if (!deleted) {
            throw new RecipeNotFoundException(id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable int id,
            @Valid @RequestBody Recipe recipe) {

        Recipe updatedRecipe = recipeService.updateRecipeById(id, recipe)
                .orElseThrow(() -> new RecipeNotFoundException(id));

        return ResponseEntity.ok(updatedRecipe);
    }
}