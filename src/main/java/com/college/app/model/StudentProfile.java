package com.college.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentProfile {
    @Id
    private long user_id; //Foreign key linking to the User entity.

    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "user_id",nullable = false)
    private User user; // Foreign key linking to the User entity.
    private String photo;
    private String year;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department; //Foreign key linking to the Department entity.


    @OneToMany(mappedBy ="studentProfile" )
    @JsonIgnore
    private List<Enrollment> enrollments = new ArrayList<>();

    public StudentProfile() {
    }

    public StudentProfile(long user_id, User user,
                          String photo, String year) {
        this.user_id = user_id;
        this.user = user;
        this.photo = photo;
        this.year = year;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
