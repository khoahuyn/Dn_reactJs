package com.example.be.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;

@Entity
@Table(name="student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    private String name;

    private String dateOfBirth;

    private String address;

    private String phone;

    private String email;

    private String avatar;

    private Boolean gender;

    @Column(name = "delete_flag")
    private Boolean deleteFlag;


    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "grade_id")
    private Grade grade;

    @JsonBackReference(value = "account")
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;


    public Student() {
    }

    public Student(Integer studentId, String name, String dateOfBirth, String address, String phone, String email, String avatar, Boolean gender, Boolean deleteFlag, Grade grade, Account account) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
        this.gender = gender;
        this.deleteFlag = deleteFlag;
        this.grade = grade;
        this.account = account;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
