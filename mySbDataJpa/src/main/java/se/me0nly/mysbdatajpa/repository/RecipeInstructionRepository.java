package se.me0nly.mysbdatajpa.repository;
import org.springframework.data.repository.CrudRepository;
import se.me0nly.mysbdatajpa.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, String> {
}