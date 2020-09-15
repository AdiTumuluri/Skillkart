package com.skillrary.skillkart.generic;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil
{
	WebDriverWait wait;
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	
	public WebActionUtil(WebDriver driver, long eto) 
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,eto);
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}
	
	public void enterData(WebElement target, String keysToType)
	{
		target.clear();
		target.sendKeys(keysToType);
	}
	
	public void click(WebElement target)
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
	}
	
	public void scrollDown(int yCordinate)
	{
		js.executeScript("window.scrollBy(0,"+yCordinate+");");
	}
	
	public void scrollUp(int yCordinate)
	{
		js.executeScript("window.scrollBy(0,-"+yCordinate+");");
	}
	
	public void jsClick(WebElement target)
	{
		js.executeScript("arguments[0].click();", target);
	}
	
	public void jsSendkeys(WebElement target, String keysToType)
	{
		target.clear();
		js.executeScript("arguments[0].value='"+keysToType+"';", target);
	}
	
	public void hoverMouseOnElement(WebElement target)
	{
		actions.moveToElement(target).perform();
	}
	
	public void dragAndDrop(WebElement source, WebElement target)
	{
		actions.dragAndDrop(source,target).perform();
	}
	
	public void rightClick(WebElement target)
	{
		actions.contextClick(target).perform();
	}
	
	public void selectByVisibleText(WebElement target, String text)
	{
		Select select = new Select(target);
		select.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement target, int index)
	{
		Select select = new Select(target);
		select.selectByIndex(index);
	}
	
	public void switchToFrame(String frameIdNameIndex)
	{
		Utilities.sleepInSeconds(5);
		try
		{
			int index = Integer.parseInt(frameIdNameIndex);
			driver.switchTo().frame(index);
		}
		catch(NumberFormatException e)
		{
			driver.switchTo().frame(frameIdNameIndex);
		}
	}
	
}












