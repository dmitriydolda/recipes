package recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe implements Comparable<Recipe>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "RecipeID")
    private long id;

    @ManyToOne
    @JoinColumn( name = "UserID")
    @JsonIgnore
    private User user;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String category;

    private LocalDateTime date;

    @NotNull
    @Size(min = 1)
    @ElementCollection
    private List<String> ingredients;

    @NotNull
    @Size(min = 1)
    @ElementCollection
    private List<String> directions;

    @Override
    public int compareTo(Recipe o) {
        return o.date.compareTo(this.date);
    }
}
