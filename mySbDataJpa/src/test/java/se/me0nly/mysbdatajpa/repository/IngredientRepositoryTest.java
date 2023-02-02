package se.me0nly.mysbdatajpa.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.me0nly.mysbdatajpa.entity.Ingredient;
import se.me0nly.mysbdatajpa.repository.IngredientRepository;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    IngredientRepository testObject;
    Ingredient ingredient;


    @BeforeEach
    public void setup(){
        ingredient = new Ingredient(1,"ingredientA");
        testObject.save(ingredient);

    }

    @Test
    @DisplayName("Testing find Ingredient By Ingredient")
    public void test1(){
        List<Ingredient> ingredient = testObject.findIngredientByIngredient("ingredientA");
        ingredient.forEach(System.out::println);

    }

    @Test
    public void findIngredientsByIngredientContains (){
        List<Ingredient> result = testObject.findIngredientsByIngredientContains("dien");
        result.forEach(System.out::println);
    }

}
