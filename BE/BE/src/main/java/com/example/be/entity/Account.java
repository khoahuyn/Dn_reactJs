package com.example.be.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    private String username;

    private String password;

    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoleList;

    @OneToOne(mappedBy = "account")
    private Student student;


    public Account() {
    }

    public Account(Integer accountId, String username, String password, List<AccountRole> accountRoleList, Student student) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.accountRoleList = accountRoleList;
        this.student = student;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public List<AccountRole> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(List<AccountRole> accountRoleList) {
        this.accountRoleList = accountRoleList;
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
