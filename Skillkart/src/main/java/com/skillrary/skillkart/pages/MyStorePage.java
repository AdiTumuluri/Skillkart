package com.skillrary.skillkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generic.WebActionUtil;

public class MyStorePage extends BasePage
{
	public MyStorePage(WebDriver driver, WebActionUtil webActionUtil)  
	{
		super(driver,webActionUtil);
	}
	
	//My Store Page WebElements
	@FindBy(xpath="//ul[contains(@class,'product_list')]//a[@class='product_img_link']")
	private List<WebElement> productsList;
	
	@FindBy(xpath="//a[text()='Grid']")
	private List<WebElement> gridView;
	
	@FindBy(xpath="//a[text()='List']")
	private List<WebElement> listView;
	
	//Action Methods
	public ProductDetailPage selectTheProduct(String productId)
	{
		productId="id_product="+productId;
		
		for(WebElement product:productsList)
		{
			if(product.getAttribute("href").contains(productId))
			{
				webActionUtil.jsClick(product);
				break;
			}
		}
		return new ProductDetailPage(driver,webActionUtil);
	}
}
