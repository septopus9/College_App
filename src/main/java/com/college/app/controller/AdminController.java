package com.college.app.controller;

import com.college.app.model.FacultyProfile;
import com.college.app.model.StudentProfile;
import com.college.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController{

    @Autowired  // Dependency Injection
    private AdminService adminService;


//________________________________________Student Related Endpoints For Admin______________________________//



//__________________________________________ DELETE  student by ID____________________________________________//

    // DELETE a student by ID
    @DeleteMapping("/students_profiles/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        adminService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//__________________________________________ DELETE  student by ID____________________________________________//



//__________________________________________ GET ALL student by ID____________________________________________//

    @GetMapping("/students_profiles") // Get All the student
    public List<StudentProfile> getAllStudents() {
        return adminService.getAllStudents();
    }
//__________________________________________ GET ALL student by ID____________________________________________//






//__________________________________________ GET a student by ID____________________________________________//
    @GetMapping("/students_profiles/{id}") // Get Student by id
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return adminService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//__________________________________________ GET a student by ID____________________________________________//



// ________________________________________Student Related Endpoints For Admin______________________________//



//________________________________________Faculty Related Endpoints For Admin______________________________//

    // Faculty Endpoints
    //______________________________________ Get faculty BY id_____________________________________________//
    @GetMapping("/faculty_profiles/{id}")
    public ResponseEntity<FacultyProfile> getFacultyById(@PathVariable Long id){
        return adminService.getFacultyById(id).map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //______________________________________ Get faculty BY id_____________________________________________//





//______________________________________ Get All faculty_____________________________________________//

    @GetMapping("/faculty_profiles") // Get All the faculty Members Vai AdminController
    public List<FacultyProfile> getAllFaculty() {
        return adminService.getAllFaculty();
    }
//______________________________________ Get All faculty_____________________________________________//

//______________________________________ Delete  faculty By Id_____________________________________________//

    @DeleteMapping("/faculty/{id}")  // delete the Faculty record
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        try {
            adminService.deleteFaculty(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
//______________________________________ Delete  faculty By Id_____________________________________________//



    //________________________________________Faculty Related Endpoints For Admin______________________________//








}
