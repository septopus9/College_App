package com.college.app.service;

import com.college.app.model.StudentProfile;
import com.college.app.model.User;
import com.college.app.repository.StudentProfileRepository;
import com.college.app.repository.UserRepository;
import org.codehaus.plexus.resource.loader.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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











    public List<StudentProfile> searchStudentProfiles(String name, String department, String year) {
        Specification<StudentProfile> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("user").get("name")),
                            "%" + name.toLowerCase() + "%"
                    ));
        }

        if (department != null && !department.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("department").get("name"), department));
        }

        if (year != null && !year.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("year"), year));
        }

        return studentProfileRepository.findAll((Sort) spec);
    }



}





