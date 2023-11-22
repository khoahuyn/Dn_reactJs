package com.example.be.service.impl;


import com.example.be.dto.AccountRoleDTO;
import com.example.be.repository.AccountRoleRepository;
import com.example.be.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Override
    public void registerAccountRole(AccountRoleDTO accountRoleDTO) {
        accountRoleRepository.createRole(accountRoleDTO.getAccountId(), accountRoleDTO.getRoleId());
    }
}
