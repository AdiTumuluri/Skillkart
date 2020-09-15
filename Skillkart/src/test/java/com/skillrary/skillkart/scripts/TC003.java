package com.skillrary.skillkart.scripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.OrderDetailPage;
import com.skillrary.skillkart.pages.ProductDetailPage;
import com.skillrary.skillkart.generic.ExcelLibrary;
import com.skillrary.skillkart.generic.Utilities;

//import org.testng.Assert;
//import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TC003 extends BaseTest
{
	@DataProvider
	public Object[][] getData(){
		return ExcelLibrary.getExcelData(XL_PATH, "TC003"); 
	}
	
	@Test(description="Verify Product is Deleted and is not Displayed in Order Detail Page",dataProvider="getData")
	public void testProductIsDisplayed(String tabName,String productIdS,String quantityS, String size, String color)
	{
		HomePage hp = new HomePage(driver, webActionUtil);
		MyStorePage myStorePage = hp.clickOnTab(tabName);
		ProductDetailPage pdp=null;
		OrderDetailPage odp=null;
		
				double productIdD = Double.parseDouble(productIdS);
		int productIdI = (int) productIdD;
		String productId = String.valueOf(productIdI);
					
		double quantityD = Double.parseDouble(quantityS);
		int quantity = (int) quantityD;
		System.out.println("Item Details "+ tabName +" "+ productId + " "+quantity +" "+ size+ " "+ color);

		// Product details
		pdp = myStorePage.selectTheProduct(productId);
		pdp.increaseQuantity(quantity);
		pdp.selectSize(size);
		pdp.selectColor(color);
		pdp.clickOnAddToKart();
		odp = pdp.clickOnProceedToCheckout();
		// verify item is added into cart
		Assert.assertEquals(odp.verifyProductIsAvailable(productId), true);
				 
		// Delete a cart item
		odp.deleteItemFromCart(productId);
		Utilities.sleepInSeconds(4);
		//Check if deleted Item is displayed
		Assert.assertEquals(odp.verifyProductIsAvailable(productId),false);
	}
}
