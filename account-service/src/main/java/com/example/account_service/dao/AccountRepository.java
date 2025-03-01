package com.example.account_service.dao;

import com.example.account_service.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // optional,find by email
    Account findByEmail(String email);
}
