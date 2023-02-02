package se.me0nly.mysbdatajpa.repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import se.me0nly.mysbdatajpa.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


    List<Ingredient> findIngredientByIngredient (String ingredient);

    List<Ingredient> findIngredientsByIngredientContains (String ingredient);



}