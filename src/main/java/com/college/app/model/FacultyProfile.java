package com.college.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class FacultyProfile {
    @Id
    private long user_id; //Foreign key linking to the User entity.

    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "user_id")
    private User user; // Foreign key linking to the User entity.
    private String photo;
    private String office_hours;

    @OneToMany(mappedBy = "facultyProfile")
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department; //Foreign key linking to the Department entity.
    //Foreign key linking to the Department entity.

    public FacultyProfile() {
    }


    public FacultyProfile(long user_id, User user,
                          String photo, String office_hours) {
        this.user_id = user_id;
        this.user = user;
        this.photo = photo;
        this.office_hours = office_hours;
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

    public String getOffice_hours() {
        return office_hours;
    }

    public void setOffice_hours(String office_hours) {
        this.office_hours = office_hours;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
