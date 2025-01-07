package com.demo.example.student_library_management_system_dec2024.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private int pages;

    @Column(name = "publisher_name")
    private String publishersName;

    @Column
    private String genre;

    @Column
    private boolean available;

}
