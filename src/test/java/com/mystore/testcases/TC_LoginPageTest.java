package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.Youtube;

public class TC_LoginPageTest extends BaseClass {

	@Test(enabled = true)
	public void Login()
	{
		indexPage pg = new indexPage(driver);
		pg.enterUsername(username);
		logger.info("Entered Username");
		pg.enterPassword(password);
		logger.info("Entered Password");
		pg.clickOnLoginButton();
		logger.info("Clicked on Login Button");
	}
	
	@Parameters({"SongName"})
	@Test(enabled = true)
	public void Youtube(String SongName) throws InterruptedException, IOException
	{
		// open url
		driver.get(utubeURL);
		logger.info("YouTube url opened");
		Thread.sleep(10000);
		
		Youtube yt = new Youtube(driver);
		yt.enterInSearchBar(SongName);
		logger.info("Entered songname");
		yt.clickOnSearchButton();
		logger.info("Clicked on search button");
		yt.clickOnSong();
		logger.info("clicked on song");
		Thread.sleep(10000);
		
		String title = driver.getTitle();
		String expectedTitle = "शिव शिव शंभो महादेव शंभो... shiv shiv Shambhu Mahadev Shambhu... - YouTube";
		
		if(title.equals(expectedTitle))
		{
			logger.info("Youtube method passed.");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Youtube method failed.");
			captureScreenshot(driver, "Youtube");
			Assert.assertTrue(false);
		}
	}
}
