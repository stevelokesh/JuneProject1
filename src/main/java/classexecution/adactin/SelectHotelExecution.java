package classexecution.adactin;

import org.junit.Test;

import pagefactory.adactin.SelectHotel;

public class SelectHotelExecution extends SelectHotel {

	@Test
	public void adactinSelect() {
		SelectHotel sHotelE = new SelectHotel();
		click(sHotelE.getSradio());
		click(sHotelE.getContinueBtn());
	}
}
