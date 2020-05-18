package com.example.homework180520;

import com.example.homework180520.facade.CourseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Homework180520Application {

    public static void main(String[] args) {
          SpringApplication.run(Homework180520Application.class, args);
//        ConfigurableApplicationContext ctx =
//        CourseService courseService = ctx.getBean(CourseService.class);

//        Calendar d = Calendar.getInstance();
//        d.set(2021, Calendar.APRIL, 2);
//        Date da = new Date(d.getTimeInMillis());
//
//        try {
//            courseService.addCourse(new Course("testToDelete", 420,da));
//        } catch (courseAlreadyExistException | dateProblemException e) {
//            System.out.println(e.getMessage());
//        }

//        courseService.deleteCourse(3);

//        for (Course c:courseService.getAllCourses()
//             ) {
//            System.out.println(c);
//        }

//        try {
//            System.out.println(courseService.getCourseById(3));
//        } catch (CourseDoesNowExistException e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println(courseService.getCourseByName("math"));


    }

}
