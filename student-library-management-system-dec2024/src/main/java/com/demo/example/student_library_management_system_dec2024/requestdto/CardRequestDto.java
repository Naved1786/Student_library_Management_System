package com.demo.example.student_library_management_system_dec2024.requestdto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
public class CardRequestDto {
    private String cardStatus;
   private  int StudentId;
}
