package service;

import domain.Account;

import java.util.UUID;

import repository.AccountRepository;
import service . BankService;

public class  BankServiceImpl implements BankService  {
   private final  AccountRepository accountRepository = new AccountRepository();
    @Override
    public String openAccount(String name, String email, String AccountType) {

        String customerId = UUID.randomUUID().toString();
//String accountNumber = UUID.randomUUID().toString();

        String temp = accountRepository.findAll.size() + 1;
        String accountNumber = String .format("Ac%06d" , temp);


        Account account = new Account(accountNumber, AccountType, (double) 0 , customerId);

accountRepository.save (account);
        return accountNumber;
    }
}
