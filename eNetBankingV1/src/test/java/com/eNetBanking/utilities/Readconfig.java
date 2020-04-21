package com.eNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig
{

	Properties pro;
	public Readconfig()
	{
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		     }
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baserurl");
		return url;
		
	}
	
	public String getUsername()
	{
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pws = pro.getProperty("password");
		return pws;
	}
	
	public String getChromedriver()
	{
		String chDriver = pro.getProperty("chromepath");
		return chDriver;
	}
	
	public String getFirefoxdriver()
	{
		String fdriver = pro.getProperty("firefoxpath");
		return fdriver;
	}
	
}
