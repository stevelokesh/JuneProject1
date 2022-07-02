package classexecution.adactin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import pagefactory.adactin.ConfirmationPage;

public class ConfirmationPageExe extends ConfirmationPage {

	@Test
	public void adactinConfT() throws IOException {
		ConfirmationPage confirm = new ConfirmationPage();
		WebElement order = confirm.getConfirmationT();
		String confirmID = order.getAttribute("name");
		String confirmNo = order.getAttribute("value");
		File file = new File("C:\\Users\\User\\Documents\\TestData1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.createSheet("OrderID");
		Row createRow = sheet.createRow(0);
		Cell createCell = createRow.createCell(0);
		Cell createCell1 = createRow.createCell(1);
		createCell.setCellValue(confirmID);
		createCell1.setCellValue(confirmNo);
		FileOutputStream fo = new FileOutputStream(file);
		wb.write(fo);
		wb.close();
		driver.close();
	}
}
