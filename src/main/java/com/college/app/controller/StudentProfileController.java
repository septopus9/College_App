package com.college.app.controller;

import com.college.app.model.User;
import com.college.app.service.StudentService;
import org.codehaus.plexus.resource.loader.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getStudentPersonalInfo(@PathVariable Long id) throws ResourceNotFoundException {
        User userInfo = studentService.getStudentPersonalInfo(id);
        return ResponseEntity.ok(userInfo);
    }

}
