package se.me0nly.mysbdatajpa.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;
@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(nullable = false, unique = true)
    private String categoryName;
    @ManyToMany (cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable (
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    List<Recipe> recipeCollection;
    public RecipeCategory(int i, String recipeCategoryTest1) {
    }
    public RecipeCategory(String categoryName, List<Recipe> recipeCollection) {
        this.categoryName = categoryName;
        this.recipeCollection = recipeCollection;
    }
    public RecipeCategory(int id, String categoryName, List<Recipe> recipeCollection) {
        Id = id;
        this.categoryName = categoryName;
        this.recipeCollection = recipeCollection;
    }
    public RecipeCategory() {
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public List<Recipe> getRecipeCollection() {
        return recipeCollection;
    }
    public void setRecipeCollection(List<Recipe> recipeCollection) {
        this.recipeCollection = recipeCollection;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return Id == that.Id && Objects.equals(categoryName, that.categoryName) && Objects.equals(recipeCollection, that.recipeCollection);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Id, categoryName, recipeCollection);
    }
    @Override
    public String toString() {
        return "RecipeCategory{" +
                "Id=" + Id +
                ", recipeName='" + categoryName + '\'' +
                ", recipeCollection=" + recipeCollection +
                '}';
    }
    public void save(RecipeCategory recipeCategoryTest1) {
    }
    public boolean findAll() {
        return false;
    }
}