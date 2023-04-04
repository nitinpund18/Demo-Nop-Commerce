package com.nopc.base;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass 
{
	public static WebDriver driver=null;
	public static void browserlaunch() throws InterruptedException, EncryptedDocumentException, IOException
	{
	String key="webdriver.chrome.driver";
	String value=System.getProperty("user.dir")+"C:\\Users\\Shree\\eclipse-workspace\\SeleniumNitin\\driver\\chromedriver.exe";
	String url="https://admin-demo.nopcommerce.com/login";
	System.setProperty(key, value);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	}
}
