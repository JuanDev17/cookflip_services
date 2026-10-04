package com.cookflip.cookflip_services.services;

import com.cookflip.cookflip_services.models.Recipe;
import com.cookflip.cookflip_services.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {

    // Integer is key ID, Recipe is value
   // private final Map<Integer, Recipe> recipes = new HashMap<>();
    private RecipeRepository recipeRepository;

    // Connect to DB Repo
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

//    private final List<Recipe> recipes =  List.of(
//            new Recipe(1, "Rice and Chicken", "Large grain rice, boneless chicken thighs, salt, pepper", 40),
//            new Recipe(2, "Veggie Taocs", "Tacos", 20)
//        );

    // instead of list, can use Collection
    public List<Recipe> getAllRecipes(){
        // turn the values into a list -
       // return recipes.values().stream().toList();
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(int id){
//        Recipe recipe = recipes.stream()
//                .filter(r -> r.getId() == id)
//                .findFirst()
//                .orElse(null);
//        return recipe;
//        return recipes.get(id);
          return recipeRepository.findById(id);
    }

    public Recipe addRecipe(Recipe recipe){
        // don't need to create a new instance bc its already being handled in our Controller.
        return recipeRepository.save(recipe);

    }

    public void deleteRecipe(int id){
        recipeRepository.deleteById(id);
    }

    public Recipe updateRecipeById(int id, Recipe recipe) {

        Recipe singleRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id not found"));

        singleRecipe.setTitle(recipe.getTitle());
        singleRecipe.setDescription(recipe.getDescription());
        singleRecipe.setCookTime(recipe.getCookTime());

        return recipeRepository.save(singleRecipe);
    }


}
