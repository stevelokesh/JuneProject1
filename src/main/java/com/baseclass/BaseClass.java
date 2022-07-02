package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
		public static WebDriver driver;
		public void loadDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		public void portal(String url) {
		driver.get(url);
		}
		public void clearnsendKey(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		}
		public void type(WebElement element, String txt) {
		element.sendKeys();
		}
		public void click(WebElement element) {
		element.click();
		}
		public void selectIndex (WebElement drop,int key) {
		Select sc = new Select(drop);
		sc.selectByIndex(key);
		}
		public void selectVText (WebElement drop,String key) {
		Select sc = new Select(drop);
		sc.selectByVisibleText(key);
		}
		public void selectValue (WebElement drop,String key) {
		Select sc = new Select(drop);

		sc.selectByValue(key);
		}
		public void close() {
		driver.close();
		}
		public String propfile(String key) throws IOException {

		File file = new File("C:\\Users\\User\\eclipse-workspace\\SampleProject\\Config.Properties");

		FileInputStream fis = new FileInputStream(file);
		Properties pop = new Properties();
		pop.load(fis);
		String property = pop.getProperty(key);
		return property;
		}
		public String excelRead(String txt,int rkey,int ckey) throws IOException{
		File file = new File("C:\\Users\\User\\Documents\\TestData1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(txt);
		Row row = sheet.getRow(rkey);
		Cell cell = row.getCell(ckey);
		String value = cell.getStringCellValue();
		wb.close();
		return value;
		}
		public void submit(WebElement submit) {
		submit.submit();
		}
		
	}
	

