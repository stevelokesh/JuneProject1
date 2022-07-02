package com.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static HSSFWorkbook Wb;

	public static void browserOpen(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\User\\eclipse-workspace\\Testing\\Path\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\User\\eclipse-workspace\\Testing\\Path\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		}

	}

	public static void browserLaunch(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\User\\\\eclipse-workspace\\\\Testing\\\\Path\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void Url(String url) {
		driver.get(url);
	}

	public static WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public void login() {
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

	}

	public void location(String location) {

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='location']"));
		Select options = new Select(dropdown);
		options.selectByVisibleText(location);
	}

	public void hotel(int hotels) {

		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='hotels']"));
		Select options = new Select(dropdown2);
		options.selectByIndex(hotels);
	}

	public void room(String roomType) {

		WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='room_type']"));
		Select options = new Select(dropdown3);
		options.selectByVisibleText(roomType);
	}

	public void noOfRooms(int rooms) {

		WebElement dropdown4 = driver.findElement(By.xpath("//select[@id='room_nos']"));
		Select options = new Select(dropdown4);
		options.selectByIndex(rooms);
	}

	public void checkIn(String date) {
		WebElement inDate = driver.findElement(By.xpath("//input[@id='datepick_in']"));
		inDate.clear();
		inDate.sendKeys(date);
	}

	public void checkOut(String date) {
		WebElement outDate = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		outDate.clear();
		outDate.sendKeys(date);
	}

	public void adultsPerRoom(int count) {

		WebElement dropdown5 = driver.findElement(By.xpath("//select[@id='adult_room']"));
		Select options = new Select(dropdown5);
		options.selectByIndex(count);
	}

	public void childrensPerRoom(int count) {

		WebElement dropdown6 = driver.findElement(By.xpath("//select[@id='child_room']"));
		Select options = new Select(dropdown6);
		options.selectByIndex(count);
	}

	public void search() {
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='Submit']"));
		searchButton.click();
	}

	public void accept() {
		WebElement acceptButton = driver.findElement(By.xpath("//input[@id='radiobutton_0']"));
		acceptButton.click();
	}

	public void Booking() {
		WebElement booking = driver.findElement(By.xpath("//input[@id='continue']"));
		booking.click();
	}

	public void firstName(String firstName) {
		WebElement firstname = driver.findElement(By.xpath("//input[@id='first_name']"));
		firstname.sendKeys(firstName);

	}

	public void LastName(String LastName) {
		WebElement lastname = driver.findElement(By.xpath("//input[@id='last_name']"));
		lastname.sendKeys(LastName);

	}

	public void address(String address) {
		WebElement addressBox = driver.findElement(By.xpath("//textarea[@id='address']"));
		addressBox.sendKeys(address);

	}

	public void creditCardNumber(String CardNumber) {
		WebElement cardNumber = driver.findElement(By.xpath("//input[@id='cc_num']"));
		cardNumber.sendKeys(CardNumber);

	}

	public void cardType(int index) {

		WebElement dropdown7 = driver.findElement(By.xpath("//select[@id='cc_type']"));
		Select options = new Select(dropdown7);
		options.selectByIndex(index);
	}

	public void ExpiryMonth(int month) {

		WebElement dropdown9 = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
		Select options = new Select(dropdown9);
		options.selectByIndex(month);
	}

	public void ExpiryYear(int Year) {

		WebElement dropdown10 = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select options = new Select(dropdown10);
		options.selectByIndex(Year);
	}

	public void cvvNumber(String cvv) {
		WebElement cvvNumberBox = driver.findElement(By.xpath("//input[@id='cc_cvv']"));
		cvvNumberBox.sendKeys(cvv);

	}

	public void bookNow() {
		WebElement bookNow = driver.findElement(By.xpath("(//input[@type='button'])[1]"));
		bookNow.click();

	}

	public void orderNumber() throws IOException, InterruptedException {
		WebElement orderid = driver.findElement(By.xpath("(//input[@type='text'])[16]"));

		Thread.sleep(2000);
		String name = orderid.getAttribute("Name");
		String number = orderid.getAttribute("value");
		System.out.println(name);
		System.out.println(number);
		File f = new File("C:\\Users\\User\\Documents\\TestData.xlsx");

		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet createSheet = wb.createSheet("OrderNumber");
		Row createRow = createSheet.createRow(0);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue(name);
		createCell.setCellValue(number);

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		Thread.sleep(2000);
		wb.write(fos);
		Thread.sleep(5000);
		wb.close();
	}

}
