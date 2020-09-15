package com.skillrary.skillkart.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.OrderDetailPage;
import com.skillrary.skillkart.pages.ProductDetailPage;

public class TC001 extends BaseTest
{
	@Test(description="Verify Whether Product Added to Kart is Displayed in Order Detail Page")
	public void testProductIsDisplayed()
	{
		HomePage hp = new HomePage(driver, webActionUtil);
		MyStorePage myStorePage = hp.clickOnTab("Dresses");
		ProductDetailPage pdp = myStorePage.selectTheProduct("5");
		pdp.increaseQuantity(4);
		pdp.selectSize("L");
		pdp.selectColor("Blue");
		pdp.clickOnAddToKart();
		OrderDetailPage odp = pdp.clickOnProceedToCheckout();
		Assert.assertEquals(odp.verifyProductIsAvailable("5"), true);
	}
}
