package classexecution.adactin;

import java.io.IOException;

import org.junit.Test;

import pagefactory.adactin.LoginPage;

public class LoginPageExecution extends LoginPage {

	@Test
	public void adactinLE() throws IOException {
		loadDriver();
		portal(propfile("url"));
		LoginPage lPage = new LoginPage();
		clearnsendKey(lPage.getUsername(), propfile("username"));
		clearnsendKey(lPage.getPassword(), propfile("password"));
		click(lPage.getLogin());

	}
}
