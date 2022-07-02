package classexecution.adactin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import pagefactory.adactin.BookingPage;

public class BookingPageExecution extends BookingPage {

	@Test
	public void adactinBPE() throws IOException {
		BookingPage book = new BookingPage();
		File file = new File("C:\\Users\\User\\Documents\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		wb.close();
		clearnsendKey(book.getfName(), value);
		String ln = book.excelRead("Sheet1", 1, 1);
		clearnsendKey(book.getlName(), ln);
		String address = book.excelRead("Sheet1", 2, 1);
		clearnsendKey(book.getAddress(), address);
		String cardNo = book.excelRead("Sheet1", 3, 1);
		clearnsendKey(book.getCardNo(), cardNo);
		selectIndex(book.getCardType(), 2);

		selectValue(book.getCardExpMonth(), "9");
		selectVText(book.getCardExpYear(), "2022");
		String cCVNo = book.excelRead("Sheet1", 4, 1);
		clearnsendKey(book.getcCVNo(), cCVNo);
		click(book.getBook());
	}
}
