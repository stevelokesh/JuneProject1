package pagefactory.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class ConfirmationPage extends BaseClass {

	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='order_no']")
	private WebElement confirmationT;

	public WebElement getConfirmationT() {
		return confirmationT;
	}
}
