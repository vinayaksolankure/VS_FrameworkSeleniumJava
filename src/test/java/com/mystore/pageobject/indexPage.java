package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	// 1. create object of WebDriver
	WebDriver ldriver;

	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//identify web elements
	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginButton;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement menubar;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutButton;

	//identify action on web element
	public void enterUsername(String uname) 
	{
		username.sendKeys(uname);
	}

	public void enterPassword(String pass) 
	{
		password.sendKeys(pass);
	}

	public void clickOnLoginButton() 
	{
		loginButton.click();
	}
	
	public void clickOnMenuButton() 
	{
		menubar.click();
	}

	public void clickOnLogOutButton() 
	{
		logoutButton.click();
	}

}
