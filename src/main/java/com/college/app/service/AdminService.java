package com.college.app.service;

import com.college.app.model.FacultyProfile;
import com.college.app.model.StudentProfile;
import com.college.app.repository.FacultyProfileRepository;
import com.college.app.repository.StudentProfileRepository;
import com.college.app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private UserRepository userRepository;


//___________________________________Student Related Methods___________________________________________//


    // Delete a student by their ID (also deletes associated User)
    public void deleteStudent(Long studentId) {
        Optional<StudentProfile> studentProfileOpt = studentProfileRepository.findById(studentId);
        if (studentProfileOpt.isPresent()) {
            StudentProfile studentProfile = studentProfileOpt.get();
            // Delete the associated User entity first
            userRepository.deleteById(studentProfile.getUser().getId());
            // Then delete the StudentProfile
            studentProfileRepository.deleteById(studentId);
        }
    }



// GEt All student profiles
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    // Retrieve a specific student by ID
    public Optional<StudentProfile> getStudentById(Long id) {
        return studentProfileRepository.findById(id);
    }


    //___________________________________Student Related Methods___________________________________________//


//___________________________________Faculty Related Methods___________________________________________//

    // Faculty Methods
    public Optional<FacultyProfile> getFacultyById(Long id){
        return facultyProfileRepository.findById(id);
    }


    // GEt All faculty Profiles
    public List<FacultyProfile> getAllFaculty(){
        return facultyProfileRepository.findAll();
    }




    @Transactional
    public void deleteFaculty(Long facultyId) {
        FacultyProfile facultyProfile = facultyProfileRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found with ID: " + facultyId));

        // Delete the associated User
        userRepository.deleteById(facultyProfile.getUser().getId());

        // Then delete the FacultyProfile
        facultyProfileRepository.deleteById(facultyId);
    }




//___________________________________Faculty Related Methods___________________________________________//









}
