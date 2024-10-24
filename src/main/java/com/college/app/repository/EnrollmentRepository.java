package com.college.app.repository;

import com.college.app.model.Course;
import com.college.app.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    List<Enrollment> findByCourse(Course course);

}
