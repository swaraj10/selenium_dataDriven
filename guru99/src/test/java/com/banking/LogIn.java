package com.banking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogIn 

//this is to test the continious integration
//this is my second try
//this is my third try
//This is for new jenkins job
{	
public static String browser = "firefox";
public static String URL ="http://www.demo.guru99.com/V4" ;
public static WebDriver driver;
public static String title;

public static void init(){	
	if (browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
    	driver = new FirefoxDriver();	
	}	
	else if (browser.equalsIgnoreCase("")){   
		
	}	
	else if(browser.equalsIgnoreCase("")){  
		
		
	}
}
	    public static void logIn( String username, String password)
    {     	
	    	//I am not changing anything now here, this is just for the shake of time , i just want to update is...lolz...
	    	
	    	//this is my test commit and you could see the color change difference here...........
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	driver.navigate().to(URL);
    	driver.findElement(By.name("uid")).clear();
    	driver.findElement(By.name("uid")).sendKeys(username);                   //"mngr105719"
    	driver.findElement(By.name("password")).sendKeys(password);                    //("zYregep");
    	driver.findElement(By.name("btnLogin")).click();
    	
    	//
    	//
    	//
    	
    	//...................
    	title = driver.getTitle();
    	
    }
}
