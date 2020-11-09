package webg5.pae.business;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webg5.pae.model.Student;

public interface StudentDB extends CrudRepository<Student, Integer> {
    
    @Query("SELECT s.lastName FROM Student s")
    List<String> findAllNames();

    @Query("SELECT s.id, s.lastName FROM Student s")
    List<Object[]> findByIdAndLastName();

    @Query("SELECT s.lastName, SUM(c.credits) FROM Student s JOIN s.courses c GROUP BY s.lastName")
    List<Object[]> findByLastNameAndCredits();

    @Query("SELECT s FROM Student s JOIN s.courses c GROUP BY s HAVING SUM(c.credits) > :low")
    List<Student> findByCreditsGreaterThan(long low);

    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %:entry%")
    List<Student> findByFirstNameLike(String entry);

}