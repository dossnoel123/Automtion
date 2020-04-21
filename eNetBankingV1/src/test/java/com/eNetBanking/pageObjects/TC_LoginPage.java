package com.eNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_LoginPage 
{
	WebDriver ldriver;
	
	public TC_LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement btnLogout;	
	/* Action Methods */
	
	public void setUsername(String uname)
	{
		txtUsername.sendKeys(uname);
		
	}
	
	public void setPassword(String upassword)
	{
		txtPassword.sendKeys(upassword);
	}
	
	public void login()
	{
		btnLogin.click();
	}
	public void logout()
	{
		btnLogout.click();
		
	}
}
