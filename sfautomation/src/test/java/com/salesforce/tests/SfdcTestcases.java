package com.salesforce.tests;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SfdcTestcases {
	WebDriver driver;
	LoginPage lp;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
		driver.get("https://login.salesforce.com/");

	}

	@Test
	public void loginFail() throws InterruptedException {
		// Step1 :open webpage and login fail
		Thread.sleep(100);
		lp.enterValidUserName("oct2022@janaki.com");
		lp.clearPassword();
		lp.clickLogin();

	}

	@Test
	public void loginSuccess() throws InterruptedException {
		lp.enterValidUserName("oct2022@janaki.com");
		lp.enterValidPassword("Janakimannari123");
		lp.clickLogin();
	}

	@Test
	public void remamberMe() throws InterruptedException {
		lp.enterValidUserName("oct2022@janaki.com");
		lp.enterValidPassword("Janakimannari123");
		lp.clickRemamberMe();
		lp.clickLogin();
		lp.clickDropDownButten();
		lp.clickLogOut();
	}

	@Test
	public void forgotpassword() throws InterruptedException {

		WebElement fpassword = driver.findElement(By.id("forgot_password_link"));
		fpassword.click();
		WebElement usname = driver.findElement(By.id("un"));
		usname.sendKeys("oct2022@janaki.com");

		WebElement continu = driver.findElement(By.id("continue"));
		continu.click();
		WebElement emsg = driver.findElement(By.xpath("//p[@class='senttext mb12']"));
		String str = emsg.getText();

		assertNotNull(str);

	}
	
	

	@Test
	public void forgotpasswordB() throws InterruptedException {
		// Step4B :test the remember username and chek
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		WebElement fusname = driver.findElement(By.id("username"));
		fusname.sendKeys("123");
		WebElement fpassword = driver.findElement(By.id("password"));
		fpassword.sendKeys("22131");
		WebElement log = driver.findElement(By.id("Login"));
		log.click();
		WebElement err = driver.findElement(By.id("error"));
		String st = err.getText();
		assertNotNull(st);

	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
