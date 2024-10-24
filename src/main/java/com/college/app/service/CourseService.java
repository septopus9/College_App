package com.college.app.service;

import com.college.app.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//    public List<Course> getCoursesByFaculty(FacultyProfile faculty) {
//        return courseRepository.findByFaculty(faculty);
//    }
}
