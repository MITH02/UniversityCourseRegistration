package com.UniversityRegistration.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.UniversityRegistration.System.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}

