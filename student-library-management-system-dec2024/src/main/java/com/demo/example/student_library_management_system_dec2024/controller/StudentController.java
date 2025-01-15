package com.demo.example.student_library_management_system_dec2024.controller;


import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import com.demo.example.student_library_management_system_dec2024.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        try {
            String response= studentService.addStudent(studentRequestDto);
            return  ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        try {
            Student student=studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAllStudent(){
        try {
            List<Student> studentList = studentService.getAllStudent();
            return ResponseEntity.ok(studentList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping("/count")
    public ResponseEntity<?> countStudents(){
        try {
            String response= studentService.countStudent();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        try {
            String response= studentService.deleteStudentById(id);
            return  ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudentsById(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        try {
            String response=studentService.updateStudent(id,studentRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PatchMapping("/updatePatch/{id}")
    public ResponseEntity<?> updateStudentMobileByPatch(@PathVariable int id,@RequestParam String mobile ){
        try {
            String response=studentService.updateStudentByPatch(id,mobile);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping("/findByPage")
    public List<Student> findStudentBasedOnPage(@RequestParam int pageNo, @RequestParam int pageSize){
      List<Student> studentList  =studentService.getStudentBasedOnPage(pageNo,pageSize);
      return studentList;
    }
    @GetMapping("/findByEmail")
    public  Student findStudentByEmail(@RequestParam String email){
         Student student= studentService.getStudentByEmail(email);
         return student;
    }
    @GetMapping("/findByEmailOrDept")
    public List<Student> getStudentByEmailOrDept(@RequestParam String email,@RequestParam String Dept){
        List<Student> studentList= studentService.StudentByEmailOrDept(email,Dept);
         return studentList;
    }

    @GetMapping("/findByDept")
    public List<Student> getStudentByDept(@RequestParam String dept){
       List<Student> studentList = studentService.StudentByDept(dept);
        return  studentList;
    }
}

