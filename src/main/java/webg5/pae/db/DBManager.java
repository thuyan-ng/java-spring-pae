package webg5.pae.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import webg5.pae.business.CourseDB;
import webg5.pae.business.StudentDB;
import webg5.pae.model.Course;
import webg5.pae.model.Student;

@Slf4j
@SpringBootApplication
public class DBManager implements CommandLineRunner {

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;
    
    @Override
    public void run(String... args){
        log.info("DBManager started");
        List<Student> result = studentDB.findByCreditsGreaterThan(3);
        //List<Course> result = courseDB.findByTitleContaining("I");
        result.forEach(e -> log.info(e.toString()));
    }
}
