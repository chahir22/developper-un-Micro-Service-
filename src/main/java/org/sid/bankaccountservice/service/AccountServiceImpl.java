package org.sid.bankaccountservice.service;


import jakarta.transaction.Transactional;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository accountRepository;


    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO) {
        return null;
    }
}
