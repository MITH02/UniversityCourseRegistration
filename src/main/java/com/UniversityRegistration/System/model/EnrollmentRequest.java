package com.UniversityRegistration.System.model;

import java.sql.Date;

import java.sql.Date;

public class EnrollmentRequest {
    private Long studentId;
    private Long courseId;
    private Date enrollDate;

    // Constructors, getters, and setters

    public Long getStudentId() {

        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {

        return courseId;
    }

    public void setCourseId(Long courseId) {

        this.courseId = courseId;
    }

    public Date getEnrollDate() {

        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate)
    {
        this.enrollDate = enrollDate;
    }
}
