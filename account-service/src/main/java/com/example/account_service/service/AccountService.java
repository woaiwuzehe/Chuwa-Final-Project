package com.example.account_service.service;

import com.example.account_service.dao.AccountRepository;
import com.example.account_service.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> updateAccount(Long id, Account accountDetails) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setEmail(accountDetails.getEmail());
            account.setUsername(accountDetails.getUsername());
            account.setPassword(accountDetails.getPassword());
            account.setShippingAddress(accountDetails.getShippingAddress());
            account.setBillingAddress(accountDetails.getBillingAddress());
            account.setPaymentMethod(accountDetails.getPaymentMethod());
            return Optional.of(accountRepository.save(account));
        }
        return Optional.empty();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }
}