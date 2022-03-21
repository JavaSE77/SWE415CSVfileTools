package edu.cs.ship.rs0699.csvedits;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String fileName = "file.csv";
    static ArrayList<String> messyArray = new ArrayList<String>();
    static ArrayList<String> csvFile = new ArrayList<String>();
    
    public void readFile() {
      
      try {  
        //Open the config file
        FileInputStream inputStream=new FileInputStream(fileName);       
        Scanner scanner=new Scanner(inputStream);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
      
        scanner.close(); 
      }  
        catch(IOException e) {  
            e.printStackTrace();  
            
            System.out.println("There was an error reading the CSV file. Please correct the file before continuing");
    } 
    
  }
    
    
    public static void getBooleanArray() {
      
      try {  
        //Open the config file
        FileInputStream inputStream=new FileInputStream(fileName);       
        Scanner scanner=new Scanner(inputStream);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] cells = line.split(",");
            StringBuilder sb = new StringBuilder();
            
            if(Boolean.parseBoolean(cells[4]) == true) {
              sb.append("RED;");
            }
            if(Boolean.parseBoolean(cells[5]) == true) {
              sb.append("ORANGE;");
            }
            if(Boolean.parseBoolean(cells[6]) == true) {
              sb.append("YELLOW;");
            }
            if(Boolean.parseBoolean(cells[7]) == true) {
              sb.append("GREEN;");
            }
            if(Boolean.parseBoolean(cells[8]) == true) {
              sb.append("BLUE;");
            }
            if(Boolean.parseBoolean(cells[9]) == true) {
              sb.append("INDIGO;");
            }
            if(Boolean.parseBoolean(cells[10]) == true) {
              sb.append("VIOLET;");
            }
            csvFile.add(line);
            messyArray.add(sb.toString());
            
        }
      
        scanner.close(); 
      }  
        catch(IOException e) {  
            e.printStackTrace();  
            
            System.out.println("There was an error reading the CSV file. Please correct the file before continuing");
    } 
    
  }


    public String getLine(int lineNumber) {
      String line = null;
      
      try {  
        //Open the config file
        FileInputStream inputStream=new FileInputStream(fileName);       
        Scanner scanner=new Scanner(inputStream);
        int i = 0;
        while(scanner.hasNextLine()) {
          if(i == lineNumber) {
            line = scanner.nextLine();
            System.out.println(line);
            break;
          }
            i++;
        }
      
        scanner.close(); 
      }  
        catch(IOException e) {  
            e.printStackTrace();  
            
            System.out.println("There was an error reading the CSV file. Please correct the file before continuing");
    } 
    return line;
  }
    
    
    public static void appendLineNoErrorChecking(String line) {
      try {
      BufferedWriter outputStream = new BufferedWriter(new FileWriter(fileName, true));

        outputStream.append("\n" + line);

        outputStream.close();
      } catch (IOException e) {
        e.printStackTrace();  
        
        System.out.println("There was an error writing to the CSV file. Please correct the file before continuing");
      }

    }

    public static void fixFile() {
      for(int i = 0; i < csvFile.size(); i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(csvFile.get(i));
        sb.append(",");
        sb.append(messyArray.get(i));
        appendLineNoErrorChecking(sb.toString());
      }
      
    }
    
    public static void main(String[] args) {
      getBooleanArray();
      fixFile();
    }
    
  }
  

