package com.college.app.service;

import com.college.app.model.Course;
import com.college.app.model.Enrollment;
import com.college.app.model.FacultyProfile;
import com.college.app.model.StudentProfile;
import com.college.app.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

//________________________________________________________________________________________________________//
    // Temporary logic to simulate a logged-in student (static data for now)
    public Long getCurrentStudentId() {
        // Assume the student with ID 1 is the logged-in user (just for now)
        return 1L;
    }

    public Optional<StudentProfile> getStudentById(Long studentId) {
        return studentProfileRepository.findById(studentId);
    }
//________________________________________________________________________________________________________//























//    public User getStudentPersonalInfo(Long studentId) throws ResourceNotFoundException {
//        StudentProfile student = studentProfileRepository.findById(studentId)
//                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
//
//        User user = student.getUser();
//        return user;
//    }









    public List<StudentProfile> getStudentsByFacultyId(long facultyId) {
        // Fetch the faculty profile to ensure it exists
        FacultyProfile facultyProfile = facultyProfileRepository.findById(facultyId)
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found with id: " + facultyId));

        // Get the list of courses taught by this faculty member
        List<Course> courses = facultyProfile.getCourses();

        // Use a set to avoid duplicates
        Set<StudentProfile> studentsSet = new HashSet<>();

        // Iterate over each course to retrieve enrolled students
        for (Course course : courses) {
            // Get the list of enrollments for this course
            List<Enrollment> enrollments = enrollmentRepository.findByCourse(course);

            // Collect students from each enrollment
            for (Enrollment enrollment : enrollments) {
                studentsSet.add(enrollment.getStudentProfile()); // Add the student to the set
            }
        }

        // Return the list of unique students
        return new ArrayList<>(studentsSet);
    }



//    public List<StudentProfile> searchStudentProfiles(String name, String department, String year) {
//        Specification<StudentProfile> spec = Specification.where(null);
//
//        if (name != null && !name.isEmpty()) {
//            spec = spec.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.like(
//                            criteriaBuilder.lower(root.get("user").get("name")),
//                            "%" + name.toLowerCase() + "%"
//                    ));
//        }
//
//        if (department != null && !department.isEmpty()) {
//            spec = spec.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.equal(root.get("department").get("name"), department));
//        }
//
//        if (year != null && !year.isEmpty()) {
//            spec = spec.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.equal(root.get("year"), year));
//        }
//
//        return studentProfileRepository.findAll((Sort) spec);
//    }








}





