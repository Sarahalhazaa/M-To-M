package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.Model.Student;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {

        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("id not found");
        }
       student1.setMajor(student.getMajor());
        student1.setName(student.getName());
        studentRepository.save(student1);

    }

    public void deleteStudent(Integer id) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("id not found");
        }
       studentRepository.delete(student1);
    }

    //---------------------------  end CRUD  ---------------------------------
    //--------------------------- 1 endpoint   --------------------------------
    public void deleteCourses(Integer StudentId , String Major ) {
        Student student1 = studentRepository.findStudentById(StudentId);
        if (student1 == null) {
            throw new ApiException("id not found");
        }
        if (student1.getMajor().equalsIgnoreCase(Major)) {
            throw new ApiException("Major has not changed");
        }
        student1.setMajor(Major);
        student1.setCourses(null);
       studentRepository.save(student1);
    }
}
