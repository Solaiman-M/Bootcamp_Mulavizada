package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManger {
    public static List<Product> readProduct(){
        List<Product> productList = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String itemRow;
            bufferedReader.readLine();
            while((itemRow = bufferedReader.readLine()) != null){
                String [] rowSplitter = itemRow.split("\\|");

                int id = Integer.parseInt(rowSplitter[0]);
                String sKU = rowSplitter[1];
                String productName = rowSplitter[2];
                double price = Double.parseDouble(rowSplitter[3]);
                String department = rowSplitter[4];

                Product product = new Product(id, sKU, productName,price,department);
                productList.add(product);
            }

        }
        catch(IOException ex){
            System.out.println("Could not read the file. Check the file. try again.");
            //ex.printStackTrace();
        }
        catch(Exception ex){
            System.out.println("Could not read data from the file. try again.");
            //ex.printStackTrace();
        }

        return productList;
    }

    public static void writeInventory(Product product){

        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = String.format("%d|%s|%s|%.2f|%s",product.getId(),product.getsKU(),product.getProductName(),product.getPrice(), product.getDepartment());

            bufferedWriter.newLine();
            bufferedWriter.write(line);

            System.out.println("Item added to Inventory.");
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