package webg5.pae.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import webg5.pae.model.Course;
import webg5.pae.model.Student;

@Data
@Service
public class PAE {

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;

    public List<Course> getCourses() {
        List<Course> list = new ArrayList<>();
        courseDB.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Course getCourse(String id) {
        return courseDB.findById(id).get();
    }

    public void addCourse(Course course){
        courseDB.save(course);
    }

    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        studentDB.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Student getStudent(Integer id){
        return studentDB.findById(id).get();
    }

    public void addStudent(Student student){
        studentDB.save(student);
    }

    public void enroll(Course course, Student student){
        course.getStudents().add(student);
        student.getCourses().add(course);
        studentDB.save(student);
    }

    public List<Student> search(String entry){
        return studentDB.findByFirstNameLike(entry);
    }
}
