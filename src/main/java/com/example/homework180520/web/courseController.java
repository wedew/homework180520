package com.example.homework180520.web;

import com.example.homework180520.Exception.CourseDoesNowExistException;
import com.example.homework180520.Exception.courseAlreadyExistException;
import com.example.homework180520.Exception.dateProblemException;
import com.example.homework180520.beans.Course;
import com.example.homework180520.facade.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "courses")
@CrossOrigin(origins = "http://localhost:4200")
public class courseController {

    private CourseService courseService;

    public courseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        try {
            courseService.addCourse(new Course(course.getTitle(), course.getDuration(), course.getStartDate()));
//            courseService.addCourse(course);
            return ResponseEntity.ok(course);
        } catch (courseAlreadyExistException | dateProblemException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable int courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("course deleted!");
    }

    @GetMapping("/all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("getById/{CourseId}")
    public ResponseEntity<?> getCourseById(@PathVariable int CourseId){
         try {
             return ResponseEntity.ok(courseService.getCourseById(CourseId));
        } catch (CourseDoesNowExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("getByName/{courseName}")
    public ResponseEntity<?> getCourseByName(@PathVariable String courseName){
        try {
            return ResponseEntity.ok(courseService.getCourseByName(courseName));
        } catch (CourseDoesNowExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
