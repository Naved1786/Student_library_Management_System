package com.demo.example.student_library_management_system_dec2024.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_status" , nullable = false)
    private String cardStatus;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    private Date updateDate;

    @OneToOne
    @JoinColumn // it joins the primary key of the student table as foreign key in card table
    private Student student;
}
