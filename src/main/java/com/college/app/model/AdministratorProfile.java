package com.college.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class AdministratorProfile {
    @Id
    private long user_id; //Foreign key linking to the User entity.
    @OneToOne
    @JsonIgnore
    @MapsId()
    @JoinColumn(name = "user_id;")
    private User user; //Foreign key linking to the User entity.
    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department  department; //Foreign key linking to the Department entity.

    public AdministratorProfile() {
    }

    public AdministratorProfile(long user_id, User user, String photo) {
        this.user_id = user_id;
        this.user = user;
        this.photo = photo;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
