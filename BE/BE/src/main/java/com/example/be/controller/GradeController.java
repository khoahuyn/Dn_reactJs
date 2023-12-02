package com.example.be.controller;

import com.example.be.entity.Grade;
import com.example.be.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class GradeController {
    @Autowired
    IGradeService gradeService;


    /**
     * KhoaHND
     * Find all grade
     */
    @RequestMapping(value = "/get-all-grade", method = RequestMethod.GET)
    public ResponseEntity<List<Grade>> getAllGrade(){
        List<Grade> listGrade = gradeService.getAllGrade();
        if(listGrade.isEmpty()){
            return new ResponseEntity<List<Grade>>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Grade>>(listGrade, HttpStatus.OK);
    }
}
