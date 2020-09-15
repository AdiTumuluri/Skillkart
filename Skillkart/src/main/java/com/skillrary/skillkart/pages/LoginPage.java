package com.skillrary.skillkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generic.WebActionUtil;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver,webActionUtil);
	}
	
	//Login Page WebElements
	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotLink;
	
	//Action Methods
	
	public HomePage login(String un, String pwd)
	{
		webActionUtil.enterData(username, un);
		webActionUtil.enterData(password, pwd);
		webActionUtil.click(signInBtn);
		return new HomePage(driver,webActionUtil);
	}
	
	public void clickOnForgotPassword()
	{
		webActionUtil.click(forgotLink);
	}
	
	public boolean verifyLoginPageTitle()
	{
		return driver.getTitle().equals("Login - My Store");
	}
}












