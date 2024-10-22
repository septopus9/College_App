package com.college.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class AdministratorProfile {
    @Id
    private long user_id;
    @OneToOne
    @JsonIgnore
    @MapsId()
    @JoinColumn(name = "user_id;")
    private User user;
    private String photo;

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
}
