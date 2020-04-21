package com.eNetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eNetBanking.pageObjects.TC_LoginPage;

public class TC_LoginPage_01 extends Bassclass
{

	@Test
	public void login() throws IOException
	{
		
		Logger.info("URL is launched");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TC_LoginPage lp = new TC_LoginPage(driver);
		lp.setUsername(username);
		Logger.info("User Name is Entered");

		lp.setPassword(password);
		Logger.info("Password is Entered");

		lp.login();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			System.out.println("The Home Page Title is"+ driver.getTitle());
			lp.logout();
			Logger.info("clicked is logout");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		else
		{
			captureScreen(driver,"login");
			Assert.assertTrue(false);
			
		}
		
		
	}

}
