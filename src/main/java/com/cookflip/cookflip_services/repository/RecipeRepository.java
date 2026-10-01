package com.cookflip.cookflip_services.repository;

import com.cookflip.cookflip_services.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

// Recipe is Entity this repo manages,
// Integer - Type of Recipes @Id
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}