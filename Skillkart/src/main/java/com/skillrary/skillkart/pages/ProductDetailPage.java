package com.skillrary.skillkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generic.Utilities;
import com.skillrary.skillkart.generic.WebActionUtil;

public class ProductDetailPage extends BasePage
{
	public ProductDetailPage(WebDriver driver, WebActionUtil webActionUtil)  
	{
		super(driver,webActionUtil);
	}
	
	//PDP WebElements
	@FindBy(className="icon-minus")
	private WebElement minusIcon;
	
	@FindBy(className="icon-plus")
	private WebElement plusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeList;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']//a")
	private List<WebElement> colorPicker;
	
	@FindBy(name="Submit")
	private WebElement addToKart;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continueShopping;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckout;
	
	@FindBy(className="cross")
	private WebElement closeIcon;
	
	public void increaseQuantity(int num)
	{
		for(int i=1;i<=num;i++)
		{
			webActionUtil.click(plusIcon);
			Utilities.sleepInSeconds(1);
		}
	}
	
	public void decreaseQuantity(int num)
	{
		for(int i=1;i<=num;i++)
		{
			webActionUtil.click(minusIcon);
			Utilities.sleepInSeconds(1);
		}
	}
	
	public void selectSize(String size)
	{
		webActionUtil.selectByVisibleText(sizeList, size);
	}
	
	public void selectColor(String color)
	{
		for(WebElement col:colorPicker)
		{
			if(col.getAttribute("name").equalsIgnoreCase(color))
			{
				col.click();
				break;
			}
		}
	}
	
	public void clickOnAddToKart()
	{
		webActionUtil.click(addToKart);
	}
	
	public void clickOnContinueShopping()
	{
		webActionUtil.click(continueShopping);
	}
	
	public OrderDetailPage clickOnProceedToCheckout()
	{
		webActionUtil.click(proceedToCheckout);
		return new OrderDetailPage(driver, webActionUtil);
	}
	
	public void closePopup()
	{
		webActionUtil.click(closeIcon);
	}
	
}
