package se.me0nly.mysbdatajpa.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.me0nly.mysbdatajpa.entity.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    RecipeRepository testObjectRecipeRepository;

    Recipe testRecipeR1;
    Recipe testRecipeR2;
    List<Recipe> testRecipeCollection;

    Ingredient testIngredientI1;
    Ingredient testIngredientI2;

    RecipeIngredient testRecipeIngredientRI1;
    RecipeIngredient testRecipeIngredientRI2;

    List<RecipeIngredient> testIngredientCollection;

    RecipeInstruction testInstructionRINS1;
    RecipeInstruction testInstructionRINS2;
    List<RecipeInstruction> testRecipeList;

    RecipeCategory testCategoryRC1;
    RecipeCategory testCategoryRC2;
    List<RecipeCategory> testRecipeCategoryCollection;

    Recipe result;

    @BeforeEach
    public void setup() {

        // Ingredient
        testIngredientI1 = new Ingredient("Ingredient I1");
        testIngredientI2 = new Ingredient("Ingredient I2");

        // Recipe Ingredient
        Recipe testRecipeR1 = null;
        RecipeIngredient testRecipeIngredientI1 = new RecipeIngredient(testIngredientI1, 3, MeasurementRepository.DECILITRE, null);
        Recipe testRecipeR2 = null;
        RecipeIngredient testRecipeIngredientI2 = new RecipeIngredient(testIngredientI2, 5, MeasurementRepository.GRAM, null);

        // Collection of recipe ingredients
        testIngredientCollection = new ArrayList<>();
        testIngredientCollection.add(testRecipeIngredientI1);
        testIngredientCollection.add(testRecipeIngredientI2);

        // Recipe instruction
        RecipeInstruction testInstructionINS1 = new RecipeInstruction("Instruction INS1");
        RecipeInstruction testInstructionINS2 = new RecipeInstruction("Instruction INS2");

        // Recipe category
        RecipeCategory testCategoryI1 = new RecipeCategory("Starter", testRecipeCollection);
        // testCategoryI2 = new RecipeCategory( "Main0 start", testRecipeCollection);

        // Collection of recipe categories
        testRecipeCategoryCollection = new ArrayList<>();
        RecipeCategory testCategoryC1 = null;
        testRecipeCategoryCollection.add(null);
        RecipeCategory testCategoryC2 = null;
        testRecipeCategoryCollection.add(null);

        // Recipe
        RecipeInstruction testInstructionIC1 = null;
        testRecipeR1 = new Recipe( "Recipe1", testIngredientCollection, null, testRecipeCategoryCollection);
        testRecipeR2 = new Recipe( "Recipe2", testIngredientCollection, testInstructionINS2, testRecipeCategoryCollection);

        // Collection of recipes
        testRecipeCollection = new ArrayList<>();
        Recipe testRecipeIC1 = null;
        testRecipeCollection.add(null);
        Recipe testRecipeIC2 = null;
        testRecipeCollection.add(null);

//      testObjectRecipeRepository.save(testRecipeR1);
//      testObjectRecipeRepository.save(null);
    }
    @Test
    @DisplayName(value = "test_categories")
    public void test_categories() {
        List<String> result = Arrays.asList( "testCategoryC1", "testCategoryC2");
    }
    @Test
    public void findRecipesByRecipeNameContains(){
        List<Recipe> listRecipe = testObjectRecipeRepository.findRecipesByRecipeNameContains("rea");

    }
   @Test
    public void findRecipes_IngredientCollection_Ingredient (){
        List<Recipe> listRecipe = testObjectRecipeRepository.findRecipesByIngredientCollection_Ingredient_Ingredient("Watter");
    }

    @Test
    public void findRecipesByRecipeCategoryCollection(){
        List<Recipe> listRecipe = testObjectRecipeRepository.findRecipesByRecipeCategoryCollectionCategoryName("Starter");
    }

   @Test
    public void findRecipesByRecipeCategoryCollectionContainsRecipeName(){
        testObjectRecipeRepository.findRecipesByRecipeCategoryCollection_RecipeCollection_RecipeName("Starter");
    }
}
