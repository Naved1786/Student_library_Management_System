package com.demo.example.student_library_management_system_dec2024.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transaction_status")
    private String trancsactionStatus;

    @Column(name = "transaction_date")
    @CreationTimestamp
    private Date TrancsactionDate;

    @Column(name = "Due_date")
    private String dueDate;

    @Column
    private double fine;

    @Column(name = "issue_or_return")
    private String issueOrReturn;

    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;


}
