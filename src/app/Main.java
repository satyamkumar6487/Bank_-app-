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
                case "6" -> listAccount(sc);
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
            bankService.openAccount(name, email, type);


        }

        private static void deposit (Scanner sc){

        }

        private static void withdraw (Scanner sc){

        }

        private static void transfer (Scanner sc){

        }

        private static void statements (Scanner sc){

        }

        private static void listAccount (Scanner sc){

        }

        private static void searchAccount (Scanner sc){

        }

    }
