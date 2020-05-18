package com.example.homework180520.db;

        import com.example.homework180520.beans.Course;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findByTitle(String title);
}
