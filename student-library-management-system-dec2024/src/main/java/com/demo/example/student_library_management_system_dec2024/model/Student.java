package com.demo.example.student_library_management_system_dec2024.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.engine.spi.CascadeStyle;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false , unique = false)
    private String email;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String dob;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String dept;

    @OneToOne(mappedBy = "student",  cascade= CascadeType.ALL)
    private Card card;


}
