package com.example.be.service.impl;


import com.example.be.dto.AccountRoleDTO;
import com.example.be.repository.IAccountRoleRepository;
import com.example.be.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    IAccountRoleRepository IAccountRoleRepository;

    @Override
    public void registerAccountRole(AccountRoleDTO accountRoleDTO) {
        IAccountRoleRepository.createRole(accountRoleDTO.getAccountId(), accountRoleDTO.getRoleId());
    }
}
