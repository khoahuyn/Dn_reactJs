package com.example.be.controller;
import com.example.be.dto.AccountRoleDTO;
import com.example.be.dto.CreateUpdateStudentDTO;
import com.example.be.dto.IStudentEditDTO;
import com.example.be.entity.Account;
import com.example.be.service.IAccountRoleService;
import com.example.be.service.IAccountService;
import com.example.be.service.IStudentService;
import com.example.be.validate.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    IStudentService IStudentService;

    @Autowired
    IAccountService IAccountService;

    @Autowired
    IAccountRoleService IAccountRoleService;

    @Autowired
    StudentValidator studentValidator;





    /**
     * KhoaHND
     * Edit Student
     */
    @RequestMapping(value = "/edit-student", method = RequestMethod.PUT)
    public ResponseEntity<?> editStudent(@RequestBody CreateUpdateStudentDTO studentDTO){
        IStudentService.editStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * KhoaHND
     * create Student
     */
    @RequestMapping(value = "/create-student",method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody CreateUpdateStudentDTO studentDTO){


        if(studentDTO == null){
            return new ResponseEntity<CreateUpdateStudentDTO>(HttpStatus.BAD_REQUEST);
        }else{
            Map<String,String> errors  = studentValidator.validate(studentDTO);
            if(errors.isEmpty()){
                Account account = new Account();
                account.setUsername(studentDTO.getEmail());
                account.setPassword("123");
                account = IAccountService.registerAccount(account);

                AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
                accountRoleDTO.setAccountId(account.getAccountId());
                accountRoleDTO.setRoleId(3);
                IAccountRoleService.registerAccountRole(accountRoleDTO);

                studentDTO.setAccountId(account.getAccountId());
                IStudentService.createNewStudent(studentDTO);

                return new ResponseEntity<CreateUpdateStudentDTO>(studentDTO, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
            }
        }

    }

    /**
     * KhoaHND
     * Find Student By Id
     */
    @RequestMapping(value = "/get-student-by-studentId/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<IStudentEditDTO> findStudentById(@PathVariable Integer studentId){
        IStudentEditDTO student = IStudentService.findStudentByStudentId(studentId);
        if (student == null){
            return new ResponseEntity<IStudentEditDTO>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<IStudentEditDTO>(student, HttpStatus.OK);
    }
}
