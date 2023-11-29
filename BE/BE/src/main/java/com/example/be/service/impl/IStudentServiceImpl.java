package com.example.be.service.impl;


import com.example.be.dto.CreateUpdateStudentDTO;
import com.example.be.dto.IStudentEditDTO;
import com.example.be.repository.StudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    StudentRepository StudentRepository;


    /**
     * KhoaHND
     * Edit Student
     */
    @Override
    public void editStudent(CreateUpdateStudentDTO studentDTO) {
        StudentRepository.editStudent(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAvatar(), studentDTO.getAddress(), studentDTO.getDateOfBirth(),
                studentDTO.getPhone(), studentDTO.getGrade(), studentDTO.getGender(), studentDTO.getStudentId());
    }

    /**
     * KhoaHND
     * Create New Student
     */
    @Override
    public void createNewStudent(CreateUpdateStudentDTO studentDTO) {
        StudentRepository.addNewStudent(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAvatar(), studentDTO.getAddress(),
                studentDTO.getDateOfBirth(), studentDTO.getPhone(), studentDTO.getGrade(),studentDTO.getAccountId(), studentDTO.getGender());
    }

    @Override
    public IStudentEditDTO findStudentByStudentId(Integer studentId) {
        return StudentRepository.findStudentByStudentId(studentId);
    }
}
