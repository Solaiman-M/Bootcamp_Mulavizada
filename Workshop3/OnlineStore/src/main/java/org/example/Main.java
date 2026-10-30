package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = FileManger.readProduct();
        List<Product> cart = new ArrayList<>();
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
                                while (pick < 0 && pick > 4) {
                                    System.out.printf("You Enter a worng number, Try to pick a number between 1-2: ");
                                    pick = Integer.parseInt(scanner.nextLine());
                                }
                            } catch (Exception ex) {
                                System.out.printf("You need to Enter a NUMBER between 1-4: ");
                                pick = Integer.parseInt(scanner.nextLine());
                            }

                            if (pick > 0 && pick < 4) {
                                break;
                            }

                        }

                        switch (pick) {

                            case 1:
                                System.out.println();
                                System.out.println("Products: ");
                                for(Product p : productList){
                                    System.out.printf("%d|%s|%s|%.2f|%s%n",p.getId(),p.getsKU(),p.getProductName(),p.getPrice(),p.getDepartment());
                                }
                                int addChoice;
                                boolean found;
                                System.out.println();
                                System.out.println("Do you want to add a product to your cart? ");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.printf("Enter your choice: ");
                                found = true;
                                try {
                                    addChoice = Integer.parseInt(scanner.nextLine());
                                    if (addChoice == 1) {
                                        System.out.print("Enter the Product ID: ");
                                        int idChecker = Integer.parseInt(scanner.nextLine());

                                        for (Product p : productList) {
                                            if (p.getId() == idChecker) {
                                                cart.add(p);
                                                System.out.println(p.getProductName() + "has been add to your cart. ");
                                                found = false;
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("You Enter a wrong product ID. Returning to product screen.");
                                        }
                                    } else if (addChoice == 2) {
                                        System.out.println("Returning to product menu. ");
                                    } else {
                                        System.out.println("You Enter a wrong number.");
                                    }
                                    break;
                                } catch (Exception ex) {
                                    System.out.printf("You Enter something that is not a number. Returning to product screen.");
                                    System.out.println();
                                }
                                break;


                            case 2:
                                System.out.println();
                                System.out.printf("What department are you looking for? :");
                                String depChecker = scanner.nextLine();
                                System.out.println("ID|Product Name|Price|Product Department");
                                for(Product product : productList){
                                    if(product.getDepartment().equalsIgnoreCase(depChecker)){
                                        System.out.printf("%d|%s|%s|%.2f|%s%n",product.getId(),product.getsKU(),product.getProductName(),product.getPrice(),product.getDepartment());
                                    }
                                }
                                System.out.println();
                                System.out.println("Do you want to add a product to your cart? ");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.printf("Enter your choice: ");
                                found = true;
                                try {
                                    addChoice = Integer.parseInt(scanner.nextLine());
                                    if (addChoice == 1) {
                                        System.out.print("Enter the Product ID: ");
                                        int idChecker = Integer.parseInt(scanner.nextLine());

                                        for (Product p : productList) {
                                            if (p.getId() == idChecker) {
                                                cart.add(p);
                                                System.out.println(p.getProductName() + "has been add to your cart. ");
                                                found = false;
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("You Enter a wrong product ID. Returning to product screen.");
                                        }
                                    } else if (addChoice == 2) {
                                        System.out.println("Returning to product menu. ");
                                    } else {
                                        System.out.println("You Enter a wrong number.");
                                    }
                                    break;
                                } catch (Exception ex) {
                                    System.out.printf("You Enter something that is not a number. Returning to product screen.");
                                    System.out.println();
                                }
                                break;

                            case 3:
                                found = true;
                                System.out.print("Enter your min price: ");
                                double min = Double.parseDouble(scanner.nextLine());

                                System.out.print("Enter your max price: ");
                                double max = Double.parseDouble(scanner.nextLine());

                                for(Product product : productList){
                                    if(min <= product.getPrice() && max >= product.getPrice()){
                                        System.out.printf("%d|%s|%s|%.2f|%s%n",product.getId(),product.getsKU(),product.getProductName(),product.getPrice(),product.getDepartment());
                                        found = false;
                                    }
                                }
                                System.out.println();
                                System.out.println("Do you want to add a product to your cart? ");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.printf("Enter your choice: ");
                                found = true;
                                try {
                                    addChoice = Integer.parseInt(scanner.nextLine());
                                    if (addChoice == 1) {
                                        System.out.print("Enter the Product ID: ");
                                        int idChecker = Integer.parseInt(scanner.nextLine());

                                        for (Product p : productList) {
                                            if (p.getId() == idChecker) {
                                                cart.add(p);
                                                System.out.println(p.getProductName() + "has been add to your cart. ");
                                                found = false;
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("You Enter a wrong product ID. Returning to product screen.");
                                        }
                                    } else if (addChoice == 2) {
                                        System.out.println("Returning to product menu. ");
                                    } else {
                                        System.out.println("You Enter a wrong number.");
                                    }
                                    break;
                                } catch (Exception ex) {
                                    System.out.printf("You Enter something that is not a number. Returning to product screen.");
                                    System.out.println();
                                }
                                break;
                            case 4:
                                pick = 0;
                                break;
                        }
                        break;
                    case 2:

                        break;
                    case 0:
                        choice = 0;
                        break;
                }
            }
        }
        System.out.println("Thank you for shopping. ");
    }
}