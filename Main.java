package com.company;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String command = "";
        Person session = new Person();
        System.out.println("Welcome to otobank, type help for commands!");
        while (!command.equals("0")) {
            command = scanner.nextLine();
            if (command.equals("1") && session.getUsername() == null) {
                boolean correctusername = false;
                boolean correctpass= false;
                System.out.println("Enter your username:");
                String username = scanner.next();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUsername().equals(username)) {
                        System.out.println("Enter your password:");
                        String password = scanner.next();
                        correctusername = true;
                        if (users.get(i).getPassword().equals(password)) {
                            session.setUsername(users.get(i).getUsername());
                            session.setLastName(users.get(i).getLastName());
                            session.setUsername(users.get(i).getUsername());
                            session.setPassword(users.get(i).getPassword());
                            session.setBalance(users.get(i).getBalance());
                            System.out.println("LOGGED IN");
                            correctpass = true;
                        }
                    }

                }
                if (correctusername == false) {
                    System.out.println("incorrect username");
                }
                if (correctusername == true && correctpass == false) {
                    System.out.println("incorrect password");
                }
            } else if (command.equals("1") && session.getUsername() != null) {
                System.out.println("You are already logged in! log out to log in again.");
            } else if (command.equals("2") && session.getUsername() == null) {
                Person p = new Person();
                System.out.println("First name:");
                String firstName = scanner.nextLine();
                p.setFirstName(firstName);
                System.out.println("Last name:");
                String lastName = scanner.nextLine();
                p.setLastName(lastName);
                System.out.println("Username:");
                String username = scanner.nextLine();
                p.setUsername(username);
                System.out.println("Password:");
                String password = scanner.nextLine();
                p.setPassword(password);
                p.setBalance(0);
                users.add(p);
                System.out.println("Account successfully created! you can log in now.");
            } else if (command.equals("2") && session.getUsername() != null) {
                System.out.println("You are already logged in! log out to log in again.");
            } else if (command.equals("3") && session.getUsername() != null) {
                System.out.println("Your current balance is " + session.getBalance() + " usd");
            } else if (command.equals("3") && session.getUsername() == null) {
                System.out.println("Login to see your balance!");
            }else if (command.equals("4") && session.getUsername() != null) {
                System.out.println("Enter amount of money you want to deposit: ");
                int money = scanner.nextInt();
                double accountBalance = session.getBalance();
                session.setBalance(money + accountBalance);
                System.out.println("Added " + money + " usd to balance");
            } else if (command.equals("4") && session.getUsername() == null) {
                System.out.println("Login to deposit!");
            }else if (command.equals("5") && session.getUsername() != null) {
                System.out.println("How much money you want to withdrow? ");
                int money = scanner.nextInt();
                if (session.getBalance() >= money) {
                    session.setBalance(session.getBalance() - money);
                    System.out.println("Withdrawed " + money + " usd");
                } else {
                    System.out.println("not enough balance");
                }
            } else if (command.equals("5") && session.getUsername() == null) {
                System.out.println("Login to see Withdraw!");
            } else if (command.equals("help")) {
                System.out.println("0 - Exit");
                System.out.println("1 - Login");
                System.out.println("2 - Register");
                System.out.println("3 - View Balance");
                System.out.println("4 - Deposit");
                System.out.println("5 - Withdraw");
            } else if (!command.equals("0")){
                System.out.println("Unknown command!");
            } else if (command.equals("0")) {
                System.out.println("Program Closed!");
            }
        }
    }
}
