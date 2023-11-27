package com.example.be.service.impl;


import com.example.be.dto.CreateUpdateStudentDTO;
import com.example.be.dto.IStudentEditDTO;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    IStudentRepository IStudentRepository;


    /**
     * KhoaHND
     * Edit Student
     */
    @Override
    public void editStudent(CreateUpdateStudentDTO studentDTO) {
        IStudentRepository.editStudent(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getImage(), studentDTO.getAddress(), studentDTO.getDateOfBirth(),
                studentDTO.getPhone(), studentDTO.getGrade(), studentDTO.getGender(), studentDTO.getStudentId());
    }

    /**
     * KhoaHND
     * Create New Student
     */
    @Override
    public void createNewStudent(CreateUpdateStudentDTO studentDTO) {
        IStudentRepository.addNewStudent(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getImage(), studentDTO.getAddress(),
                studentDTO.getDateOfBirth(), studentDTO.getPhone(), studentDTO.getGrade(),studentDTO.getAccountId(), studentDTO.getGender());
    }

    @Override
    public IStudentEditDTO findStudentByStudentId(Integer studentId) {
        return IStudentRepository.findStudentByStudentId(studentId);
    }
}
