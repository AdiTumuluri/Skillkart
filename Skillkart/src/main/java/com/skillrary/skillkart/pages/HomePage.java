package com.skillrary.skillkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generic.WebActionUtil;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver, WebActionUtil webActionUtil)  
	{
		super(driver,webActionUtil);
	}
	
	//Home Page WebElements
	@FindBy(linkText="Women")
	private WebElement womenTab;
	
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dressesTab;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tShirtsTab;
	
	/*
	@FindBy(partialLinkText="Sign out")
	private WebElement logoutLink;
	*/
	
	@FindBy(xpath="//a[@class='logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement signIn;
	
	//Action Methods
	public MyStorePage clickOnTab(String tabName)
	{
		tabName=tabName.toLowerCase();
		switch (tabName) {
		case "dresses":webActionUtil.click(dressesTab);
					   break;
		case "women":webActionUtil.click(womenTab);
				     break;
		case "tshirts":webActionUtil.click(tShirtsTab);
					   break;
		}
		
		return new MyStorePage(driver, webActionUtil);
	}

	public void logout() 
	{
		webActionUtil.click(logoutLink);		
	}
	
	public void signIn() {
		webActionUtil.click(signIn);
	}
}
