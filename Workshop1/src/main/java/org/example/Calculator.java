package org.example;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Financial Calculator Menu ---");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator (Compound Interest)");
        System.out.println("3. Present Value of Annuity Calculator");
        System.out.println("0. Exit");

        System.out.print("Please select a calculator (0-3): ");
        int calNum =scanner.nextInt();

        while(calNum >0 || 0 < calNum)
        {
            if (0<calNum && calNum <=3) {
                switch (calNum) {
                    case 1:

                        System.out.printf("Enter your Loan Principle: ");
                        double p = scanner.nextDouble(); //p for prrinciple

                        System.out.printf("Enter the Interest Rate: ");
                        double r = scanner.nextDouble(); // r for interest rate

                        System.out.printf("What is your loan length in Years? ");

                        int n = scanner.nextInt(); // n for year length

                        double mR = (r / 100.0) / 12.0; //monthly interest rate
                        double mN = n * 12; //number of monthly payment

                        double powerResult = Math.pow(1 + mR, mN);
                        double m = (p * mR * powerResult) / (powerResult - 1);
                        double totalInterestPaid = ((m * mN) - p);
                        //totalInterestPaid = totalInterestPaid * -1;

                            /*
                            double yearlyPrinciple = p/n;
                            double monthlyPrinciple = yearlyPrinciple/12;
                            double montlyInterestRateInDecimal = r/1200;
                            double m = monthlyPrinciple * montlyInterestRateInDecimal;
                            */

                        System.out.printf("Your monthly payment is: $%.2f%n", m);
                        System.out.printf("Your Total Interest paid is: $%.2f%n", totalInterestPaid);

                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                }
                if(calNum>0){
                    System.out.println("");
                    System.out.println("");
                    System.out.println("--- Financial Calculator Menu ---");
                    System.out.println("1. Mortgage Calculator");
                    System.out.println("2. Future Value Calculator (Compound Interest)");
                    System.out.println("3. Present Value of Annuity Calculator");
                    System.out.println("0. Exit");

                    System.out.print("Please select a calculator (0-3): ");
                    calNum =scanner.nextInt();
                }

            } else {
                System.out.println("You enter a wrong number.");
                break;
            }

        }
            System.out.println("Thank you for visiting our website.");



    }
}


