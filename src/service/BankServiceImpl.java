package service;

import domain.Account;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import repository.AccountRepository;
import service . BankService;

public class  BankServiceImpl implements BankService  {
   private final  AccountRepository accountRepository = new AccountRepository();
    @Override
    public String openAccount(String name, String email, String accountType) {

        String customerId = UUID.randomUUID().toString();
//String accountNumber = UUID.randomUUID().toString();

String accountNumber = getAccountNuber();


        Account account = new Account(accountNumber, customerId , (double) 0 , accountType);

accountRepository.save (account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccount() {
        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account:: getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, Double amount, String deposit) {

        Account account = accountRepository .findByNumber(accountNumber)
        .orElseThrow(( )-> new RuntimeException("Account not found" + accountNumber));




    }


    private String getAccountNuber(){
        int size  = accountRepository.findAll().size() + 1;

    return String .format("Ac%06d" , size ) ;
    }


}
