package se.me0nly.mysbdatajpa.entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Recipe testObjectA;
    Recipe testObjectB;
    List<Recipe> testObjectCollection;

    Ingredient testIngredientA;
    Ingredient testIngredientB;

    RecipeIngredient testRecipeIngredientA;
    RecipeIngredient testRecipeIngredientB;

    List<RecipeIngredient> testIngredientCollection;

    RecipeInstruction testInstructionA;
    RecipeInstruction testInstructionB;

    RecipeCategory testCategoryA;
    RecipeCategory testCategoryB;
    List<RecipeCategory> testRecipeCategoryCollection;

    String testUUID;


    @BeforeEach
    void setUp() {

        // Ingredient
        testIngredientA = new Ingredient(1,"Ingredient A");
        testIngredientB = new Ingredient(2,"Ingredient B");

        // Recipe Ingredient
        testRecipeIngredientA =new RecipeIngredient(testUUID, testIngredientA, 3.0,Measurement.DECILITRE,testObjectA);
        testRecipeIngredientB =new RecipeIngredient(testUUID, testIngredientB, 5.0, Measurement.GRAM, testObjectB);

        // Collection of recipe ingredients
        testIngredientCollection = new ArrayList<>();
        testIngredientCollection.add(testRecipeIngredientA);
        testIngredientCollection.add(testRecipeIngredientB);

        // Recipe instruction
        testInstructionA = new RecipeInstruction();
        testInstructionB = new RecipeInstruction();


        // Recipe category
        testCategoryA = new RecipeCategory(1, "categoryNameA",testObjectCollection);
        testCategoryB = new RecipeCategory(2, "categoryNameB", testObjectCollection);


        // Collection of recipe categories
        testRecipeCategoryCollection = new ArrayList<>();
        testRecipeCategoryCollection.add(testCategoryA);
        testRecipeCategoryCollection.add(testCategoryB);

        // Recipe
        testObjectA = new Recipe(1, "Recipe 1",testIngredientCollection, testInstructionA,testRecipeCategoryCollection);
        testObjectB = new Recipe(2, "Recipe 2", testIngredientCollection, testInstructionB, testRecipeCategoryCollection);

        // Collection of recipes
        testObjectCollection = new ArrayList<>();
        testObjectCollection.add(testObjectA);
        testObjectCollection.add(testObjectB);

    }

    @Test
    @DisplayName("Test create object")
    public void test1() {
        Assertions.assertEquals(1,testObjectA.getId(1));
        assertEquals("Recipe 2", testObjectB.getRecipeName());
    }

    @Test
    @DisplayName("Test is present")
    public void test2 (){
        RecipeCategory expected = new RecipeCategory(1, "categoryNameA",null);
        Optional<RecipeCategory> actual = testObjectA.getRecipeCategoryCollection().stream().filter(recipeCategory -> recipeCategory.getCategoryName().equalsIgnoreCase("categoryNameA")).findFirst();
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());    }
}