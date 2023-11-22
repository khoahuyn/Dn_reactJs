package com.example.be.service.impl;


import com.example.be.dto.CreateUpdateStudentDTO;
import com.example.be.dto.IStudentEditDTO;
import com.example.be.entity.Student;
import com.example.be.repository.StudentRepository;
import com.example.be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    /**
     * TinVT
     * Find all student
     */
    @Override
    public Page<Student> findAllStudent(String find, Pageable pageable) {
        return studentRepository.getAllStudent(find, pageable);
    }




    /**
     * TinVT
     * Edit Student
     */
    @Override
    public void editStudent(CreateUpdateStudentDTO studentDTO) {
        studentRepository.editStudent(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getImage(), studentDTO.getAddress(), studentDTO.getDateOfBirth(),
                studentDTO.getPhone(), studentDTO.getGrade(), studentDTO.getGender(), studentDTO.getId());
    }

    /**
     * TinVT
     * Create New Student
     */
    @Override
    public void createNewStudent(CreateUpdateStudentDTO studentDTO) {
        studentRepository.addNewStudent(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getImage(), studentDTO.getAddress(),
                studentDTO.getDateOfBirth(), studentDTO.getPhone(), studentDTO.getGrade(),studentDTO.getAccountId(), studentDTO.getGender());
    }

    @Override
    public IStudentEditDTO findStudentById(Integer id) {
        return studentRepository.findStudentById(id);
    }
}
