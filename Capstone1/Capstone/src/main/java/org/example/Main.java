package org.example;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Ledger> ledgerList = FileManager.readLedger();
        boolean running = true;
        while(running){
            System.out.println("=".repeat(67));
            System.out.println("=".repeat(67));
            System.out.println(" ".repeat(28)+"LEDGER FLOW");
            System.out.println(" ".repeat(22)+"OFFICE ACCOUNTING SYSTEM");
            System.out.println(" ".repeat(29)+"MAIN MENU");
            System.out.println("=".repeat(67));
            System.out.println("[D]  Add Deposit");
            System.out.println("[P]  Make Payment");
            System.out.println("[L]  Ledger");
            System.out.println("[X]  Exit");
            System.out.println("-".repeat(67));
            System.out.print("Choose an Option: ");
            String choice = scanner.nextLine().toUpperCase().trim();
            System.out.println("=".repeat(67));

            switch (choice){
                case "D":
                    addDeposit();
                    break;

                case "P":
                    addPayment();
                    break;

                case "L":
                    ledgerMenu();
                    break;

                case "X":
                    running = false;
                    System.out.println("Thank you for using LedgerFlow.");
                    System.out.println("Good bye.");
                    System.out.println("=".repeat(67));
                    break;
                default:
                    System.out.println("Invalid menu Option. Try again!");
            }
        }
    }
    public static void addDeposit(){
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine().trim();
        double amount;
        while(true){
            System.out.print("Enter the amount: $");
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                if(amount <= 0){
                    System.out.println("Amount must be greater than zero.");
                    continue;
                }
                break;
            }
            catch (NumberFormatException ex){
                System.out.println("Please enter a valid amount");
            }
        }
        Ledger ledger = new Ledger(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        FileManager.writeLedger(ledger);
    }
    public static void addPayment(){
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine().trim();
        double amount;
        while(true){
            System.out.print("Enter the amount: $");
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                if(amount <= 0){
                    System.out.println("Amount must be greater than zero.");
                    continue;
                }
                break;
            }
            catch (NumberFormatException ex){
                System.out.println("Please enter a valid amount");
            }
        }
        amount = -amount;
        Ledger ledger = new Ledger(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        FileManager.writeLedger(ledger);
    }
    public static void ledgerMenu(){
        boolean home = true;
        while(home) {
            System.out.println("=".repeat(67));
            System.out.println(" ".repeat(28)+"LEDGER FLOW");
            System.out.println(" ".repeat(28)+"LEDGER MENU");
            System.out.println("=".repeat(67));
            System.out.println("[A]  All Transactions");
            System.out.println("[D]  Deposit Report");
            System.out.println("[P]  Purchase Report");
            System.out.println("[M]  More Report Options");
            System.out.println("[H]  Home");
            System.out.println("-".repeat(67));
            System.out.print("Choose an Option: ");
            String choice = scanner.nextLine().toUpperCase().trim();
            System.out.println("=".repeat(67));

            switch (choice) {
                case "A":
                    allEntries();
                    break;

                case "D":
                    depositReader();
                    break;

                case "P":
                    paymentReader();
                    break;

                case "M":
                    reportMenu();
                    break;
                case "H":
                    home = false;
                    System.out.println("Returning back to home screen.");
                    break;
                default:
                    System.out.println("Invalid menu Option. Try again!");

            }
        }
    }
    public static void allEntries(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        List<Ledger> ledgerList = FileManager.readLedger();
        List<Ledger> matchingLedgerList = new ArrayList<>();
        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"TRANSACTIONS");
        System.out.println("=".repeat(118));
        LocalDate today = LocalDate.now();
        System.out.println("REPORT PERIOD INCLUDE ALL RECENT TRANSACTION MADE SINCE:  2022/01/01  TO TODAY'S DATE  "+today+"  Year/Month/Day");
        System.out.println("-".repeat(118));
        System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("-".repeat(118));
        int counting = 0;
        boolean transactionFound = false;
        for(int i = ledgerList.size()-1; i >= 0; i--){
            Ledger ledger = ledgerList.get(i);
            transactionFound = true;
            counting ++;
            if(counting <= 30) {
                System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
            }else{
                break;
            }
        }
        System.out.println("-".repeat(118));
        System.out.println("Total Transactions Found: "+ledgerList.size());
        System.out.println("-".repeat(118));
        if(!transactionFound){
            System.out.println("No Transaction Found.");
            System.out.println("-".repeat(118));
        }
        if(counting > 30) {
            System.out.println("You can only view the latest 30 transactions.");
            System.out.println("Please check report menu or custom for more specifics.");
            System.out.println("-".repeat(118));
        }
    }
    public static void depositReader(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        List<Ledger> ledgerList = FileManager.readLedger();
        List<Ledger> matchingLedgerList = new ArrayList<>();
        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"DEPOSIT TRANSACTION");
        System.out.println("=".repeat(118));
        LocalDate today = LocalDate.now();
        System.out.println("REPORT PERIOD INCLUDE ALL RECENT DEPOSITS MADE SINCE:   2022/01/01   TO TODAY'S DATE  "+today+"   Year/Month/Day");
        System.out.println("-".repeat(118));
        System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("-".repeat(118));
        boolean transactionFound = false;
        int counting = 0;
        for(int i = ledgerList.size()-1;i >= 0; i--){
            Ledger ledger = ledgerList.get(i);
            matchingLedgerList.add(ledger);
            if(ledger.getAmount() > 0) {
                counting++;
                if (counting <= 30) {
                    System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
                    transactionFound = true;
                }
            }
        }
        System.out.println("-".repeat(118));
        System.out.println("Total Transactions Found: "+matchingLedgerList.size());
        System.out.println("-".repeat(118));
        if(!transactionFound){
            System.out.println("No Transaction Found.");
            System.out.println("-".repeat(118));
        }
        if(counting > 30) {
            System.out.println("You can only view the latest 30 deposits.");
            System.out.println("Please check report menu or custom for more specific deposits.");
            System.out.println("-".repeat(118));
        }
    }
    public static void paymentReader() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        List<Ledger> ledgerList = FileManager.readLedger();
        List<Ledger> matchingLedgerList = new ArrayList<>();
        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"PURCHASED TRANSACTIONS");
        System.out.println("=".repeat(118));
        LocalDate today = LocalDate.now();
        System.out.println("REPORT PERIOD INCLUDE ALL RECENT PURCHASES MADE SINCE:   2022/01/01  TO TODAY'S DATE  "+today+"   Year/Month/Day");
        System.out.println("-".repeat(118));
        System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("-".repeat(118));
        boolean transactionFound = false;
        int counting = 0;
        for (int i = ledgerList.size() - 1; i >= 0; i--) {
            Ledger ledger = ledgerList.get(i);
            matchingLedgerList.add(ledger);
            if (ledger.getAmount() < 0) {
                counting ++;
                if(counting <=30) {
                    System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
                }
                transactionFound = true;
            }
        }
        System.out.println("-".repeat(118));
        System.out.println("Total Transactions Found: "+matchingLedgerList.size());
        System.out.println("-".repeat(118));
        if(!transactionFound){

            System.out.println("No Transaction Found.");
            System.out.println("-".repeat(118));
        }
        if(counting > 30) {
            System.out.println("You can only view the latest 30 deposits.");
            System.out.println("Please check report menu or custom for more specific purchase.");
            System.out.println("-".repeat(118));
        }
    }
    public static void reportMenu(){
        boolean exit = true;
        while(exit) {
            System.out.println("=".repeat(67));
            System.out.println(" ".repeat(28)+"LEDGER FLOW");
            System.out.println(" ".repeat(28)+"REPORT MENU");
            System.out.println("=".repeat(67));
            System.out.println("[1] Month To Date");
            System.out.println("[2] Previous Month");
            System.out.println("[3] Year To Date");
            System.out.println("[4] Previous Year");
            System.out.println("[5] Search By Vendor");
            System.out.println("[6] Custom Search");
            System.out.println("[0] Exit");
            System.out.println("-".repeat(67));
            System.out.print("Choose an Option: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("-".repeat(67));


                switch (choice) {
                    case 1:
                        monthToDate();
                        break;

                    case 2:
                        previousMonth();
                        break;

                    case 3:
                        yearToDate();
                        break;

                    case 4:
                        previousYear();
                        break;
                    case 5:
                        searchByVendor();
                        break;
                    case 6:
                        customSearch();
                        break;
                    case 0:
                        exit = false;
                        System.out.println("Returning back to ledger menu.");
                        break;
                    default:
                        System.out.println("Invalid menu option. Try again!");
                }
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid menu option. Please Enter a Number from the list.");
            }
        }

    }
    public static void monthToDate(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        LocalDate today = LocalDate.now();
        LocalDate startOfMonth =today.withDayOfMonth(1);
        List<Ledger> matchingLedgerList = new ArrayList<>();
        List<Ledger> ledgerList = FileManager.readLedger();
        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"MONTH TO DATE REPORTS");
        System.out.println("=".repeat(118));
        System.out.println("REPORT PERIOD: "+startOfMonth+" | "+today+"      Year/Month/Day");
        System.out.println("-".repeat(118));
        System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("-".repeat(118));
        for (int i = ledgerList.size() - 1; i >= 0; i--) {
            Ledger ledger = ledgerList.get(i);
            LocalDate transactionDate = ledger.getDate();
            if (!transactionDate.isBefore(startOfMonth) && !transactionDate.isAfter(today)){
                matchingLedgerList.add(ledger);
            }
        }
        int counting = 0;
        boolean transactionFound = false;
        if(!transactionFound) {
            for (Ledger ledger : matchingLedgerList) {
                transactionFound = true;
                counting++;
                if (counting <= 50) {
                    System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
                }
            }
            System.out.println("-".repeat(118));
            System.out.println("Total Transactions Found: "+matchingLedgerList.size());
            System.out.println("-".repeat(118));
        }
        if(!transactionFound){
            System.out.println("No Transaction Found.");
            System.out.println("-".repeat(118));
        }
        if(counting > 50) {
            System.out.println("You can only view the latest 50 transactions.");
            System.out.println("Please check custom search for more specific transaction.");
            System.out.println("-".repeat(118));
        }
    }
    public static void previousMonth(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        LocalDate today = LocalDate.now();
        LocalDate previousMonth = today.minusMonths(1);
        LocalDate startOfPreviousMonth = previousMonth.withDayOfMonth(1);
        LocalDate endOfMonth = today.withDayOfMonth(1).minusDays(1);
        List<Ledger> ledgerList = FileManager.readLedger();
        List<Ledger> matchingLedgerList = new ArrayList<>();
        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"PREVIOUS MONTH REPORTS");
        System.out.println("=".repeat(118));
        System.out.println("REPORT PERIOD: "+startOfPreviousMonth+" | "+endOfMonth+"      Year/Month/Day");
        System.out.println("-".repeat(118));
        System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("-".repeat(118));

        for (int i = ledgerList.size() - 1; i >= 0; i--) {
            Ledger ledger = ledgerList.get(i);
            LocalDate transactionDate = ledger.getDate();
            if (!transactionDate.isBefore(startOfPreviousMonth) && !transactionDate.isAfter(endOfMonth)){
                matchingLedgerList.add(ledger);
            }
        }
        int counting = 0;
        boolean transactionFound = false;
        if(!transactionFound) {
            for (Ledger ledger : matchingLedgerList) {
                transactionFound = true;
                counting++;
                if (counting <= 50) {
                    System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
                }
            }
            System.out.println("-".repeat(118));
            System.out.println("Total Transactions Found: "+matchingLedgerList.size());
            System.out.println("-".repeat(118));
        }
        if(!transactionFound){
            System.out.println("No Transaction Found.");
            System.out.println("-".repeat(118));
        }
        if(counting > 50) {
            System.out.println("You can only view the latest 50 transactions.");
            System.out.println("Please check custom search for more specific transaction.");
            System.out.println("-".repeat(118));
        }
    }
    public static void yearToDate(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        List<Ledger> ledgerList = FileManager.readLedger();
        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"YEAR TO DATE REPORTS");
        System.out.println("=".repeat(118));
        System.out.println("REPORT PERIOD: "+startOfYear+" | "+today+"      Year/Month/Day");
        System.out.println("-".repeat(118));
        System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("-".repeat(118));
        List<Ledger> matchingLedgerList = new ArrayList<>();
        for (int i = ledgerList.size() - 1; i >= 0; i--) {
            Ledger ledger = ledgerList.get(i);
            LocalDate transactionDate = ledger.getDate();
            if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(today)){
                matchingLedgerList.add(ledger);
            }
        }
        int counting = 0;
        boolean transactionFound = false;
        if(!transactionFound) {
            for (Ledger ledger : matchingLedgerList) {
                transactionFound = true;
                counting++;
                if (counting <= 50) {
                    System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
                }
            }
            System.out.println("-".repeat(118));
            System.out.println("Total Transactions Found: "+matchingLedgerList.size());
            System.out.println("-".repeat(118));
        }
        if(!transactionFound){
            System.out.println("No Transaction Found.");
            System.out.println("-".repeat(118));
        }
        if(counting > 50) {
            System.out.println("You can only view the latest 50 transactions.");
            System.out.println("Please check custom search for more specific transaction.");
            System.out.println("-".repeat(118));
        }
    }
    public static void previousYear(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.minusYears(1).withDayOfYear(1);
        LocalDate endOfYear = today.minusDays(1).withDayOfYear(1);
        List<Ledger> ledgerList = FileManager.readLedger();
        List<Ledger> matchingLedgerList = new ArrayList<>();

        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"PREVIOUS YEAR REPORTS");
        System.out.println("=".repeat(118));
        System.out.println("REPORT PERIOD: "+startOfYear+" | "+endOfYear+"      Year/Month/Day");
        System.out.println("-".repeat(118));
        System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("-".repeat(118));
        for (int i = ledgerList.size() - 1; i >= 0; i--) {
            Ledger ledger = ledgerList.get(i);
            LocalDate transactionDate = ledger.getDate();
            if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(endOfYear)){
                matchingLedgerList.add(ledger);
            }
        }
        boolean transactionFound = false;
        int counting = 0;
        if(!transactionFound) {
            for (Ledger ledger : matchingLedgerList) {
                transactionFound = true;
                counting++;
                if (counting <= 50) {
                    System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
                }
            }
            System.out.println("-".repeat(118));
            System.out.println("Total Transactions Found: "+matchingLedgerList.size());
            System.out.println("-".repeat(118));
        }
        if(!transactionFound){
            System.out.println("No Transaction Found.");
            System.out.println("-".repeat(118));
        }
        if(counting > 50) {
            System.out.println("You can only view the latest 50 transactions.");
            System.out.println("Please check custom search for more specific transaction.");
            System.out.println("-".repeat(118));
        }
    }
    public static void searchByVendor(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        List<Ledger> ledgerList = FileManager.readLedger();
        List<Ledger> matchingLedgerList = new ArrayList<>();
        System.out.println("=".repeat(118));
        System.out.println(" ".repeat(50)+"VENDOR BY SEARCH");
        System.out.println("=".repeat(118));
        System.out.print("Enter the name of the vendor or a hint: ");
        String vendorMatch = scanner.nextLine().toLowerCase().trim();
        System.out.println("-".repeat(118));
        if(vendorMatch.isEmpty()){
            System.out.println("Search cannot be empty.");
            System.out.println("Please enter a vendor name.");
        }else{
            for (int i = ledgerList.size() - 1; i >= 0; i--) {
                Ledger ledger = ledgerList.get(i);
                if (ledger.getVendor().toLowerCase().contains(vendorMatch)){
                    matchingLedgerList.add(ledger);
                }
            }
        }
        System.out.println("SEARCHING BY WORD "+vendorMatch+".");
        System.out.println("-".repeat(118));
        if(matchingLedgerList.isEmpty()){
            System.out.println("No transactions found for: " + vendorMatch);
        }else{
            System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
            System.out.println("-".repeat(118));
            int counting = 0;
            for(Ledger ledger : matchingLedgerList){
                counting++;
                if(counting <=50) {
                    System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
                }
            }
            System.out.println("-".repeat(118));
            System.out.println("Total Transactions Found: "+matchingLedgerList.size());
            System.out.println("-".repeat(118));
            if(counting > 50) {
                System.out.println("You can only view the latest 50 transactions.");
                System.out.println("Please check custom search for more specific transaction.");
                System.out.println("-".repeat(118));
            }
        }
    }
    public static void customSearch(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        List<Ledger> ledgerList = FileManager.readLedger();

        System.out.println("====  CUSTOM SEARCH ====");
        System.out.println("Welcome to Custom Search!");

        List<Ledger> startDateList = new ArrayList<>();
        boolean pass = true;

        do{
            System.out.print("Enter the Start Date(MM/dd/yyyy): ");
            String startDateInput = scanner.nextLine();
            if(startDateInput.isEmpty()){
                pass = false;
                startDateList = ledgerList;
            }else {
                try {
                    LocalDate startDate = LocalDate.parse(startDateInput, dateFormatter);
                    for (int i = 0; i < ledgerList.size(); i++) {
                        Ledger ledger = ledgerList.get(i);
                        if (!ledger.getDate().isBefore(startDate)) {
                            startDateList.add(ledger);
                        }
                    }
                    pass = false;
                } catch (DateTimeParseException ex) {
                    System.out.println("Invalid input for the date. Try again!");
                    System.out.println("Make sure you have a correct year pattern.");
                }
            }

        }while(pass);
        pass = true;
        List<Ledger> endDateList = new ArrayList<>();
        do {
            System.out.print("Enter the End Date(MM/dd/yyyy): ");
            String endDateInput = scanner.nextLine().trim();
            if (endDateInput.isEmpty()) {
                pass = false;
                endDateList = startDateList;
            } else {
                try {
                    LocalDate endDate = LocalDate.parse(endDateInput, dateFormatter);
                    for(int i = 0; i < startDateList.size(); i++) {
                        Ledger ledger = startDateList.get(i);
                        if (!ledger.getDate().isAfter(endDate)) {
                            endDateList.add(ledger);

                        }
                    }
                    pass = false;
                }catch(DateTimeParseException ex){
                    System.out.println("Invalid input for the date. Try again!");
                    System.out.println("Make sure you have a correct year pattern.");
                }
            }
        }while (pass);

        System.out.print("Enter the name of the vendor: ");
        String vendorMatchInput = scanner.nextLine().toLowerCase().trim();
        List<Ledger> vendorList = new ArrayList<>();
        if(vendorMatchInput.isEmpty()){
            vendorList = endDateList;
        }else{
            for (int i = 0; i < endDateList.size(); i++) {
                Ledger ledger = endDateList.get(i);
                if (ledger.getVendor().toLowerCase().contains(vendorMatchInput)){
                    vendorList.add(ledger);
                }
            }
        }

        System.out.println("What transaction type do you want to include?");
        System.out.println("[P] Purchase  |  [D] Deposit  |  [B] Both");
        System.out.print("Choose an option:");
        String amountInput = scanner.nextLine().toLowerCase().trim();
        List<Ledger> amountList = new ArrayList<>();
        switch (amountInput){
            case "p":
                if(amountInput.isEmpty()){
                    amountList = vendorList;
                }else{
                    for(int i = 0; i < vendorList.size(); i++){
                        Ledger ledger = vendorList.get(i);
                        if (ledger.getAmount() < 0){
                            amountList.add(ledger);
                        }
                    }
                }
                break;

            case "d":
                if(amountInput.isEmpty()){
                    amountList = vendorList;
                }else{
                    for(int i =0; i < vendorList.size(); i++){
                        Ledger ledger = vendorList.get(i);
                        if (ledger.getAmount() > 0){
                            amountList.add(ledger);
                        }
                    }
                }
                break;

            case "b":
                amountList = vendorList;
                /*
                if(vendorMatchInput.isEmpty()){
                    amoutList = vendorList;
                }else{
                    for(int i = ledgerList.size()-1;i >= 0; i--){
                        Ledger ledger = vendorList.get(i);
                        if (ledger.getAmount() == amountInput){
                            amoutList.add(ledger);
                        }
                    }
                }

                 */
                break;
            default:
                System.out.println("Invalid option. Try again!");
        }

        boolean correct = true;
        List<Ledger> minAmountList = new ArrayList<>();
        double minAmount = 0;
        String minInput = "";
        do {
            System.out.print("Enter the min amount: ");
            minInput = scanner.nextLine().trim();
            if(minInput.isEmpty()){
                correct = false;
                minAmountList = amountList;
            }else {
                try {
                    minAmount = Double.parseDouble(minInput);
                    for (int i = 0; i < amountList.size(); i++) {
                        Ledger ledger = amountList.get(i);
                        if (Math.abs(ledger.getAmount()) >= Math.abs(minAmount)) {
                            minAmountList.add(ledger);

                        }
                    }
                    correct = false;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid Input. Try again!");
                }
            }
        }while(correct);

        correct = true;
        List<Ledger> maxAmountList = new ArrayList<>();
        double maxAmount = 0;
        do {
            System.out.print("Enter the max amount: ");
            String maxInput = scanner.nextLine().trim();

            if (maxInput.isEmpty()) {
                correct = false;
                maxAmountList = minAmountList;
            } else {
                try {
                    maxAmount = Double.parseDouble(maxInput);
                    if(!minInput.isEmpty() && maxAmount < minAmount) {
                        System.out.println("Maximum amount cannot be smaller than minimum amount. Try again!");
                    }else{
                        for(int i = 0; i < minAmountList.size(); i++) {
                            Ledger ledger = minAmountList.get(i);
                            if (Math.abs(ledger.getAmount()) <= Math.abs(maxAmount)) {
                                maxAmountList.add(ledger);
                            }
                        }
                        correct = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid Input. Try again!");
                }
            }
        }while(correct);

        if(maxAmountList.isEmpty()){
            System.out.println("No, transaction found based on given details.");
        }else{
            System.out.println("-".repeat(118));
            System.out.printf("%-12s %-14s %-35s %-41s %12s%n","DATE","TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
            System.out.println("-".repeat(118));
            for(int i = maxAmountList.size()-1; i > 0; i--){
                Ledger ledger = maxAmountList.get(i);
                System.out.printf("%-12s %-14s %-35s %-40s %13.2f%n", ledger.getDate().format(dateFormatter), ledger.getTime().format(timeFormatter), ledger.getDescription(), ledger.getVendor(), ledger.getAmount());
            }

        }
        System.out.println("=".repeat(118));
    }
}