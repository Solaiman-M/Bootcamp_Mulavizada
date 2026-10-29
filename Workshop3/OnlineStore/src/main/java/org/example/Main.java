package org.example;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = FileManger.readProduct();
        int choice = -1;


        while (choice != 0){
            while(choice != 0) {
                System.out.println();
                System.out.println("           Home Screen           ");
                System.out.println("1. Display Product");
                System.out.println("2. Display Cart ");
                System.out.println("0. Exit");
                System.out.printf("Welcome to home screen. Pick a number between 0-2: ");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    while (choice < 0 && choice > 3) {
                        System.out.printf("You Enter a worng number, Try to pick a number between 0-2: ");
                        choice = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                } catch (Exception ex) {
                    System.out.printf("You need to Enter a NUMBER between 0-2: ");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                if (choice > 0 || choice < 3) {
                    break;
                }
            }

            while(choice > 0 && choice < 3){
                switch (choice){
                    case 1:
                        int pick = -2;
                        while(pick != 0) {
                            System.out.println();
                            System.out.println("           Welcome to Product Screen           ");
                            System.out.println("1. Search a Product");
                            System.out.println("2. Exit");
                            System.out.printf("Pick a number between 1-2: ");

                            try {
                                pick = Integer.parseInt(scanner.nextLine());
                                while (pick < 0 && pick > 3) {
                                    System.out.printf("You Enter a worng number, Try to pick a number between 1-2: ");
                                    pick = Integer.parseInt(scanner.nextLine());
                                }
                            } catch (Exception ex) {
                                System.out.printf("You need to Enter a NUMBER between 1-2: ");
                                pick = Integer.parseInt(scanner.nextLine());
                            }

                            if (pick > 0 && pick < 3) {
                                break;
                            }

                        }

                        switch (pick){
                            case 1:
                                System.out.println();
                                System.out.println("Products: ");
                                for(int i = 0; i < productList.size(); i++ ){
                                    Product p = productList.get(i);
                                    System.out.printf("%d|%s|%s|%.2f%n|%s",p.getId(),p.getsKU(),p.getProductName(),p.getPrice(),p.getDepartment());
                                }
                                break;
                            case 2:
                                break;
                        }
                        break;
                    case 2:

                        break;
                }
            }
        }
        System.out.println("Thank you for shopping. ");

    }
}