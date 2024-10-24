package com.college.app.controller;

import com.college.app.model.StudentProfile;
import com.college.app.service.StudentService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student-profiles")
public class StudentProfileController {
    @Autowired
    private StudentService studentService;


//______________________________________Student Endpoints_______________________________________________//


    @GetMapping("/me")
    @JsonIgnore// getting logged in user profile
    public ResponseEntity<StudentProfile> getLoggedInStudent() {
        Long studentId = studentService.getCurrentStudentId();
        return studentService.getStudentById(studentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }











//    @GetMapping("/profile")
//    public ResponseEntity<StudentProfile> getProfile() {
//        StudentProfile profile = studentService.getProfile();
//        return ResponseEntity.ok(profile);
//    }







//
//
//    @GetMapping("/{userId}") // get all the student
//    public ResponseEntity<User> getStudentPersonalInfo(@PathVariable Long userId) throws ResourceNotFoundException {
//        User userInfo = studentService.getStudentById(userId);
//        return ResponseEntity.ok(userInfo);
//    }




    //______________________________________Student Endpoints_______________________________________________//






}
