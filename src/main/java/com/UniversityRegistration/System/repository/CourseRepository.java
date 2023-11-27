package com.UniversityRegistration.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.UniversityRegistration.System.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
