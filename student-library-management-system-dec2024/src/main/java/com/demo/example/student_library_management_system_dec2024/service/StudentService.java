package com.demo.example.student_library_management_system_dec2024.service;

import com.demo.example.student_library_management_system_dec2024.converters.StudentConverter;
import com.demo.example.student_library_management_system_dec2024.model.Card;
import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.repository.StudentRepository;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private  StudentRepository studentRepository;
    public  String addStudent(StudentRequestDto studentRequestDto){
        // convert requestDto into model class so that it is saved in database
        Student student= StudentConverter.convertsStudentRequestDtoToStudent(studentRequestDto);
        // whenever student gets created card also gets created

        Card card=new Card();
        card.setCardStatus("ACTIVE");
        student.setCard(card);
        card.setStudent(student);

        studentRepository.save(student);
        return "Student saved successfully";
    }

    public Student getStudentById(int id){
          Optional<Student>  studentOptional= studentRepository.findById(id);
          return studentOptional.get();
    }
    public List<Student> getAllStudent(){
       List<Student> studentList = studentRepository.findAll();
       return studentList;
    }

    public String countStudent(){
        long count=studentRepository.count();
        return "total number of students present are :"+count;
    }
    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return  "Student with id :"+id+" got deleted";
    }
    public String  updateStudent(int id , StudentRequestDto studentRequestDto){
        // first find student is present in database or not
        // if present then update
        // else no update
        Student student=getStudentById(id);
        if(student!=null){
            student.setName(studentRequestDto.getName());
            student.setGender(studentRequestDto.getGender());
            student.setMobile(studentRequestDto.getMobile());
            student.setEmail(studentRequestDto.getEmail());
            student.setDob(studentRequestDto.getDob());
            student.setDept(studentRequestDto.getDept());
            studentRepository.save(student);
            return "Student updated successfully";
        }else{
            // can not update
            return "student can not be updated";
        }
    }
    public String updateStudentByPatch(int id, String mobile){
        Student student=getStudentById(id);
        if(student!=null){
            student.setMobile(mobile);
            studentRepository.save(student);
            return  "Student update successfully";
        }else{
            return "Student can not be updated";
        }
    }

    public List<Student> getStudentBasedOnPage(int pageNo, int pageSize){
        // pagination and sorting ...ascending and descending order wise ..
        Page<Student> studentPage=studentRepository.findAll(PageRequest.of(pageNo,pageSize,Sort.by("name").descending()));
        // we should convert page into list
        List<Student> studentList=studentPage.getContent();
        return studentList;
    }
    public Student getStudentByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student;
    }
}
