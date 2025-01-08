package com.demo.example.student_library_management_system_dec2024.requestdto;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class StudentRequestDto {
    // RequestDto ( Data transfer object) : it is used to take input request field

    private String name;
    private String email;
    private String mobile;
    private String dob;
    private String gender;
    private String dept;
}
