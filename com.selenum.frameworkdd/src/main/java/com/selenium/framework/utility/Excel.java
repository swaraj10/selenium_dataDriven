package com.selenium.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {		
	
	
	public static String[][] getDataFromExcel(String filePath, String fileName, String sheetName) throws IOException{
	
		/*
		 let us pass the below variables as argument in the above method instead hard coding here, we will pass
		 the value of the String variable when we called this method
		 
		String filePath= "C:\\Users\\adraj\\Desktop";
		String fileName= "MyExcel.xlsx";
		String sheetName= "Sheet1";
		*/
		   //String[][] dataTable=null;
		
		//Create an object of File to open the excel file
		File fileSrc = new File(filePath+ "\\"+ fileName);
		
		//create an object of FileInputStream to read the excel file
		FileInputStream inputStream = new FileInputStream(fileSrc);		
		
		//Find the file extension of the excel file		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		//check the condition for the file if the file is xlsx or xls
		
		Workbook myExcelWorkbook = null;	
		
		if (fileExtensionName.equals(".xlsx")){
			myExcelWorkbook = new XSSFWorkbook(inputStream);			
		}
		
		else if(fileExtensionName.equals(".xls")){
			myExcelWorkbook = new HSSFWorkbook(inputStream);
		}	
		
//read sheet inside the workbook by its name:
//you can use getSheetAt(0) for the first sheet
	   Sheet myExcelSheet = myExcelWorkbook.getSheet(sheetName);
	   
//find the number of rows in excel file
//Find number of rows in excel file

	    int rowCount = myExcelSheet.getLastRowNum()-myExcelSheet.getFirstRowNum();
	    
//This is the alternate method to count the total number of rows in the excel file
	    int totalRows = myExcelSheet.getPhysicalNumberOfRows();
	    
//Count the total number of column in the excel sheet
	    
	    int totalColumns = myExcelSheet.getRow(0).getPhysicalNumberOfCells();
	    

	    System.out.println(" Total number of rows: "+ (rowCount+1));
	    
	    System.out.println("Total number of row from different method is   :"+ totalRows);
	    
	    System.out.println("Total number of column are:  "+ totalColumns);

//Create a loop over all the rows of excel file to read it	and store in an two dimensional string arrays    

/*
 Since we have header username and password for each column and we only need the values of those so we can 
 read from second line when we start i from 1 below	 
 */
	    String[][] dataTable = new String[totalRows][totalColumns];
	    for (int i = 0; i <totalRows; i++) {
	    	Row row = myExcelSheet.getRow(i);
	        for (int j = 0; j <row.getLastCellNum(); j++) {
	        	Cell cell = row.getCell(j);	        	

	        	dataTable[i][j] = cell.getStringCellValue(); //to string method also works here
	        	
	        	System.out.println("The data from excel is-------------====== " +dataTable[i][j] );
	        }	       
	        }    
	   
	    inputStream.close();
	    myExcelWorkbook.close();
	    return dataTable; 	    
	    
	    
/* this code works fine to print the data from excel  and it is from Guru 99
	    for (int i = 0; i < totalRows; i++) {
	 	    Row row = myExcelSheet.getRow(i);
	        //Create a loop to print cell values in a row
              
	        for (int j = 0; j < totalColumn; j++) {
	        	
	        	
	        	System.out.print("total column is "+ row.getLastCellNum()+  "    ----------------    ");

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue());
	            
	        }
	        System.out.println();
	        }	        
	        
	*/    
	    
	    
	    }
	}

