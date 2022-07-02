package execution.adactin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import classexecution.adactin.BookingPageExecution;
import classexecution.adactin.ConfirmationPageExe;
import classexecution.adactin.LoginPageExecution;
import classexecution.adactin.SearchHotelPageExecution;
import classexecution.adactin.SelectHotelExecution;

@RunWith(Suite.class)
@SuiteClasses({ LoginPageExecution.class, SearchHotelPageExecution.class, SelectHotelExecution.class,
		BookingPageExecution.class, ConfirmationPageExe.class })
public class AllClassExecution {
}