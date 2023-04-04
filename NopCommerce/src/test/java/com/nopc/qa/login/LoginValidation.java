package com.nopc.qa.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopc.base.Baseclass;
import com.nopc.dashboard.DashBoard;
import com.nopc.login.Loginwebpage;

public class LoginValidation extends Baseclass
{
	Loginwebpage p1;
	DashBoard p2;
	
	@BeforeClass
	public void Browseropening() throws EncryptedDocumentException, InterruptedException, IOException
	{
		browserlaunch();
		p1 = new Loginwebpage(driver);
		p2 = new DashBoard(driver);
	}
	
	@Test (priority=2)
	public void TitleVerify() throws EncryptedDocumentException, IOException 
	{
		String actTitle = driver.getTitle();
		String expTitle = p1.titleValidation();
		Assert.assertEquals(expTitle, actTitle, "Expected and actual texts are different");
	}
	@Test (priority=1)
	public void checkboxVerify() throws EncryptedDocumentException, IOException
	{
		p1.checkBoxValidation();
	}
	@Test (priority=3)
	public void loginVerify() throws EncryptedDocumentException, IOException, InterruptedException
	{
		p1.enterUn();
		Thread.sleep(2000);
		p1.enterPassword();
		Thread.sleep(2000);
		p1.clickSigninBtn();
		Thread.sleep(2000);
	}
	@Test (dependsOnMethods = "loginVerify")		//dashboard
	public void logoVerify() throws IOException
	{
		p2.logoValidation(driver);
	}
	@AfterClass
	public void BrowserClose()
	{
	driver.close();
	}
	}

