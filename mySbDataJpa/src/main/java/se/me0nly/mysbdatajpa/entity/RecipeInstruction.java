package se.me0nly.mysbdatajpa.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String Id;
    @Column(nullable = false)
    private String instructions;
    public RecipeInstruction() {
    }
    public RecipeInstruction(String instructions) {
        this.instructions = instructions;
    }
    public RecipeInstruction(String id, String instructions) {
        Id = id;
        this.instructions = instructions;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(Id, that.Id) && Objects.equals(instructions, that.instructions);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Id, instructions);
    }
    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "Id='" + Id + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}