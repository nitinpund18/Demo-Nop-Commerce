package com.nopc.dashboard;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nopc.util.Utility;

public class DashBoard 
{
	@FindBy (xpath="(//img[@alt='logo.png'])[2]") private WebElement logo;	
	
	public DashBoard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void logoValidation(WebDriver  driver) throws IOException
	{
		boolean expLogoResult = Utility.execlBooleanData("Sheet1", 2, 5);
		boolean actLogoResult = logo.isDisplayed();
		Assert.assertEquals(expLogoResult, actLogoResult);
		Utility.screenshot(driver);
	}
}
