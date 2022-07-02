package pagefactory.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BookingPage extends SelectHotel {

	public BookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement fName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lName;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "cc_num")
	private WebElement cardNo;
	
	@FindBy(id = "cc_type")
	private WebElement cardType;
	
	@FindBy(id = "cc_exp_month")
	private WebElement cardExpMonth;
	
	@FindBy(id = "cc_exp_year")
	private WebElement cardExpYear;
	
	@FindBy(id = "cc_cvv")
	private WebElement cCVNo;
	
	@FindBy(id = "book_now")
	private WebElement book;

	public WebElement getfName() {
		return fName;
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardNo() {
		return cardNo;
	}

	public WebElement getCardType() {
		return cardType;

	}

	public WebElement getCardExpMonth() {
		return cardExpMonth;
	}

	public WebElement getCardExpYear() {
		return cardExpYear;
	}

	public WebElement getcCVNo() {
		return cCVNo;
	}

	public WebElement getBook() {
		return book;
	}
}
