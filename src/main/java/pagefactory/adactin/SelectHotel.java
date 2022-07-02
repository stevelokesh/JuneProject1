package pagefactory.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends SearchHotelPage {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='radiobutton_0']")
	private WebElement sradio;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueBtn;

	public WebElement getSradio() {
		return sradio;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}
}
