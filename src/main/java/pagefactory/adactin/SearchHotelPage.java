package pagefactory.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends LoginPage {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='location']")
	private WebElement location;
	@FindBy(xpath = "//select[@id='hotels']")
	private WebElement hotels;
	@FindBy(xpath = "//select[@id='room_type']")
	private WebElement roomType;
	@FindBy(xpath = "//select[@id='room_nos']")
	private WebElement noOfRooms;
	@FindBy(xpath = "//select[@id='adult_room']")
	private WebElement adultRoom;
	@FindBy(xpath = "//select[@id='child_room']")
	private WebElement childRoom;
	@FindBy(xpath = "//input[@id='datepick_in']")
	private WebElement checkinDate;
	@FindBy(xpath = "//input[@id='datepick_out']")
	private WebElement checkOutDate;
	@FindBy(id = "Submit")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCheckinDate() {
		return checkinDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {

		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getAdultRoom() {
		return adultRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}
}
