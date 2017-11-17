package test;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.banking.LogIn;


public class LogInTest{
	
	@BeforeTest
	public void initialize(){
		
		LogIn.init();
			
	}
	
	@Test
	public void testLogin(){
		LogIn.logIn("mngr105719", "zYregep");	
	    //assert.assertEquals(LogIn.title, "Guru99 Bank Manager HomePage", "testLogIn Pass..........");	
	}
	
	
}