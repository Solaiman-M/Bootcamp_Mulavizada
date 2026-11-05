package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<Ledger> readLedger(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        List<Ledger> ledgerList = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("src/main/resources/transaction.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String itemRow;

            bufferedReader.readLine();
            while((itemRow = bufferedReader.readLine()) != null){
                String [] rowSplitter = itemRow.split("\\|");

                LocalDate date = LocalDate.parse(rowSplitter[0],dateFormatter);
                LocalTime time = LocalTime.parse(rowSplitter[1],timeFormatter);
                String description = rowSplitter[2];
                String vendor = rowSplitter[3];
                double amount = Double.parseDouble(rowSplitter[4]);

                Ledger ledger = new Ledger(date,time, description, vendor, amount);
                ledgerList.add(ledger);
            }

        }
        catch(IOException ex){
            //System.out.println("Could not read the file. Check the file. try again.");
            ex.printStackTrace();
        }
        catch(Exception ex){
            //System.out.println("Could not read data from the file. try again.");
            ex.printStackTrace();
        }

        return ledgerList;
    }

    public static void writeLedger(Ledger ledger){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/transaction.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = String.format("%s|%s|%s|%s|%.2f",ledger.getDate().format(dateFormatter),ledger.getTime().format(timeFormatter),ledger.getDescription(),ledger.getVendor(),ledger.getAmount());

            bufferedWriter.newLine();
            bufferedWriter.write(line);

            System.out.println("Transaction added.");
            bufferedWriter.close();
        }
        catch(IOException ex){
            System.out.println("Could not read the file. ");
        }
        catch(Exception ex){
            System.out.println("Error when handling the data.");
        }

    }
}
