package com.mystore.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.pageobject.indexPage;
import com.mystore.utilities.ReadExcelFile;
import com.mystore.pageobject.Youtube;

public class TC_LoginPageTestDataDrivenTesting extends BaseClass {

	@Test(dataProvider = "LoginDataProvider")
	public void Login(String userName, String passWord)
	{
		indexPage pg = new indexPage(driver);
		for(int i=0; i<2; i++)
		{
			pg.enterUsername(userName);
			logger.info("Entered Username");
			pg.enterPassword(passWord);
			logger.info("Entered Password");
			pg.clickOnLoginButton();
			logger.info("Clicked on Login Button");
			//			driver.switchTo().alert().accept();
			//			logger.info("Accepted alert");
			pg.clickOnMenuButton();
			logger.info("Clicked on menu button");
			pg.clickOnLogOutButton();
			logger.info("Clicked on Logout Button");
			break;
		}
	}

	@Parameters({"SongName"})
	@Test(enabled = true)
	public void Youtube(String SongName) throws InterruptedException, IOException
	{
		// open url
		driver.get(utubeURL);
		logger.info("YouTube url opened");
		//Thread.sleep(10000);

		Youtube yt = new Youtube(driver);
		yt.enterInSearchBar(SongName);
		logger.info("Entered songname");
		yt.clickOnSearchButton();
		logger.info("Clicked on search button");
		yt.clickOnSong();
		logger.info("clicked on song");
		//Thread.sleep(10000);

		String expectedTitle = "शिव शिव शंभो महादेव शंभो... shiv shiv Shambhu Mahadev Shambhu... - YouTube";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		String title = driver.getTitle();

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

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");


		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}
}
