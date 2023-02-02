package se.me0nly.mysbdatajpa.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.me0nly.mysbdatajpa.entity.Recipe;
import se.me0nly.mysbdatajpa.entity.RecipeCategory;
import se.me0nly.mysbdatajpa.entity.RecipeIngredient;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findRecipesByRecipeNameContains (String recipeName);

    List<Recipe> findRecipesByIngredientCollection_Ingredient_Ingredient (String ingredient);

    List<Recipe> findRecipesByRecipeCategoryCollectionCategoryName (String categoryName);

    List<Recipe> findRecipesByRecipeCategoryCollection_RecipeCollection_RecipeName (String recipeName);

}
