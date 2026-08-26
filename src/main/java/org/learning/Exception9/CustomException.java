package org.learning.Exception9;

import java.util.Scanner;
//Own Custom Exception
class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException(String msg) {
        super(msg);
    }
}

class Atm{
    private int acc = 4545;
    private int pass = 1234;

    int accountNo;
    int password;

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter accountNo:");
        accountNo = sc.nextInt();
        System.out.println("Enter password:");
        password = sc.nextInt();
    }

    public void verify() throws InvalidCustomerException{
        if(acc == accountNo && pass == password){
            System.out.println("Proceed to withdraw cash!");
        } else{
            InvalidCustomerException ice = new InvalidCustomerException("Invalid Credentials");
            System.out.println(ice.getMessage());
            throw ice;
//            or
//            throw new InvalidCustomerException();
        }
    }
}

class Bank{
    public void initiate (){
        Atm atm = new Atm();
        try {
            atm.input();
            atm.verify();
        }catch(InvalidCustomerException ice){
            System.out.println("Try Again");
            try {
                atm.input();
                atm.verify();
            }catch(InvalidCustomerException ice1){
                System.out.println("Try Again");
                try {
                    atm.input();
                    atm.verify();
                }catch(InvalidCustomerException ice2){
                    System.out.println("you seems like scammer ! cant give you another chance");
                }
            }
        }
    }
}

public class CustomException {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.initiate();
    }
}
