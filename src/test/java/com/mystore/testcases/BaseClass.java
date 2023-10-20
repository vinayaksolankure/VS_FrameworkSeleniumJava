package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	String username = readConfig.getUsername();
	String password = readConfig.getPassword();
	String utubeURL = readConfig.getUTubeURL();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() {

		switch(browser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
			break;
		}

		// Implicit wait of 10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// For logging
		logger = LogManager.getLogger("MyStoreV1");

		// open url
		driver.get(url);
		logger.info("url opened");
	}

	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String testName) throws IOException 
	{
		// Step 1 : convert webdriver object to takescreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);  // Typecasted

		// Step 2 : call getScreenShotAs method to create img file
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png" );

		// Step 3 : Copy img file to dest.
		FileUtils.copyFile(src, dest);
	}
}
