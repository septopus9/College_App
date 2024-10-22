package com.college.app.service;

import com.college.app.model.StudentProfile;
import com.college.app.model.User;
import com.college.app.repository.StudentProfileRepository;
import com.college.app.repository.UserRepository;
import org.codehaus.plexus.resource.loader.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public User getStudentPersonalInfo(Long studentId) throws ResourceNotFoundException {
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        User user = student.getUser();
        return user;
    }



}





