package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="username")
	WebElement un;
	
	@FindBy(id="password")
	WebElement pw;
	
	@FindBy(id="Login")
	WebElement ln;
	
	@FindBy(id="rememberUn")
	WebElement rm;
	
	@FindBy(id="idcard-identity")
	WebElement iid;
	
	@FindBy(id="userNavLabel")
	WebElement ddb;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement lout;

	public void enterValidUserName(String email) {
		un.sendKeys(email);
	}

	public void enterValidPassword(String pwd) {
			pw.sendKeys(pwd);
	}
	
	public void clearPassword() {
		pw.clear();
	}
		 
	public void clickLogin() {
		ln.click();
			
	}
	public void enterInValidUserName() {
			un.sendKeys("@123");
			
	}
	public void clickRemamberMe() {
			rm.click();
			
	}
	public void enterInValidPassword() {
			pw.sendKeys("abc");
			
	}
	public void clickDropDownButten() {
			ddb.click();
	}	
	public void clickLogOut() {
			lout.click();
		
}
}
