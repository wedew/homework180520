package com.example.homework180520.facade;

import com.example.homework180520.Exception.CourseDoesNowExistException;
import com.example.homework180520.Exception.courseAlreadyExistException;
import com.example.homework180520.beans.Course;
import com.example.homework180520.db.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }


    public void addCourse(Course course) throws courseAlreadyExistException {
        Course c = courseRepo.findByTitle(course.getTitle());
        if(c instanceof Course)
            throw new courseAlreadyExistException();
        else
        courseRepo.save(course);
    }

    public void deleteCourse(int id){
        courseRepo.deleteById(id);
    }

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }

    public Course getCourseById(int id) throws CourseDoesNowExistException {
        return courseRepo.findById(id).orElseThrow(CourseDoesNowExistException::new);
    }

    public Course getCourseByName(String title) throws CourseDoesNowExistException {
        Course c = courseRepo.findByTitle(title);
        if(c instanceof Course)
            return c;
        else
            throw new CourseDoesNowExistException();
    }


}
