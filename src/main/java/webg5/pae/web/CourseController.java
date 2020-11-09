package webg5.pae.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import webg5.pae.business.PAE;
import webg5.pae.model.Course;
import webg5.pae.model.Student;

@Controller
public class CourseController {

    @Autowired
    private PAE pae;

    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", pae.getCourses());
        model.addAttribute("course", new Course()); // si le nom de la variable change, cfr addCourse
        return "courses";
    }

    @GetMapping("/course")
    public String course(Model model, String id) {
        model.addAttribute("students", pae.getCourse(id).getStudents());
        model.addAttribute("courseId", id);
        return "course";
    }

    @PostMapping("/course/enroll/{courseId}")
    public String enroll(Model model, Integer studentId, @PathVariable String courseId) {
        Student student = pae.getStudent(studentId);
        Course course = pae.getCourse(courseId);
        pae.enroll(course, student);
        return "redirect:/course?id="+courseId;
    }

    @PostMapping("/courses/add")
    public String addCourse(Model model, @Valid Course course, Errors err) { // @ModelAttribute("newCourse") devant
                                                                             // @Valid
        if (err.hasErrors()) {
            model.addAttribute("courses", pae.getCourses());
            return "courses";
        } else {
            pae.addCourse(course);
            return "redirect:/courses";
        }
    }
}