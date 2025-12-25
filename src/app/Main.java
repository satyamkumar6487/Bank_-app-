package app;

import service.BankService;
import service.BankServiceImpl;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();

        boolean running = true;
        System.out.println("Welcome to console Bank");

        while (running) {

            System.out.println("""
                    
                    1 ) open Account
                    2) Deposit
                    3)withdraw 
                    4)Transfer
                    5)Account Statement
                    6)List Account
                    7)Search Account By Customer
                    0)exit
                    
                    
                    
                    
                    """);

            System.out.println("Choose ");

            String Choice = sc.nextLine().trim();

            System.out.println("Choice " + Choice);

            switch (Choice) {

                case "1" -> openAccount(sc, bankService);
                case "2" -> deposit(sc);
                case "3" -> withdraw(sc);
                case "4" -> transfer(sc);
                case "5" -> statements(sc);
                case "6" -> listAccount(sc , bankService);
                case "7" -> searchAccount(sc);
                case "0" -> running = false;


            }
        }
        }

        private static void openAccount (Scanner sc , BankService bankService){
            System.out.println("Customer name ");
            String name = sc.nextLine().trim();
            System.out.println(" customer email ");
            String email = sc.nextLine().trim();
            System.out.println("Account type (Saving / Current)");
            String type = sc.nextLine().trim();
            System.out.println("initial Deposit(optional , blank for 0");
            String amountstr = sc.nextLine().trim();
            Double initial = Double.valueOf(amountstr);
             String accountNumber = bankService.openAccount(name, email, type);

            if (initial > 0 )
                bankService.deposit();
                System.out.println("Account Opened " + accountNumber);


        }

        private static void deposit (Scanner sc , BankService bankService){

        System.out.println ("Account number :  ");
        String accountNumber = sc.nextLine().trim();
        System.out.println ("Amount");
        Double amount = Double .valueOf(sc.nextLine().trim());
        bankService.deposit (accountNumber, amount,"Depposit" );


        }

        private static void withdraw (Scanner sc){

        }

        private static void transfer (Scanner sc){

        }

        private static void statements (Scanner sc){

        }

        private static void listAccount (Scanner sc , BankService bankService){

        bankService.listAccount().forEach(a -> {

            System.out.println(a.getAccountNumber()+ " | "  + a. getAccountType() + " | " + a .getBalance());
        });

        }

        private static void searchAccount (Scanner sc){

        }

    }
