package com.UniversityRegistration.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import com.UniversityRegistration.System.entity.Student;
import java.util.Optional;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.enrollments e LEFT JOIN FETCH e.course WHERE s.studentId = :studentId")
//    Optional<Student> findStudentWithCourses(@Param("studentId") Long studentId);

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.enrollments e LEFT JOIN FETCH e.course WHERE s.studentId = :studentId")
    Optional<Student> findStudentWithCourses(@Param("studentId") Long studentId);
}
