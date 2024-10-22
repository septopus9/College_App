package com.college.app.model;

import jakarta.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;


    @ManyToOne
    @JoinColumn(name = "student_id") // //Foreign key linking to the StudentProfile entity
    private StudentProfile studentProfile; //Foreign key linking to the StudentProfile entity



    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; //Foreign key linking to the Course entity.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
