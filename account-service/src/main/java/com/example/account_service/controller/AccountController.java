package com.example.account_service.controller;

import com.example.account_service.dto.AccountDTO;
import com.example.account_service.entities.Account;
import com.example.account_service.payload.AccountRequest;
import com.example.account_service.service.AccountService;
import com.example.account_service.util.AccountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 创建账户
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountRequest request) {
        Account account = new Account();
        account.setEmail(request.getEmail());
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        account.setShippingAddress(request.getShippingAddress());
        account.setBillingAddress(request.getBillingAddress());
        account.setPaymentMethod(request.getPaymentMethod());
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(AccountConverter.toDTO(createdAccount));
    }

    // 更新账户（根据 ID）
    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(
            @PathVariable Long id,
            @RequestBody AccountRequest request) {
        Account accountDetails = new Account();
        accountDetails.setEmail(request.getEmail());
        accountDetails.setUsername(request.getUsername());
        accountDetails.setPassword(request.getPassword());
        accountDetails.setShippingAddress(request.getShippingAddress());
        accountDetails.setBillingAddress(request.getBillingAddress());
        accountDetails.setPaymentMethod(request.getPaymentMethod());
        Optional<Account> updatedAccount = accountService.updateAccount(id, accountDetails);
        return updatedAccount.map(account -> ResponseEntity.ok(AccountConverter.toDTO(account)))
                .orElse(ResponseEntity.notFound().build());
    }

    // 根据 ID 查找账户
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        Optional<Account> accountOpt = accountService.getAccountById(id);
        return accountOpt.map(account -> ResponseEntity.ok(AccountConverter.toDTO(account)))
                .orElse(ResponseEntity.notFound().build());
    }
}