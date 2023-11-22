package com.example.be.service;


import com.example.be.dto.CreateUpdateStudentDTO;
import com.example.be.dto.IStudentEditDTO;
import com.example.be.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {


    /**
     * TinVT
     * Find all student
     */
    Page<Student> findAllStudent(String find, Pageable pageable);



    /**
     * TinVT
     * Edit Student
     */
    void editStudent(CreateUpdateStudentDTO studentDTO);

    /**
     * TinVT
     * Create New Student
     */
    void createNewStudent(CreateUpdateStudentDTO studentDTO);

    /**
     * TinVT
     * Find By Id
     */
    IStudentEditDTO findStudentById(Integer id);
}
