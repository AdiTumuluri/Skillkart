package com.skillrary.skillkart.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.skillrary.skillkart.generic.AutoConstants;
import com.skillrary.skillkart.generic.WebActionUtil;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.LoginPage;

public class BaseTest implements AutoConstants
{
	WebDriver driver;
	WebActionUtil webActionUtil;
	
	@Parameters({"browserName","appURL","ITO","ETO"})
	@BeforeClass
	public void launchApp(@Optional(DEFAULT_BROWSER)String browserName,
							@Optional(DEFAULT_APPURL)String appURL,
							@Optional(ITO)String ITO, 
							@Optional(ETO)String ETO)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		}
		else
		{
			throw new IllegalArgumentException("Sorry, This Browser is Not Supported in our App");
		}
		
		driver.manage().window().maximize();
		long ito = Long.parseLong(ITO);
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);
		long eto = Long.parseLong(ETO);
		driver.get(appURL);
		webActionUtil = new WebActionUtil(driver, eto);
	}
	
	@Parameters({"un", "pwd"})
	@BeforeMethod
	public void loginToApp(@Optional(DEFAULT_USERNAME)String un,
							@Optional(DEFAULT_PASSWORD)String pwd)
	{
		LoginPage lp = new LoginPage(driver, webActionUtil);
		lp.login(un, pwd);
	}
	
	@AfterMethod
	public void logoutFromApp()
	{
		HomePage hp = new HomePage(driver, webActionUtil);
		hp.logout();
		hp.signIn();
	}
	
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
	
}
