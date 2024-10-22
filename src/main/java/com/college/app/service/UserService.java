package com.college.app.service;

import com.college.app.model.AdministratorProfile;
import com.college.app.model.FacultyProfile;
import com.college.app.model.StudentProfile;
import com.college.app.model.User;
import com.college.app.repository.AdministratorProfileRepository;
import com.college.app.repository.FacultyProfileRepository;
import com.college.app.repository.StudentProfileRepository;
import com.college.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private AdministratorProfileRepository administratorProfileRepository;

    public User CreteUser (User user){
        User savedUser = userRepository.save(user);
        switch (user.getRole()){
            case STUDENT :
                    StudentProfile newStudent  = new StudentProfile();
                    newStudent.setUser(savedUser);
                    studentProfileRepository.save(newStudent);
                    break;
            case FACULTY_MEMBER :

                FacultyProfile newFaculty = new FacultyProfile();

                newFaculty.setUser(savedUser);
                facultyProfileRepository.save(newFaculty);
                break;
            case ADMINISTRATOR :
                AdministratorProfile newAdmin = new AdministratorProfile();
                newAdmin.setUser(savedUser);
                administratorProfileRepository.save(newAdmin);
                break;

            default:
                throw new IllegalArgumentException("Invalid role specified.");
        }
        return savedUser;
    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
