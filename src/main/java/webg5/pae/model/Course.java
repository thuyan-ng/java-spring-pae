package webg5.pae.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.*;

import java.util.List;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @NotNull
    @Size(min = 4, max = 5)
    private String id;
    
    @NotBlank
    private String title;
    
    @NotNull @Min(1) @Max(10)
    private int credits;

    @ManyToMany
    private List<Student> students;

    @Override
    public String toString(){
        return "[" + this.id + "-" + this.title + "-" + this.credits + "crédits]";
    }
}
