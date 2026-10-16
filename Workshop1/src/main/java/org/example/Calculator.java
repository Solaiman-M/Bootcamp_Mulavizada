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

        System.out.println("Please select a calculator (0-3)");
        int calNum =scanner.nextInt();


        while(calNum >0 || 0 < calNum);
        {
            if (calNum <=3) {
                switch (calNum){
                    case 1:

                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                }

            } else {
                System.out.println("You enter a wrong number.");
            }

        }
            System.out.println("Thank you for visiting our website.");



    }
}


