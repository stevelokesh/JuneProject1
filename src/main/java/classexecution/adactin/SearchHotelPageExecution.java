package classexecution.adactin;

import org.junit.Test;

import pagefactory.adactin.SearchHotelPage;

public class SearchHotelPageExecution extends SearchHotelPage {

	@Test
	public void adactinSHP() {
		SearchHotelPage sHotel = new SearchHotelPage();
		selectVText(sHotel.getLocation(), "London");
		selectIndex(sHotel.getHotels(), 3);
		selectIndex(sHotel.getRoomType(), 2);
		selectValue(sHotel.getNoOfRooms(), "4");
		clearnsendKey(sHotel.getCheckinDate(), "10/05/2022");
		clearnsendKey(sHotel.getCheckOutDate(), "12/05/2022");
		selectValue(sHotel.getAdultRoom(), "2");
		selectValue(sHotel.getChildRoom(), "3");
		click(sHotel.getSearchBtn());
	}

}