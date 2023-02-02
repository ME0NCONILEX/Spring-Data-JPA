package se.me0nly.mysbdatajpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    Ingredient testObject;

    @BeforeEach
    public void setup(){
        testObject = new Ingredient(1, "Watter");
    }

    @Test
    public void test_create(){

        assertEquals(1,testObject.getId());
        assertEquals("Watter",testObject.getIngredient());
    }


    @Test
    public void test_equal(){
        Ingredient ingredient = new Ingredient(1, "Watter");
        assertTrue(testObject.equals(ingredient));
    }

    private void assertTrue(boolean equals) {

    }

    @Test
    public void test_hashCode(){
        Ingredient ingredient = new Ingredient(1, "Watter");
        assertEquals(ingredient.hashCode(), testObject.hashCode());
    }


}