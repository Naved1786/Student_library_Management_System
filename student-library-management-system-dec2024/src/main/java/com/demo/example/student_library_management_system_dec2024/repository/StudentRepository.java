package com.demo.example.student_library_management_system_dec2024.repository;

import com.demo.example.student_library_management_system_dec2024.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
   // customized queries - writing our own methods

    //1. writing own methods with fields or attribute with jpa support

    public Student findByEmail(String email);

    public List<Student> findByDept(String  dept);

    // AND/OR operations by combining two fields

    public Student findByEmailAndDept(String email, String dept);

    public List<Student> findByEmailOrDept(String email, String dept);

    //2. writing our own complete queries (to write query )

    @Query(nativeQuery = true,value = "select* from student where dept = :dept")
    public List<Student> findByDeptQuery(String dept);
}
