package com.example.account_service.util;

import com.example.account_service.dto.AccountDTO;
import com.example.account_service.entities.Account;

public class AccountConverter {

    // 将 Account 转换为 AccountDTO
    public static AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setEmail(account.getEmail());
        dto.setUsername(account.getUsername());
        dto.setShippingAddress(account.getShippingAddress());
        dto.setBillingAddress(account.getBillingAddress());
        dto.setPaymentMethod(account.getPaymentMethod());
        return dto;
    }
}

