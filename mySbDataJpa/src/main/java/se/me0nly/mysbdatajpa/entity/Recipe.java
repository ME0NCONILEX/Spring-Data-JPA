package se.me0nly.mysbdatajpa.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Objects;
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(nullable = false,unique = true)
    private String recipeName;
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "recipe_ingredient_id")
    private List<RecipeIngredient> ingredientCollection;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_instruction_id", unique = true)
    private RecipeInstruction recipeInstruction;
    @ManyToMany (cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable (name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id")
    )
    private List<RecipeCategory> recipeCategoryCollection;

    public Recipe(int i, String iceCream1, String s) {
    }
    public Recipe(int id, String recipeName, List<RecipeIngredient> ingredientCollection, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategoryCollection) {
        Id = id;
        this.recipeName = recipeName;
        this.ingredientCollection = ingredientCollection;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategoryCollection = recipeCategoryCollection;
    }
    public Recipe(String recipeName, List<RecipeIngredient> ingredientCollection, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategoryCollection) {
        this.recipeName = recipeName;
        this.ingredientCollection = ingredientCollection;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategoryCollection = recipeCategoryCollection;
    }
    public Recipe(int id, String recipeName, List<RecipeIngredient> ingredientCollection, RecipeInstruction recipeInstruction) {
        Id = id;
        this.recipeName = recipeName;
        this.ingredientCollection = ingredientCollection;
        this.recipeInstruction = recipeInstruction;
    }
    public Recipe(String recipeName, List<RecipeIngredient> ingredientCollection, RecipeInstruction recipeInstruction) {
        this.recipeName = recipeName;
        this.ingredientCollection = ingredientCollection;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe() {

    }

    public int getId(int i) {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getIngredientCollection() {
        return ingredientCollection;
    }
    public void setIngredientCollection(List<RecipeIngredient> ingredientCollection) {
        this.ingredientCollection = ingredientCollection;
    }
    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }
    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }
    public List<RecipeCategory> getRecipeCategoryCollection() {
        return recipeCategoryCollection;
    }
    public void setRecipeCategoryCollection(List<RecipeCategory> recipeCategoryCollection) {
        this.recipeCategoryCollection = recipeCategoryCollection;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Id == recipe.Id && Objects.equals(recipeName, recipe.recipeName) && Objects.equals(ingredientCollection, recipe.ingredientCollection) && Objects.equals(recipeInstruction, recipe.recipeInstruction) && Objects.equals(recipeCategoryCollection, recipe.recipeCategoryCollection);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Id, recipeName, ingredientCollection, recipeInstruction, recipeCategoryCollection);
    }
    @Override
    public String toString() {
        return "Recipe{" +
                "Id=" + Id +
                ", recipeName='" + recipeName + '\'' +
                ", ingredientCollection=" + ingredientCollection +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategoryCollection=" + recipeCategoryCollection +
                '}';
    }
}