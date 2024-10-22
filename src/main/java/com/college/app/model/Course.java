package com.college.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department; // Foreign key linking to the Department entity.

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false) // Foreign key to the FacultyProfile entity
    private FacultyProfile facultyProfile;


    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    public void setFacultyProfile(FacultyProfile facultyProfile) {
        this.facultyProfile = facultyProfile;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
