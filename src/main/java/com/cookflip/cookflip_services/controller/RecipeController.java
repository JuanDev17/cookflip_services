/** this belongs to controller **/
package com.cookflip.cookflip_services.controller;

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
    public List<Recipe> getRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/recipes/{id}")
    // Recipe is model
    // no list, we want 1
    public Recipe getRecipesById(@PathVariable int id) {
        return recipeService.getRecipesById(id);
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public Recipe deleteRecipe(@PathVariable int id){
        return recipeService.deleteRecipe(id);
    }

    @PutMapping("/recipes/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe){
        return recipeService.updateRecipeById(id, recipe);
    }
}