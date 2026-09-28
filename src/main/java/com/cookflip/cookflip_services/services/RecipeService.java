package com.cookflip.cookflip_services.services;

import com.cookflip.cookflip_services.models.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {

    // Integer is key ID, Recipe is value
    private final Map<Integer, Recipe> recipes = new HashMap<>();

//    private final List<Recipe> recipes =  List.of(
//            new Recipe(1, "Rice and Chicken", "Large grain rice, boneless chicken thighs, salt, pepper", 40),
//            new Recipe(2, "Veggie Taocs", "Tacos", 20)
//        );

    // instead of list, can use Collection
    public List<Recipe> getAllRecipes(){
        // turn the values into a list -
        return recipes.values().stream().toList();
    }

    public Recipe getRecipesById(int id){
//        Recipe recipe = recipes.stream()
//                .filter(r -> r.getId() == id)
//                .findFirst()
//                .orElse(null);
//        return recipe;
        return recipes.get(id);
    }

    public Recipe addRecipe(Recipe recipe){
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    public Recipe deleteRecipe(int id){
        return recipes.remove(id);
    }

    public Recipe updateRecipeById(int id, Recipe recipe){
        recipes.put(id, recipe);

        return recipe;
    }


}
