package com.skillrary.skillkart.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

//import org.testng.Assert;
//import org.testng.annotations.Test;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.OrderDetailPage;
import com.skillrary.skillkart.pages.ProductDetailPage;
import com.skillrary.skillkart.generic.Utilities;

public class TC002 extends BaseTest
{
	@Test(description="Verify Product is Deleted and is not Displayed in Order Detail Page")
	public void testProductIsDisplayed()
	{
		HomePage hp = new HomePage(driver, webActionUtil);
		MyStorePage myStorePage = hp.clickOnTab("Dresses");
		// 1st product
		ProductDetailPage pdp = myStorePage.selectTheProduct("5");
		pdp.increaseQuantity(2);
		pdp.selectSize("L");
		pdp.selectColor("Blue");
		pdp.clickOnAddToKart();
		pdp.clickOnContinueShopping();
		hp.clickOnTab("Dresses");
		//Utilities.sleepInSeconds(2);
		
		// 2nd product
		ProductDetailPage pdp2 = myStorePage.selectTheProduct("4");
		pdp2.increaseQuantity(1);
		pdp2.selectSize("L");
		pdp2.selectColor("Beige");
		pdp2.clickOnAddToKart();
		pdp2.clickOnContinueShopping();
		hp.clickOnTab("Dresses");
		//Utilities.sleepInSeconds(2);
				
		// 3rd product
		ProductDetailPage pdp1 = myStorePage.selectTheProduct("3");
		pdp1.increaseQuantity(2);
		pdp1.selectSize("S");
		pdp1.selectColor("Orange");
		pdp.clickOnAddToKart();
		
		//Checkout
		OrderDetailPage odp = pdp.clickOnProceedToCheckout();
		Assert.assertEquals(odp.verifyProductIsAvailable("5"), true, " Item Found -  Product Id 5 ");
		Assert.assertEquals(odp.verifyProductIsAvailable("4"), true);
		Assert.assertEquals(odp.verifyProductIsAvailable("3"), true);
		odp.deleteItemFromCart("4");
		Utilities.sleepInSeconds(4);
		//odp.deleteItemFromCart("3");
		//odp.deleteItemFromCart("5");
		//Check if deleted Item is displayed
		Assert.assertEquals(odp.verifyProductIsAvailable("4"),false," Item not Found -  Product Id 4 ");
	}
}
