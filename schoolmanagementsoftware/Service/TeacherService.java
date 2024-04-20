package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Api.ApiException;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiException("id not found");
        }
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setName(teacher.getName());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);

    }

    public void deleteTeacher(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiException("id not found");
        }
        teacherRepository.delete(teacher1);
    }

    //---------------------------  end CRUD  ---------------------------------
    //--------------------------- 1 endpoint   --------------------------------

    public Teacher getTeacherDetails(Integer id) {
        return teacherRepository.findTeacherById(id);
    }
}
