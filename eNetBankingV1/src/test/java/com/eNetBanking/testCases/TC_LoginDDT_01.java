package com.eNetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eNetBanking.pageObjects.TC_LoginPage;
import com.eNetBanking.utilities.XLUtils;

public class TC_LoginDDT_01 extends Bassclass
{
	@Test(dataProvider="Logindata")
	public void LoginDDT(String user,String pws) throws Exception
	{
		TC_LoginPage lp = new TC_LoginPage(driver);
		
		lp.setUsername(user);
		Logger.info("The User name is entered");
		lp.setPassword(pws);
		Logger.info("The Password is entered");
		lp.login();
		Logger.info("The login button clicked");
		Thread.sleep(4000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Invalid Login");
			
		}
		else if(isAlertPresent()== false)
		{
			Thread.sleep(1200);
			driver.switchTo().defaultContent();
			lp.logout();
			//Thread.sleep(9000);
			//Logger.info("clicked is logout");
			//driver.switchTo().alert().accept();
			//driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name = "Logindata")
	String [][]getData() throws IOException
	{
		String path = "C:\\Users\\User\\Desktop\\Jenkins\\selenium demo\\eNetBankingV1\\src\\test\\java\\com\\eNetBanking\\testData\\LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(path, "sheet1");
		int colCount = XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][] = new String [rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return logindata;
	}
}
