package com.example.be.controller;
import com.example.be.dto.AccountRoleDTO;
import com.example.be.dto.CreateUpdateStudentDTO;
import com.example.be.dto.IStudentEditDTO;
import com.example.be.entity.Account;
import com.example.be.service.AccountRoleService;
import com.example.be.service.AccountService;
import com.example.be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRoleService accountRoleService;





    /**
     * KhoaHND
     * Edit Student
     */
    @RequestMapping(value = "/edit-student", method = RequestMethod.PUT)
    public ResponseEntity<?> editStudent(@RequestBody CreateUpdateStudentDTO studentDTO){
        studentService.editStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * KhoaHND
     * create Student
     */
    @RequestMapping(value = "/create-student")
    public ResponseEntity<CreateUpdateStudentDTO> createStudent(@RequestBody CreateUpdateStudentDTO studentDTO){


        if(studentDTO == null){
            return new ResponseEntity<CreateUpdateStudentDTO>(HttpStatus.BAD_REQUEST);
        }
        Account account = new Account();
        account.setUsername(studentDTO.getEmail());
        account.setPassword("123");
        account = accountService.registerAccount(account);

        AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
        accountRoleDTO.setAccountId(account.getAccountId());
        accountRoleDTO.setRoleId(3);
        accountRoleService.registerAccountRole(accountRoleDTO);

        studentDTO.setAccountId(account.getAccountId());
        studentService.createNewStudent(studentDTO);

        return new ResponseEntity<CreateUpdateStudentDTO>(studentDTO, HttpStatus.OK);
    }

    /**
     * KhoaHND
     * Find Student By Id
     */
    @RequestMapping(value = "/get-student-by-studentId/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<IStudentEditDTO> findStudentById(@PathVariable Integer studentId){
        IStudentEditDTO student = studentService.findStudentByStudentId(studentId);
        if (student == null){
            return new ResponseEntity<IStudentEditDTO>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<IStudentEditDTO>(student, HttpStatus.OK);
    }
}
