package com.nopc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	//execl read, write, screenshot, properties file
	static String excelFile;
	static FileInputStream file;
	static Workbook wbf;
	public static String excelStringData(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		excelFile=System.getProperty("user.dir")+"\\TestData\\File2.xlsx";
		file = new FileInputStream(excelFile);
		wbf = WorkbookFactory.create(file);
		String stringData = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getStringCellValue();
		return stringData;
	}
	public static boolean execlBooleanData(String sheetName, int rowNumber, int cellNumber)
	{
		boolean booleanData = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getBooleanCellValue();
		return booleanData;
	}
	public static double execlNumericData(String sheetName, int rowNumber, int cellNumber)
	{
		double numericData = wbf.getSheet(sheetName).getRow(rowNumber-1).getCell(cellNumber-1).getNumericCellValue();
		return numericData;
	}
	public static void screenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot t = (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		String timestamp = d.toString().replace(":", "_").replace(" ", "_");
		System.out.println(timestamp);
		File desti = new File(System.getProperty("user.dir")+"\\Screenshot\\"+timestamp+".jpg");
		FileHandler.copy(source, desti);
	}
}
