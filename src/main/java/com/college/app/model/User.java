package com.college.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String name;
    private String phone;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private StudentProfile studentProfile;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private AdministratorProfile administratorProfile;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private FacultyProfile facultyProfile;

    public User() {
    }

    public User(long id, String username, String password, Role role, String name, String phone, StudentProfile studentProfile,
                AdministratorProfile administratorProfile, FacultyProfile facultyProfile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.phone = phone;
        this.studentProfile = studentProfile;
        this.administratorProfile = administratorProfile;
        this.facultyProfile = facultyProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public AdministratorProfile getAdministratorProfile() {
        return administratorProfile;
    }

    public void setAdministratorProfile(AdministratorProfile administratorProfile) {
        this.administratorProfile = administratorProfile;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    public void setFacultyProfile(FacultyProfile facultyProfile) {
        this.facultyProfile = facultyProfile;
    }

}
