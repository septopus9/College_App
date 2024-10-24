package com.college.app.service;

import com.college.app.model.FacultyProfile;
import com.college.app.repository.FacultyProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyService {


    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    //_____________________________________Log in faculty details_________________________________________//
    // Temporary logic to simulate a logged-in student (static data for now)
    public Long getCurrentFacultyId() {
        // Assume the student with ID 1 is the logged-in user (just for now)
        return 502L;
    }

    public Optional<FacultyProfile> getFacultyById(Long faculty_id) {
        return facultyProfileRepository.findById(faculty_id);
    }
    //________________________________________Log in faculty details___________________________________________//
























    public void updateFacultyProfile(long userId, FacultyProfile updatedProfile) {
        // Fetch the existing FacultyProfile by user ID
        FacultyProfile existingProfile = facultyProfileRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found with user ID: " + userId));

        // Update the fields in the existing profile
        existingProfile.setPhoto(updatedProfile.getPhoto()); // Update photo
        existingProfile.setOffice_hours(updatedProfile.getOffice_hours()); // Update office hours
        existingProfile.setCourses(updatedProfile.getCourses()); // Update course
        existingProfile.setDepartment(updatedProfile.getDepartment()); // Update department

        // If there are other fields you want to update, do it here

        // Save the updated profile back to the database
        facultyProfileRepository.save(existingProfile);
    }


}
