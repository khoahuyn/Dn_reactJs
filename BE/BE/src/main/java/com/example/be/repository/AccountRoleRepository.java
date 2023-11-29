package com.example.be.repository;


import com.example.be.entity.Account;
import com.example.be.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {
    List<AccountRole> findAllByAccount(Account account);

    @Modifying
    @Query(value = "INSERT INTO `Doanit`.`account_role` (`account_id`, `role_id`) VALUES (?1, ?2) ", nativeQuery = true)
    void createRole(Integer accountId, Integer roleId);
}
