# UniversityCourseRegistration
Application for university registration system.

### Prerequisites
- Java Development Kit (JDK)
- Maven
- PostgreSQL Database

## Setup

Open the project in your IDE for example IntelliJ 
in the terminal navigate to the path of your project 
run the following command : 
mvn clean install
mvn spring-boot:run


## POSTMAN LINK :

https://api.postman.com/collections/30260614-8ad0a151-0cde-4652-adc4-d2e7a5a81030?access_key=PMAT-01HG8TNHDKH2CKF93BX7RKW0AD

### Steps

The API should now be accessible at http://localhost:8655/api.


## API ENDPOINTS :-

## Add Student 

POST ADD STUDENT
Endpoint: http://localhost:9855/api/add-student
Request:
{
  "studentId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "mobileNo": "1234567890",
  "emailId": "john.doe@example.com",
  "addedDate": "2023-11-27"
}

Response:
{
    "status": "200 OK",
    "code": 0,
    "message": "Student added successfully",
    "data": {
        "studentId": 0,
        "firstName": "John",
        "lastName": "Doe",
        "mobileNo": "1234567890",
        "emailId": "john.doe@example.com",
        "addedDate": "2023-11-27"
    }
}

## Get Student

GET Fetching student with ID
Endpoint: http://localhost:8655/api/student/2
Response:
{
    "status": "200 OK",
    "code": 0,
    "message": "Data fetched successfully",
    "data": {
        "studentId": 2,
        "firstName": "Bobby",
        "lastName": "Lash",
        "mobileNo": "0987654321",
        "emailId": "bobby.lash123@example.com",
        "addedDate": "2023-11-27"
    }
}

## Add Course

POST ADD COURSE
Endpoint: http://localhost:8655/api/add-course
Request:
{
  "courseName": "Computer Science"
}
Response:
{
    "status": "200 OK",
    "code": 0,
    "message": "course added successfully",
    "data": {
        "courseId": 1,
        "courseName": "Computer Science",
        "enrollment": null
    }
}

## Get All Courses

GET All Courses Fetched
Endpoint: http://localhost:8655/api/courses/all
Response:
{
    "status": "200 OK",
    "code": 0,
    "message": "courses fetched successfully",
    "data": [
    
    {
            "courseId": 1,
            "courseName": "Computer Science",
            "enrollment": null
        }
    ]
}

## Add Enrollment

POST Adding new Enrollment
Endpoint: http://localhost:8655/api/add-enrollment
Request:
{
  "studentId": 1,
  "courseId": 1,
  "enrollDate": "2023-01-01"
}
Response:
{
  "status": "OK",
  "message": "Enrolled",
  "data": {
    "enrollId": 1,
    "student": {
      "studentId": 1,
      "firstName": "John",
      "lastName": "Doe",
      "mobileNo": "1234567890",
      "email": "john.doe@example.com"
      "addedDate": "2023-11-27"
    },
    "course": {
      "courseId": 1,
      "courseName": "Computer Science"
    },
    "enrollDate": "2023-01-01"
  }
}

## Get All Enrollments

GET Fetching all list
Endpoint: http://localhost:8655/api/enrollment/all
Response:
{
  "status": "OK",
  "message": "Enrolled student list",
  "data": [
  
    {
      "enrollId": 1,
      "student": {
        "studentId": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
      },
      "course": {
        "courseId": 1,
        "courseName": "Computer Science"
      },
      "enrollDate": "2023-01-01"
    },
  ]
}

## Update Enrollment

PUT Updation of Enrollment
Endpoint: http://localhost:8655/api/update-enrollment/1
Request:
{
  "enrollDate": "2023-02-01"
}
Response:
{
  "status": "OK",
  "data": {
    "enrollId": 1,
    "student": {
      "studentId": 1,
      "firstName": "John",
      "lastName": "Doe",
      "mobileNo": "1234567890",
      "email": "john.doe@example.com"
      "addedDate": "2023-11-27"
    },
    "course": {
      "courseId": 1,
      "courseName": "Computer Science"
    },
    "enrollDate": "2023-02-01"
  }
}

## Delete Enrollment

DEL Delete
Endpoint: http://localhost:8655/api/delete-enrollment/1
Response: 
{
    "status": "200 OK",
    "code": 0,
    "message": "Deleted Successfully",
    "data": "Enrollment with ID 5 deleted successfully"
}


