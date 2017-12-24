package com.selenium.framework.Test;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import FaceBook.HomePage;


//for first commit........
public class TestBase {	
	

public WebDriver driver;
String configPath = "C:/Selenium_2017/com.selenum.frameworkdd/src/main/java/Property/config.properties"; 
String orPath = "C:/Selenium_2017/com.selenum.frameworkdd/src/main/java/Property/objectrepo.properties";
protected Properties objectrepo;
protected Properties config;
public String browser;

public static Logger logger = Logger.getRootLogger();
//Logger logger = Logger.getLogger("devpinoyLogger");

public HomePage home;




public void initialize() throws Throwable{
	config = loadPropertyFile(configPath);
	objectrepo = loadPropertyFile(orPath);
	browser = config.getProperty("browser");
	
	getDriver(browser); 		
	
	driver.manage().timeouts().implicitlyWait(30l,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
	
	driver.navigate().to(config.getProperty("baseUrl"));
	initAllClasses();	
}
public Properties loadPropertyFile(String filepath) throws Throwable{
	FileInputStream fi = new FileInputStream(filepath);
	Properties p = new Properties();
	p.load(fi);
	return p;	
}


public void getDriver(String browser){
	if (browser.equalsIgnoreCase("firefox")){
	 System.setProperty("webdriver.firefox.marionette", "C:\\Users\\adraj\\Desktop\\Rajaram All docs\\Downloaded Software\\geckodriver.exe");
	 driver = new FirefoxDriver();	 
	}	
	else if (browser.equalsIgnoreCase("ie")){
		//code to get IE driver		
	}	
	else if (browser.equalsIgnoreCase("chromedriver"))
	{	
		//code to get chrome driver
	}
}

//Initialize classes
 public void initAllClasses(){
 home = new HomePage(driver, objectrepo);

}
 
 
//close all open browser
public void closeDriver(){
	driver.quit();
}


//Answer to where are the locators
public WebElement getWebelement(By by){
	
	try{	
		
		//logger.debug works great 		
		logger.debug("Started to find the elements..............oh hu........" + by);
		//logger.info("starting to find element:    " + by);
		return driver.findElement(by);
	}catch (Exception e){
		//Write to log
		logger.error(e);	
	
	System.out.println("Now going to take screenshot" );		
		
	//Calling captureScreenshot method to take screenshot from Utility package 		
	
	return null;
	}
}

//Finding multiple elements
public List<WebElement>  getWebelements(By by){
	
	try{	
		
		//logger.debug works great 		
		logger.debug("Started to find the elements..............oh hu........" + by);
		//logger.info("starting to find element:    " + by);
		return driver.findElements(by);
	}catch (Exception e){
		//Write to log
		logger.error(e);	
	
	System.out.println("Now going to take screenshot" );		
		
	//Calling captureScreenshot method to take screenshot from Utility package 		
	
	return null;
	}
}

public void clearAndSendKeys(By by, String toWrite){
	try{
		logger.debug("Starting to find element by   " + by);
	getWebelement(by).clear();
	getWebelement(by).sendKeys(toWrite);
	
	logger.debug("Successfully wrote to :  "+ by +  "----"+ toWrite);
	}catch (Exception e){
		//write to log
		logger.error(e);
		
	}
}

public void click(By by) throws Exception{
	  //write to log and take screenshot...
	 try {
		getWebelement(by).click();
	} catch (Exception e) {
		//Write to log
		logger.error(e);
		
	}	
  }   
}

