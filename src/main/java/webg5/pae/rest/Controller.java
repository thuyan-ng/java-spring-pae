package webg5.pae.rest;

import java.util.List;
import webg5.pae.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webg5.pae.business.PAE;

@RestController
@RequestMapping(path="/api")
public class Controller {

    @Autowired
    private PAE pae;

    @GetMapping("students")
    public List<Student> getStudents() {
        return pae.getStudents();
    }

    @GetMapping("courses")
    public List<Course> getCourses() {
        return pae.getCourses();
    }

    @GetMapping("courses/{id}")
    public Course findCourse(@PathVariable String id){
        return pae.getCourse(id);
    }
}