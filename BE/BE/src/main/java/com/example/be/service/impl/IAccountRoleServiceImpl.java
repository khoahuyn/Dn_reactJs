package com.example.be.service.impl;


import com.example.be.dto.AccountRoleDTO;
import com.example.be.repository.AccountRoleRepository;
import com.example.be.service.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAccountRoleServiceImpl implements IAccountRoleService {
    @Autowired
    AccountRoleRepository AccountRoleRepository;

    @Override
    public void registerAccountRole(AccountRoleDTO accountRoleDTO) {
        AccountRoleRepository.createRole(accountRoleDTO.getAccountId(), accountRoleDTO.getRoleId());
    }
}
