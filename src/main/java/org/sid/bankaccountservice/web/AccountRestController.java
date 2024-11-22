package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository accountRepository;
    public AccountRestController(BankAccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }


    @GetMapping("/bankAccounts")
    public List<BankAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getAccountById(@PathVariable String id) {
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }

    @PostMapping("/bankAccount")
    public BankAccount createAccount(@RequestBody BankAccount bankaccount) {
        return accountRepository.save(bankaccount);
    }

    @PostMapping("/bankAccount/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankaccount) {
        BankAccount account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
        account.setBalance(bankaccount.getBalance());
        account.setDateCreation(new Date());
        account.setType(bankaccount.getType());
        account.setCurrency(bankaccount.getCurrency());
        return accountRepository.save(bankaccount);
    }

}
