package org.sid.bankaccountservice.service;


import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;



public interface AccountService {

    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO);
}
