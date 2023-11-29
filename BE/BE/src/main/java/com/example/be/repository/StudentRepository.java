package com.example.be.repository;
import com.example.be.dto.IStudentEditDTO;
import com.example.be.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {



    /**
     * KhoaHND
     * Edit Student
     */
    @Modifying
    @Query(value = "update student set student.name = ?1, student.email = ?2, student.avatar = ?3, student.address = ?4, " +
            "student.date_of_birth = ?5, student.phone =?6, student.grade_id = ?7,student.gender = ?8 where student.student_id=?9 ",nativeQuery = true)
    void editStudent(String name, String email, String avatar, String address, String dayOfBirth, String phone,Integer grade,Boolean gender, Integer studentId);

    /**
     * KhoaHND
     * Add New Student
     */
    @Modifying
    @Query(value = "insert into student(student.name, student.email, student.avatar, student.address, " +
            " student.date_of_birth, student.phone, student.grade_id, student.account_id, student.gender, student.delete_flag)" +
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9, true) ",nativeQuery = true)
    void addNewStudent(String name, String email, String avatar, String address, String dayOfBirth,String phone, Integer grade,Integer accountId, Boolean gender);

    /**
     * KhoaHND
     * find By Id
     */
    @Query(value = "select student.student_id as studentId, student.name as name, student.date_of_birth as dateOfBirth, student.phone as phone," +
            "student.grade_id as grade, student.address as address, student.email as email, student.avatar as avatar, student.gender as gender from student where student.student_id = ?1 and student.delete_flag = 1", nativeQuery = true)
    IStudentEditDTO findStudentByStudentId(Integer studentId);

}
