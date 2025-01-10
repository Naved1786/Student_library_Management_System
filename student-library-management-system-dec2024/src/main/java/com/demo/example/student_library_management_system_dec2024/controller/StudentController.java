package com.demo.example.student_library_management_system_dec2024.controller;


import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import com.demo.example.student_library_management_system_dec2024.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public  String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
         String response= studentService.addStudent(studentRequestDto);
          return  response;


    }

}
