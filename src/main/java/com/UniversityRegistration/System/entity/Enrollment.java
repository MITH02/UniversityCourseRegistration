package com.UniversityRegistration.System.entity;

import java.sql.Date;


import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
//    @OneToOne
//    @JoinColumn(name = "course_id")
//    private Course course;

    private Date enrollDate;

    public Enrollment(Long enrollId,Student student,Course course,Date enrollDate) {
        this.enrollId = enrollId;
        this.student=student;
        this.course=course;
        this.enrollDate=enrollDate;
    }

    public Enrollment() {

    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }
}

