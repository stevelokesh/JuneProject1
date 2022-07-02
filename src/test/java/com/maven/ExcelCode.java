package com.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCode extends BaseClass {

	public static void writeProp() throws IOException {

		FileWriter write = new FileWriter("C:\\Users\\User\\eclipse-workspace\\SampleProject\\Config.Properties");
		Properties prop = new Properties();
		prop.setProperty("app", "Aiite");
		prop.setProperty("pass", "1234");
		prop.store(write, "First File");
	}

	
	public static void main(String[] args) throws IOException, InterruptedException {

		writeProp();

		BaseClass bc = new BaseClass();

		BaseClass.browserOpen("chrome");
		BaseClass.loadUrl("https://adactinhotelapp.com/");
		BaseClass.windowMaximize();
		File f = new File("C:\\Users\\User\\Documents\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int physicalNumberOfRows = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sh.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				System.out.println(cell);
				int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
				for (int n = 0; n <= rowCount; n++) {
					cell = sh.getRow(n).getCell(n);
					findElementById("username").sendKeys(cell.getStringCellValue());
					cell = sh.getRow(0).getCell(1);
					findElementById("password").sendKeys(cell.getStringCellValue());
					System.out.println(cell);
				}

				bc.login();
				bc.location("Paris");
				bc.hotel(4);
				bc.room("Double");
				bc.noOfRooms(2);
				bc.checkIn("08/06/2022");
				bc.checkOut("12/06/2022");
				bc.adultsPerRoom(1);
				bc.childrensPerRoom(1);
				bc.search();
				bc.accept();
				bc.Booking();

				cell = sh.getRow(0).getCell(2);
				findElementById("first_name").sendKeys(cell.getStringCellValue());
				System.out.println(cell);
				cell = sh.getRow(0).getCell(3);
				findElementById("last_name").sendKeys(cell.getStringCellValue());
				System.out.println(cell);
				cell = sh.getRow(0).getCell(4);
				findElementById("address").sendKeys(cell.getStringCellValue());
				System.out.println(cell);

				bc.creditCardNumber("5467890765434568");
				bc.cardType(2);
				bc.ExpiryMonth(7);
				bc.ExpiryYear(12);
				bc.cvvNumber("635");
				bc.bookNow();
				Thread.sleep(5000);
				bc.orderNumber();
				driver.close();

			}

		}
	}
}
