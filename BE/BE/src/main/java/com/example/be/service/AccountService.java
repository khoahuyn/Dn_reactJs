package com.example.be.service;


import com.example.be.entity.Account;

public interface AccountService {

    Account findByUsername(String username);

    Account getAccountById(Integer idAccount);

    Account getAccountByIdStudent(Integer id);

    void changePassword(Account account);

    Account registerAccount(Account account);
}
