package com.demo.example.student_library_management_system_dec2024.requestdto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class TransactionRequestDto {

    private String trancsactionStatus;
    private String dueDate;
    private double fine;
    private String issueOrReturn;
    private int bookId;
    private int cardId;
}
