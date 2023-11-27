package com.UniversityRegistration.System.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    //    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
//    private Enrollment enrollment;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Enrollment enrollment;
    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Course() {
    }

    public Course(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }


//    public Course(Long courseId, String courseName, Enrollment enrollment) {
//        this.courseId = courseId;
//        this.courseName = courseName;
//        this.enrollment = enrollment;
//    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

