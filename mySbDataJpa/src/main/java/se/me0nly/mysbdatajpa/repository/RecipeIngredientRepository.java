package se.me0nly.mysbdatajpa.repository;
import org.springframework.data.repository.CrudRepository;
import se.me0nly.mysbdatajpa.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {
}