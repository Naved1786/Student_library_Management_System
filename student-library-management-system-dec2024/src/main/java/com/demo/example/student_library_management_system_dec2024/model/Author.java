package com.demo.example.student_library_management_system_dec2024.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String country;

    @Column
    private Double rating;

}
