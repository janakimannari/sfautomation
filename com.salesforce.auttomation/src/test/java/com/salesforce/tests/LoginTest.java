package com.salesforce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;		
	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
	}
	
	@Test
	public void loginFail() throws InterruptedException {
		// Step1 :open webpage and login fail		
		Thread.sleep(2000);
		WebElement uName = driver.findElement(By.id("username"));
		uName.sendKeys("oct2022@janaki.com");

		WebElement pword = driver.findElement(By.id("password"));
		pword.clear();
		driver.findElement(By.id("Login")).click();		
	}
	
	@Test
	public void loginSuccess() throws InterruptedException {
		
		// Step2 : lohin to SFDC
				
		WebElement uName = driver.findElement(By.id("username"));
		uName.sendKeys("oct2022@janaki.com");

		WebElement pword = driver.findElement(By.id("password"));
		pword.sendKeys("Janakimannari123");
		
		driver.findElement(By.id("Login")).click();
	}
	@Test
	public void usernamecheck() throws InterruptedException {
		// Step3 :test the remember username and chek
	
		WebElement uName = driver.findElement(By.id("username"));
		uName.sendKeys("oct2022@janaki.com");

		WebElement pword = driver.findElement(By.id("password"));
		pword.sendKeys("Janakimannari123");

		WebElement rname = driver.findElement(By.id("rememberUn"));
		rname.click();
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("userNavLabel")).click();

		Thread.sleep(2000);

		WebElement lout = driver.findElement(By.xpath("//a[text()='Logout']"));
		lout.click();
		
		Thread.sleep(2000);
		
		WebElement user = driver.findElement(By.id("idcard-identity"));
		
		String userName = user.getText();
		Assert.assertEquals(userName, "oct2022@janaki.com");
		

	}
	@Test
	public void forgotpassword() throws InterruptedException {
		// Step4 :test the remember username and chek

		
		WebElement fpassword = driver.findElement(By.id("forgot_password_link"));
		 fpassword.click();
		 WebElement usname=driver.findElement(By.id("un"));
		 usname.sendKeys("oct2022@janaki.com");
		 
		 WebElement continu=driver.findElement(By.id("continue"));
		 continu.click();
		 WebElement emsg= driver.findElement(By.xpath("//p[@class='senttext mb12']"));
		String str= emsg.getText();
		Assert.assertEquals("We’ve sent you an email with a link to finish resetting your password.", str);
		
	}
		
	@Test
	public void forgotpasswordB () throws InterruptedException {
		// Step4B :test the remember username and chek
		
		WebElement fusname =driver.findElement(By.id( "username"));
		 fusname.sendKeys("123");
		 WebElement fpassword =driver.findElement(By.id( "password"));
		 fpassword.sendKeys("22131");
		 WebElement log =driver.findElement(By.id( "Login"));
		log.click();
		WebElement err =driver.findElement(By.id( "error"));
		String st=err.getText();
		Assert.assertEquals(st, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
			
		
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
		
	}
		
		
	}

