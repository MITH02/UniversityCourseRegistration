package com.UniversityRegistration.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.UniversityRegistration.System.model.ApiResponse;
import com.UniversityRegistration.System.entity.Course;
import com.UniversityRegistration.System.entity.Enrollment;
import com.UniversityRegistration.System.entity.Student;
import com.UniversityRegistration.System.model.ApiResponse;
import com.UniversityRegistration.System.model.EnrollmentRequest;
import com.UniversityRegistration.System.repository.CourseRepository;
import com.UniversityRegistration.System.repository.EnrollmentRepository;
import com.UniversityRegistration.System.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public ApiController(StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @PostMapping("/add-student")
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student) {
        student.setStudentId(0L);
        studentRepository.save(student);

        ApiResponse<Student> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.toString());
        apiResponse.setMessage("Student added successfully");
        apiResponse.setData(student);

        return ResponseEntity.ok(apiResponse);
    }


//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long studentId) {
//        // Find the student by ID with courses eagerly fetched
//        Optional<Student> optionalStudent = studentRepository.findById(studentId);
//
//        if (optionalStudent.isPresent()) {
//            ApiResponse<Student> apiResponse = new ApiResponse<>();
//            apiResponse.setStatus(HttpStatus.OK.toString());
//            apiResponse.setMessage("fetched data successfully");
//
//            apiResponse.setData(optionalStudent.get());
//
//            return ResponseEntity.ok(apiResponse);
//        } else {
//
//            return ResponseEntity.notFound().build();
//        }
//    }
//@GetMapping("/student/{studentId}")
//public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long studentId) {
//    // Find the student by ID with courses eagerly fetched
//    Optional<Student> optionalStudent = studentRepository.findById(studentId);
//
//    ApiResponse<Student> apiResponse = new ApiResponse<>();
//
//    if (optionalStudent.isPresent()) {
//        apiResponse.setStatus(HttpStatus.OK.toString());
//        apiResponse.setMessage("Data fetched successfully");
//        apiResponse.setData(optionalStudent.get());
//
//        return ResponseEntity.ok(apiResponse);
//    } else {
//        apiResponse.setStatus(HttpStatus.NOT_FOUND.toString());
//        apiResponse.setMessage("Student with ID " + studentId + " not found");
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
//    }
//}

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long studentId) {
        // Find the student by ID with courses eagerly fetched
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        ApiResponse<Student> apiResponse = new ApiResponse<>();

        if (optionalStudent.isPresent()) {
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("Data fetched successfully");
            apiResponse.setData(optionalStudent.get());

            return ResponseEntity.ok(apiResponse);
        } else {
            apiResponse.setStatus(HttpStatus.NOT_FOUND.toString());
            apiResponse.setMessage("Student with ID " + studentId + " not found");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }


    @GetMapping("/student/{studentId}/enrolled-courses")
    public ResponseEntity<ApiResponse<List<Course>>> getEnrolledCourses(@PathVariable Long studentId) {
        // Find the student by ID with enrolled courses eagerly fetched
        Optional<Student> optionalStudent = studentRepository.findStudentWithCourses(studentId);

        ApiResponse<List<Course>> apiResponse = null;
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<Course> enrolledCourses = student.getEnrollments()
                    .stream()
                    .map(Enrollment::getCourse)
                    .collect(Collectors.toList());

            apiResponse = new ApiResponse<>();
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("Enrolled courses fetched successfully");
            apiResponse.setData(enrolledCourses);

            return ResponseEntity.ok(apiResponse);
        } else {
            apiResponse.setStatus(HttpStatus.NOT_FOUND.toString());
            apiResponse.setMessage("Student with ID " + studentId + " not found");
            apiResponse.setData(null);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }



    @GetMapping("/student/all")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();

        ApiResponse<List<Student>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.toString());
        apiResponse.setMessage("students fetched successfully");

        apiResponse.setData(allStudents);

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/add-course")
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody Course courseName) {
        Course course = new Course();
        course.setCourseName(courseName.getCourseName());

        Course addedCourse = courseRepository.save(course);

        ApiResponse<Course> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.toString());
        apiResponse.setMessage("course added successfully");

        apiResponse.setData(addedCourse);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/courses/all")
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        // Retrieve all courses from the repository
        List<Course> allCourses = courseRepository.findAll();

        // Create ApiResponse with status and the list of all courses
        ApiResponse<List<Course>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.toString());
        apiResponse.setMessage("courses fetched successfully");
        apiResponse.setData(allCourses);

        // Return ResponseEntity with ApiResponse and OK status
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/add-enrollment")
    public ResponseEntity<ApiResponse<Enrollment>> addEnrollment(@RequestBody EnrollmentRequest enrollmentRequest) {
        // You might want to validate the request data before proceeding
        Student student = studentRepository.findById(enrollmentRequest.getStudentId()).orElse(null);
        Course course = courseRepository.findById(enrollmentRequest.getCourseId()).orElse(null);
        if (student == null || course == null) {
            ApiResponse<Enrollment> apiResponse = new ApiResponse<>();
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
            apiResponse.setMessage("Invalid student ID or course ID");
            apiResponse.setData(null);

            return ResponseEntity.badRequest().body(apiResponse);
        }
//        if (student == null || course == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollDate(enrollmentRequest.getEnrollDate());

        enrollmentRepository.save(enrollment);

        ApiResponse<Enrollment> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.toString());
        apiResponse.setMessage("Enrolled");
        apiResponse.setData(enrollment);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/enrollment/all")
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        List<Enrollment> allEnrollments = enrollmentRepository.findAll();

        ApiResponse<List<Enrollment>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.toString());
        apiResponse.setMessage("Enrolled student list");
        apiResponse.setData(allEnrollments);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/enrollment/{enrollId}")
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@PathVariable Long enrollId) {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(enrollId);

        if (optionalEnrollment.isPresent()) {
            ApiResponse<Enrollment> apiResponse = new ApiResponse<>();
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setData(optionalEnrollment.get());

            return ResponseEntity.ok(apiResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-enrollment/{enrollId}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(
            @PathVariable Long enrollId, @RequestBody EnrollmentRequest enrollmentRequest) {

        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(enrollId);

        if (optionalEnrollment.isPresent()) {
            Enrollment enrollment = optionalEnrollment.get();

            // Update enrollment details
            enrollment.setEnrollDate(enrollmentRequest.getEnrollDate());


            enrollmentRepository.save(enrollment);

            ApiResponse<Enrollment> apiResponse = new ApiResponse<>();
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setData(enrollment);

            return ResponseEntity.ok(apiResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("/delete-enrollment/{enrollId}")
//    public ResponseEntity<ApiResponse<List<Enrollment>>> deleteEnrollment(@PathVariable Long enrollId) {
//        if (enrollmentRepository.existsById(enrollId)) {
//            ApiResponse<List<Enrollment>> apiResponse = new ApiResponse<>();
//            enrollmentRepository.deleteById(enrollId);
//            apiResponse.setStatus(HttpStatus.OK.toString());
//            apiResponse.setMessage("Deleted Successfully");
//            return ResponseEntity.ok(apiResponse);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/delete-enrollment/{enrollId}")
    public ResponseEntity<ApiResponse<String>> deleteEnrollment(@PathVariable Long enrollId) {
        ApiResponse<String> apiResponse = new ApiResponse<>();

        if (enrollmentRepository.existsById(enrollId)) {
            enrollmentRepository.deleteById(enrollId);
            apiResponse.setStatus(HttpStatus.OK.toString());
            apiResponse.setMessage("Deleted Successfully");
            apiResponse.setData("Enrollment with ID " + enrollId + " deleted successfully");
            return ResponseEntity.ok(apiResponse);
        } else {
                     return ResponseEntity.notFound().build();

//            apiResponse.setStatus(HttpStatus.NOT_FOUND.toString());
//            apiResponse.setMessage("Not Found");
//            apiResponse.setData("Enrollment with ID " + enrollId + " not found");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }


}

