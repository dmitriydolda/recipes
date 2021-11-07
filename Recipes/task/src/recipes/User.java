package recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "UserID")
    private long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "\\S*@\\S*\\.\\S*")
    private String email;

    @Size(min = 8)
    @NotNull
    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Recipe> recipes;

    @JsonIgnore
    private String roles;

}
