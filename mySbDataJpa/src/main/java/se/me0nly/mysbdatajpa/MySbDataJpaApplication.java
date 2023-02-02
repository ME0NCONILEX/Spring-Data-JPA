package se.me0nly.mysbdatajpa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.me0nly.mysbdatajpa.entity.Ingredient;
import se.me0nly.mysbdatajpa.entity.Recipe;
import se.me0nly.mysbdatajpa.entity.RecipeCategory;
import se.me0nly.mysbdatajpa.repository.IngredientRepository;
import se.me0nly.mysbdatajpa.repository.MeasurementRepository;
import se.me0nly.mysbdatajpa.repository.RecipeRepository;
import javax.transaction.Transactional;
@SpringBootApplication
public class MySbDataJpaApplication {
      private void insertMoreIngredients(IngredientRepository repository) {
        repository.save(new Ingredient(1, "Meal"));
        repository.save(new Ingredient(2, "Lind flower"));
        repository.save(new Ingredient(3, "Potato flour"));
        repository.save(new Ingredient(4, "Organic Herbal Tea"));
        repository.save(new Ingredient(5, "Cinnamon"));
        repository.save(new Ingredient(6, "Salt"));
        repository.save(new Ingredient(7, "Pepper"));
        repository.save(new Ingredient(8, "Camomile"));
        repository.save(new Ingredient(9, "Sugar"));
        repository.save(new Ingredient(10, "My flower"));
        repository.save(new Ingredient(11, "Black currant flower"));
        repository.save(new Ingredient(12, "Oil"));
        repository.save(new Ingredient(13, "GPDR grease"));
        repository.save(new Ingredient(14, "Tomato"));
        repository.save(new Ingredient(15, "Chicken bone"));
        repository.save(new Ingredient(16, "Flesh"));
        repository.save(new Ingredient(17, "Pulp"));
        repository.save(new Ingredient(18, "Veal"));
        repository.save(new Ingredient(19, "Chicken breast"));
        repository.save(new Ingredient(20, "Mutton"));
    }
    @Bean
    public CommandLineRunner run(IngredientRepository repository) {
        return (args) -> {
            insertMoreIngredients(repository);
            System.out.println(repository.findAll());
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(MySbDataJpaApplication.class, args);
    }
}
