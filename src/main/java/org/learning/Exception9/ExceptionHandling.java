package org.learning.Exception9;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args)throws ArithmeticException {
        System.out.println("Connection Established");
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter num:");
            int num = sc.nextInt();
            System.out.println("Enter den:");
            int den = sc.nextInt();
            int result = num/den;
            System.out.println("Result is : "+result);
            sc.close();
        } catch(ArithmeticException e) {
            System.out.println("please enter non-zero denominator");
            throw e;
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }
        finally {
            System.out.println("Connection Terminated");
        }
    }
}
