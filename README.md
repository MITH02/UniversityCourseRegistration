## UniversityCourseRegistration
Application for university registration system.

## Prerequisites
- Java Development Kit (JDK)
- Maven
- PostgreSQL Database

## Setup

Clone the project <br>
Open the project in your IDE for example IntelliJ <br>
in the terminal navigate to the path of your project <br>
run the following command : <br>
mvn clean install <br>
mvn spring-boot:run <br>


## POSTMAN LINK :

https://api.postman.com/collections/30260614-8ad0a151-0cde-4652-adc4-d2e7a5a81030?access_key=PMAT-01HG8TNHDKH2CKF93BX7RKW0AD

## Steps

The API should now be accessible at http://localhost:8655/api.

## API ENDPOINTS :-

### Add Student 

POST ADD STUDENT <br>
Endpoint: http://localhost:9855/api/add-student <br>
Request: <br>
```
{
  "studentId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "mobileNo": "1234567890",
  "emailId": "john.doe@example.com",
  "addedDate": "2023-11-27"
}
``` 
Response: <br>
```
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
```
### Get Student

GET Fetching student with ID <br>
Endpoint: http://localhost:8655/api/student/2 <br>
Response: <br>
```
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
```

### Add Course 

POST ADD COURSE <br>
Endpoint: http://localhost:8655/api/add-course <br>
Request: <br>
```
{
  "courseName": "Computer Science"
}
```
Response:<br>
```
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
```
### Get All Courses

GET All Courses Fetched <br>
Endpoint: http://localhost:8655/api/courses/all <br>
Response: <br>
```
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
```

### Add Enrollment

POST Adding new Enrollment <br>
Endpoint: http://localhost:8655/api/add-enrollment <br>
Request: <br>
```
{
  "studentId": 1,
  "courseId": 1,
  "enrollDate": "2023-01-01"
}
```
Response: <br>
```
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
```
### Get All Enrollments

GET Fetching all list <br>
Endpoint: http://localhost:8655/api/enrollment/all <br>
Response: <br>
```
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
```
### Update Enrollment

PUT Updation of Enrollment <br>
Endpoint: http://localhost:8655/api/update-enrollment/1 <br>
Request: <br>
```
{
  "enrollDate": "2023-02-01"
}
```
Response: <br>
```
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
```
### Delete Enrollment

DEL Delete <br>
Endpoint: http://localhost:8655/api/delete-enrollment/1 <br>
Response: <br>
```
{
    "status": "200 OK",
    "code": 0,
    "message": "Deleted Successfully",
    "data": "Enrollment with ID 5 deleted successfully"
}
```


