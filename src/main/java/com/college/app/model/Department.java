package com.college.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;


    @OneToMany(mappedBy = "department")
    private List<StudentProfile> studentProfile=new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<FacultyProfile> facultyProfiles = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<AdministratorProfile> administratorProfiles =new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StudentProfile> getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(List<StudentProfile> studentProfile) {
        this.studentProfile = studentProfile;
    }

    public List<FacultyProfile> getFacultyProfiles() {
        return facultyProfiles;
    }

    public void setFacultyProfiles(List<FacultyProfile> facultyProfiles) {
        this.facultyProfiles = facultyProfiles;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<AdministratorProfile> getAdministratorProfiles() {
        return administratorProfiles;
    }

    public void setAdministratorProfiles(List<AdministratorProfile> administratorProfiles) {
        this.administratorProfiles = administratorProfiles;
    }
}
