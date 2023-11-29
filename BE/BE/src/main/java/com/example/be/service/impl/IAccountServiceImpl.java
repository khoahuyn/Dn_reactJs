package com.example.be.service.impl;


import com.example.be.entity.Account;
import com.example.be.repository.AccountRepository;
import com.example.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account getAccountById(Integer accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public Account getAccountByIdStudent(Integer studentId) {
        return accountRepository.findAccountByStudent(studentId);
    }


    @Override
    public void changePassword(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account registerAccount(Account account) {
        return accountRepository.save(account);
    }
}
