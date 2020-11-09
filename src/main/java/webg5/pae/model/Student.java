package webg5.pae.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id @GeneratedValue
//    @GeneratedValue(generator = "my_gen", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "my_gen", sequenceName = "my_seq", allocationSize = 50)
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String gender;
    @NotBlank
    private String section;

    @ManyToMany(mappedBy="students")
    @JsonIgnore //to break the recursive call when the translation of JSON objects occurs
    private List<Course> courses;

    @Override
    public String toString(){
        return "[" + this.lastName + "-" + this.firstName + "]";
    }
}
