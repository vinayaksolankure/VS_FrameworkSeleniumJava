package com.mystore.testcases;

import java.sql.SQLException;

import org.testng.annotations.Test;
import com.mystore.pageobject.indexPage;

public class JDBCTestCase extends BaseClass {

	@Test(enabled = true)
	public void Login() throws SQLException
	{
		indexPage pg = new indexPage(driver);

		jdbcconnection jdbc = new jdbcconnection();

		String usrname = jdbc.username();
		String pass = jdbc.password();

		pg.enterUsername(usrname);
		logger.info("Entered Username");
		pg.enterPassword(pass);
		logger.info("Entered Password");
		pg.clickOnLoginButton();
		logger.info("Clicked on Login Button");
	}
}

