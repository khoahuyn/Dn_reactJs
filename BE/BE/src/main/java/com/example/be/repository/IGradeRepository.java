package com.example.be.repository;


import com.example.be.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGradeRepository extends JpaRepository<Grade, Integer> {
}
