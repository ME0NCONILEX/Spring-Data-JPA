package se.me0nly.mysbdatajpa.entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class RecipeCategoryTest {
    Recipe r1;
    Recipe r2;
    RecipeCategory testObject;
    List<Recipe> recipeCollectionTest;

    @BeforeEach
    void setUp() {

        testObject = new RecipeCategory(1, "RecipeCategory test1");
        testObject.setId(1);
        testObject.setCategoryName("test1");


        recipeCollectionTest = new ArrayList<>();

        r1 = new Recipe(1, "Ice Cream1", "instruction 1");
        r2 = new Recipe(2, "Ice Cream2", "instruction 2");

        recipeCollectionTest.add(r1);
        recipeCollectionTest.add(r2);

        testObject.setRecipeCollection(recipeCollectionTest);
    }
    @Test
    @DisplayName("Test create object")
    public void test1(){
        assertEquals(1, testObject.getId());
        assertEquals("test1", testObject.getCategoryName());
        assertEquals(2, testObject.getRecipeCollection().size());

    }
}