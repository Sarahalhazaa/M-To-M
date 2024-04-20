package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/vi/course")
@RequiredArgsConstructor
public class CourseController {
    Logger logger = LoggerFactory.getLogger(CourseController.class);
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse(){
        logger.info("inside the get all Course");
        return ResponseEntity.status(200).body(courseService.getCourse());
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity addCourse(@PathVariable Integer teacherId, @RequestBody @Valid Course course){
        logger.info("inside add Course");
        courseService.addCourse( teacherId , course);
        return ResponseEntity.ok().body(new ApiResponse("Course added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        logger.info("inside Update Course");
        courseService.updateCourse(id , course);

        return ResponseEntity.ok().body(new ApiResponse("Course Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        logger.info("inside delete Course");
        courseService.deleteCourse(id);
        return ResponseEntity.ok().body(new ApiResponse("Course Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------

    @GetMapping("/getTeacherName/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id){
        logger.info("inside the get Teacher Name");
        courseService.getTeacherName(id);
        return ResponseEntity.ok().body(courseService.getTeacherName(id));

    }

    @GetMapping("/getStudent/{courseId}")
    public ResponseEntity getStudent(@PathVariable Integer courseId) {
        logger.info("inside the get Student");
        return ResponseEntity.status(200).body(courseService.getStudent(courseId));

    }
}
