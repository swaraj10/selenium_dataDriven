package FaceBook;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.framework.Test.TestBase;

public class HomePage extends TestBase {
	
	public HomePage(WebDriver driver, Properties objectrepo){
		this.driver= driver;
		this.objectrepo= objectrepo;
	}
	
	

	public void login(String username, String password) throws Exception{
		clearAndSendKeys(By.id(objectrepo.getProperty("email_text_box_id")), username);
		clearAndSendKeys(By.id(objectrepo.getProperty("password_text_box_id")), password);
		click(By.id(objectrepo.getProperty("click_button_id")));		
		
	}

}
