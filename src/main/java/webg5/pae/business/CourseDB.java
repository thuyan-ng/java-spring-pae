package webg5.pae.business;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webg5.pae.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {
    
    List<Course> findByCreditsGreaterThanEqual(Integer credits);
    List<Course> findByTitleContaining(String text);
}
