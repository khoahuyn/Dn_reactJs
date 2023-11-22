package com.example.be.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoleList;

    @OneToOne(mappedBy = "account")
    private Student student;


    public Account() {
    }

    public Account(Integer id, String username, String password, List<AccountRole> accountRoleList, Student student) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountRoleList = accountRoleList;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
