package com.college.app.service;

import com.college.app.model.StudentProfile;
import com.college.app.repository.FacultyProfileRepository;
import com.college.app.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    // Student Methods
    public StudentProfile saveStudent(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }
}
