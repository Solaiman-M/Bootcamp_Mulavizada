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
                System.out.println("1. Product Screen");
                System.out.println("2. Display Cart ");
                System.out.println("0. Exit");
                System.out.printf("Welcome to home screen. Pick a number between 0-2: ");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    while (choice < 0 && choice > 2) {
                        System.out.printf("You Enter a worng number, Try to pick a number between 0-2: ");
                        choice = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                } catch (Exception ex) {
                    System.out.printf("You need to Enter a NUMBER between 0-2: ");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                if (choice > 0 || choice < 2) {
                    break;
                }
            }

            while(choice > 0 && choice < 2){
                switch (choice){
                    case 1:
                        int pick = -2;
                        while(pick != 0) {
                            System.out.println();
                            System.out.println("           Welcome to Product Screen           ");
                            System.out.println("1. Display products");
                            System.out.println("2. Search with Department");
                            System.out.println("3. Search by price range");
                            System.out.println("4. Exit");
                            System.out.printf("Pick a number between 1-4: ");

                            try {
                                pick = Integer.parseInt(scanner.nextLine());
                                while (pick < 0 && pick > 2) {
                                    System.out.printf("You Enter a worng number, Try to pick a number between 1-2: ");
                                    pick = Integer.parseInt(scanner.nextLine());
                                }
                            } catch (Exception ex) {
                                System.out.printf("You need to Enter a NUMBER between 1-2: ");
                                pick = Integer.parseInt(scanner.nextLine());
                            }

                            if (pick > 0 && pick < 2) {
                                break;
                            }

                        }

                        switch (pick) {

                            case 1:
                                System.out.println();
                                System.out.println("Products: ");
                                for(Product p : productList){
                                    System.out.printf("%d|%s|%s|%.2f%n|%s",p.getId(),p.getsKU(),p.getProductName(),p.getPrice(),p.getDepartment());
                                }
                                break;
                            case 2:

                                System.out.printf("What department are you looking for? :");
                                String depChecker = scanner.nextLine();
                                for(Product product : productList){

                                    if(product.getDepartment().equalsIgnoreCase(depChecker)){
                                        for(int i = 0; i < productList.size(); i++ ){
                                            Product p = productList.get(i);
                                            System.out.println();
                                            System.out.printf("%d|%s|%.2f|%s%n",product.getId(),product.getProductName(),product.getPrice(),product.getDepartment());
                                        }
                                        break;
                                    }

                                }
                                break;

                            case 3:
                                pick = 0;
                                break;
                        }
                        break;
                    case 0:
                        break;
                }
            }
        }
        System.out.println("Thank you for shopping. ");

    }
}