package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/student")
@RequiredArgsConstructor
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        logger.info("inside the get all Student");
        return ResponseEntity.status(200).body(studentService.getStudent());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        logger.info("inside add Student");
        studentService.addStudent(student);
        return ResponseEntity.ok().body(new ApiResponse("Student added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateStudent(@PathVariable Integer id, @RequestBody @Valid  Student student){
        logger.info("inside Update Student");
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().body(new ApiResponse("Student Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        logger.info("inside delete Student");
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body(new ApiResponse("Student Deleted"));

    }

    //---------------------------  end CRUD  ---------------------------------

    @DeleteMapping("/deleteCourses/{StudentId}/{Major}")
    public ResponseEntity deleteCourses(@PathVariable Integer StudentId ,@PathVariable String Major ){
        logger.info("inside delete Courses");
        studentService.deleteCourses(StudentId,Major);
        return ResponseEntity.ok().body(new ApiResponse("Courses Deleted"));
    }
}
