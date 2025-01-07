package com.demo.example.student_library_management_system_dec2024.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

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
    private Date TrancsactionDate;

    @Column(name = "Due_date")
    private String dueDate;

    @Column
    private double fine;

    @Column(name = "issue_or_return")
    private String issueOrReturn;



}
