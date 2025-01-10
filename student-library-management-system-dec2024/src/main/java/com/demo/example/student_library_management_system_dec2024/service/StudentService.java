package com.demo.example.student_library_management_system_dec2024.service;

import com.demo.example.student_library_management_system_dec2024.converters.StudentConverter;
import com.demo.example.student_library_management_system_dec2024.model.Card;
import com.demo.example.student_library_management_system_dec2024.model.Student;
import com.demo.example.student_library_management_system_dec2024.repository.StudentRepository;
import com.demo.example.student_library_management_system_dec2024.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
