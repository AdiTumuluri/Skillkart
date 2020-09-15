package com.skillrary.skillkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;

import com.skillrary.skillkart.generic.WebActionUtil;


public class OrderDetailPage extends BasePage
{
	public OrderDetailPage(WebDriver driver, WebActionUtil webActionUtil)  
	{
		super(driver,webActionUtil);
	}
	
	//ODP WebElements
	@FindBy(xpath="//tbody/tr//td[@class='cart_product']/a")
	private List<WebElement> cartProductsList;
	
	@FindBy(xpath="//tbody/tr//i[@class='icon-trash']/..")
	private List<WebElement> itemDeleteLink;
		
	//Action Methods
	public boolean verifyProductIsAvailable(String productId)
	{
		boolean isDisplayed=false;
		productId="id_product="+productId;
		for(WebElement product:cartProductsList)
		{
			if(product.getAttribute("href").contains(productId)) {
				isDisplayed=true;
			}
		}
		return isDisplayed;
	}
	
	//Delete an Item from cart
	public void deleteItemFromCart(String productId)
	{
		productId="id_product="+productId;
		for(WebElement delItem:itemDeleteLink)
		{
			if(delItem.getAttribute("href").contains(productId)) {
				delItem.click();
				System.out.println("Deleted Item with Product Id "+ productId);
			}
		}
	}
}
//Assiginment=> delete the product from the order Detail Page and verify the product is Not displyed.