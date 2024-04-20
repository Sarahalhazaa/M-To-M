package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.Api.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/Teacher")
@RequiredArgsConstructor
public class TeacherController {
    Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        logger.info("inside the get all Teacher");
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        logger.info("inside add Teacher");
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok().body(new ApiResponse("Teacher added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        logger.info("inside Update Teacher");
       teacherService.updateTeacher(id , teacher);

        return ResponseEntity.ok().body(new ApiResponse("Teacher Update"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        logger.info("inside delete Teacher");
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().body(new ApiResponse("Customer Deleted"));

    }
    //---------------------------  end CRUD  ---------------------------------
    @GetMapping("/TeacherDetails/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id){
        logger.info("inside the get Teacher");
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }

}
