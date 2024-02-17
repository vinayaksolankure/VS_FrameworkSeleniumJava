package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Youtube {
	WebDriver ldriver;

	public Youtube(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//identify web elements
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchbar;
	
	@FindBy(xpath = "//button[@id='search-icon-legacy']")   //(//yt-icon[@class='style-scope ytd-searchbox'])[2]
	WebElement searchButton;

	@FindBy(xpath = "//*[@title='शिव शिव शंभो महादेव शंभो... shiv shiv Shambhu Mahadev Shambhu...']")
	WebElement song;

	//identify action on web element
	public void enterInSearchBar(String songname) 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchbar)).sendKeys(songname);
		//searchbar.sendKeys(songname);
	}

	public void clickOnSearchButton() 
	{
		searchButton.click();
	}
	
	public void clickOnSong() 
	{
		song.click();
	}
}
