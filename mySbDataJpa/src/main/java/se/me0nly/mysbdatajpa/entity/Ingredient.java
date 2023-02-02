package se.me0nly.mysbdatajpa.entity;
import javax.persistence.*;
import java.util.Objects;
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(nullable = false,unique = true)
    private String ingredient;
    public Ingredient() {
    }
    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }
    public Ingredient(int id, String ingredient) {
        Id = id;
        this.ingredient = ingredient;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Id == that.Id && Objects.equals(ingredient, that.ingredient);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Id, ingredient);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "Id=" + Id +
                ", ingredient='" + ingredient + '\'' +
                '}';
    }
}