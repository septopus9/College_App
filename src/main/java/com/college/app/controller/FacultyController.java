package com.college.app.controller;

import com.college.app.model.FacultyProfile;
import com.college.app.model.StudentProfile;
import com.college.app.service.FacultyService;
import com.college.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

//_____________________________________Logged In Faculty____________________________________________________//
    @GetMapping("/me")
    public ResponseEntity<FacultyProfile> getLoggedInFaculty(){
        Long facultyId = facultyService.getCurrentFacultyId();
        return facultyService.getFacultyById(facultyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//__________________________________________________________________________________________________________//

//__________________________________-GET course for Faculty _________________________________________________//

//    @GetMapping("/courses")
//    public ResponseEntity<List<Course>> getCoursesForFaculty(FacultyProfile facultyProfile) {
//        // Assuming you have a way to get the faculty profile from the principal
//        FacultyProfile faculty = facultyService.getCurrentFacultyId(facultyProfile.getUser_id());
//
//        List<Course> courses = courseService.getCoursesByFaculty(faculty);
//        return ResponseEntity.ok(courses);
//    }


















    @GetMapping("/{facultyId}/class-list") // working
    public ResponseEntity<List<StudentProfile>> getClassList(@PathVariable long facultyId) {
        List<StudentProfile> students = studentService.getStudentsByFacultyId(facultyId);
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateFacultyProfile(@PathVariable long userId, @RequestBody FacultyProfile updatedProfile) {
        facultyService.updateFacultyProfile(userId, updatedProfile);
        return ResponseEntity.noContent().build(); // Respond with 204 No Content
    }



}
