package webg5.pae.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import webg5.pae.business.PAE;
import webg5.pae.model.Course;
import webg5.pae.model.Student;

@Controller
public class StudentController {

    @Autowired
    private PAE pae;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", pae.getStudents());
        model.addAttribute("student", new Student()); // si le nom de la variable change, cfr addCourse
        return "students";
    }

    @GetMapping("/student")
    public String student(Model model, Integer id) {
        model.addAttribute("courses", pae.getStudent(id).getCourses());
        model.addAttribute("studentId", id);
        return "student";
    }

    @PostMapping("/student/enroll/{studentId}")
    public String enroll(Model model, String courseId, @PathVariable Integer studentId) {
        Student student = pae.getStudent(studentId);
        Course course = pae.getCourse(courseId);
        pae.enroll(course, student);
        return "redirect:/student?id=" + studentId;
    }

    @PostMapping("/students/add")
    public String addStudent(Model model, @Valid Student student, Errors err) { // @ModelAttribute("newCourse") devant
                                                                                // @Valid
        if (err.hasErrors()) {
            model.addAttribute("students", pae.getStudents());
            return "students";
        } else {
            pae.addStudent(student);
            return "redirect:/students";
        }
    }

    @PostMapping("/students/search")
    public String search(Model model, String entry){
        model.addAttribute("students", pae.search(entry));
        model.addAttribute("student", new Student());
        return "students";
    }
}
