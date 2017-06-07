package io.github.dauphine.lejema160.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class deleteBook {
	
	public static void main(String[] args) {
		deleteB("CHUNG","Hugo","Le","2015");
	}
	
	private static void deleteB(String last, String first,String title,String year) {
		
			String path=new File("").getAbsolutePath(); 
		    String fileName = path + "/src/main/resources/controller/Book1.csv";
		    File file= new File(fileName);
  
            List<List<String>> lines = new ArrayList<>();
            Scanner inputStream;

            try{
                inputStream = new Scanner(file);

                while(inputStream.hasNextLine()){
                    String line= inputStream.nextLine();
                    
                    String[] values = line.split(",");
                    if (values[0].equals(last) && values[1].equals(first) && values[2].equals(title) && values[3].equals(year)){
                    	continue;
                    }
                    else {lines.add(Arrays.asList(values));}
                    System.out.println(lines);
                }
                
                inputStream.close();
               
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            add(lines);
	}
	private static void add(List<List<String>> lines) {
            FileWriter fw;
			try {
				String path=new File("").getAbsolutePath(); 
			    String fileName = path + "/src/main/resources/controller/Book1.csv";
				fw = new FileWriter(fileName , false);
			
            for(List<String> line: lines) {
            	String li = "";
            	for (String value: line) {
            		if (li != null && !li.trim().isEmpty()){
    					li = li + ","+ value;
    					}
    					else {li = value;}
            	}
            	System.out.println(li);
            	fw.write(li);
        		fw.write("\r\n");
            	
            }
            fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
