package com.selenium.framework.Test.modules;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.framework.Test.TestBase;

//this test is giving error while running test from Maven as Apache POI library can not find the XSSFWorkbook while giving the dependency form 
//pom.xml and when i attached the library manually from build path and run manually as testng test it runs fine
//Ask support for further help regarding why it is giving the error...
// the below dependency need to add at pom.xml to resolve this issue together with apache poi......
/*
 <dependency>
    		<groupId>org.apache.poi</groupId>
    		<artifactId>poi-ooxml</artifactId>
    		<version>3.17-beta1</version>
		</dependency>
 */


public class Module1 extends TestBase{
	
	@BeforeMethod
	public void setUp() throws Throwable{
		initialize();	  	
	}
	
	@Test(dataProvider="getData")
	public void logIn(String username, String password) throws Exception {		
			
			home.login(username, password);
			}
	
		
		@DataProvider
		public String[][] getData() throws IOException{
		return com.selenium.framework.utility.Excel.getDataFromExcel("C:\\Users\\adraj\\Desktop", "MyExcel.xlsx", "Sheet1");
		}
		
		@AfterMethod		
		public void closeBrowser(){		
			
			closeDriver();
		}
}
