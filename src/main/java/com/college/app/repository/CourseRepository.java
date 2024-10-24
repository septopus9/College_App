package com.college.app.repository;

import com.college.app.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

//    List<Course> findByFaculty(FacultyProfile facultyProfile);
}
