package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.enums.AccountType;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication{

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankaccountRepository)
    {
        return args -> {

            for(int i=0;i<10;i++)
            {
                BankAccount b1 = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(Math.random()*90000)
                        .currency("MAD")
                        .dateCreation(new Date())
                        .build();

                bankaccountRepository.save(b1);

            }
        };
    }


}
