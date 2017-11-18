package bookAFlight.Expedia;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * Unit test for simple App.
 */
public class AppTest {
	
		public static void main(String[] args){
		
		//go through this video to learn comit in git hub:
	//  https://www.youtube.com/watch?v=BH4OqYHoHC0
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to("https://www.expedia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		
		String title = driver.getTitle();
		
		if (title.equalsIgnoreCase("Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares"))
		{
			System.out.println("Test case pass");
		}
		else {
			System.out.println("Test case fail.................");
		}		
		
		driver.close();	
		
		
		/*
		driver.findElement(By.id("package-origin-hp-package")).clear();
		driver.findElement(By.id("package-origin-hp-package")).sendKeys("San Francisco");
		
		driver.findElement(By.id("package-destination-hp-package")).clear();
		driver.findElement(By.id("package-origin-hp-package")).sendKeys("new york");
	
	//	http://learn-automation.com/handle-calender-in-selenium-webdriver/
		
		driver.findElement(By.id("package-departing-hp-package")).click();
		
		
		List<WebElement> datePickerDD = driver.findElements(By.xpath(".//*[@id='package-departing-wrapper-hp-package']/div/div/div[2]/table/tbody/tr[4]/td[3]/button"));
		
		for(WebElement ele:datePickerDD)
		{
		String date=ele.getText();
		if(date.equalsIgnoreCase("28"))
		{
		ele.click();
		break;
		}
		}
		
		*/
		
		
	
	}
   
}
