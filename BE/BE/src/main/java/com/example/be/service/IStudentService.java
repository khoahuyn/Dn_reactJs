package com.example.be.service;


import com.example.be.dto.CreateUpdateStudentDTO;
import com.example.be.dto.IStudentEditDTO;


public interface IStudentService {

    /**
     * KhoaHND
     * Edit Student
     */
    void editStudent(CreateUpdateStudentDTO studentDTO);

    /**
     * KhoaHND
     * Create New Student
     */
    void createNewStudent(CreateUpdateStudentDTO studentDTO);

    /**
     * KhoaHND
     * Find By Id
     */
    IStudentEditDTO findStudentByStudentId(Integer studentId);
}
