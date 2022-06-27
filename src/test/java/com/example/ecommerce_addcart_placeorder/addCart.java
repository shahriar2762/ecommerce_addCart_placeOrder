	package com.example.ecommerce_addcart_placeorder;

	import com.opencsv.exceptions.CsvValidationException;
	import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.*;
	import io.appium.java_client.TouchAction;
	//import org.openqa.selenium.By;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.touch.offset.PointOption;
	import javafx.beans.binding.When;
	import org.openqa.selenium.*;
	import io.appium.java_client.android.AndroidDriver;
	//import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.touch.TouchActions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.*;
	//import org.openqa.selenium.support.ui.WebDriverWait;
	import org.springframework.ui.context.Theme;
	import org.testng.Assert;
	import org.testng.annotations.*;

	import javax.xml.bind.Element;
	import java.io.IOException;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;


	public class addCart {

		public static AndroidDriver driver;
		TouchActions action ;
		WebDriverWait wait;

		@BeforeSuite
		public void setup() throws MalformedURLException, NullPointerException {
			DesiredCapabilities dc = new DesiredCapabilities();

//			dc.setCapability("platformVersion", "11.0");
	        dc.setCapability("platformVersion", "6.0.1");
			dc.setCapability("platformName", "Android");
	        dc.setCapability("deviceName", "ONE E1001");
	        dc.setCapability("udid","2a5d2cf8");

//			dc.setCapability("deviceName", "emulator-5554");
//			dc.setCapability("udid","emulator-5554");
			dc.setCapability("appPackage","com.nopstation.nopcommerce.nopstationcart");
			dc.setCapability("appActivity", "com.bs.ecommerce.main.SplashScreenActivity");


			driver = new AndroidDriver(new URL("http://127.0.1.1:4723/wd/hub"),dc);
		}
		@AfterSuite
		public  void tearDown()
		{
			driver.quit();

		}

		@Test
		public void addCart()  {
			try {
				Thread.sleep(5000);
				wait = new WebDriverWait(driver, 50);

	//          Accept Terms
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept")).click();

	//          Click Navigation and Select Electronics
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottom_nav_categories"))));
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottom_nav_categories")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text = 'Electronics']")).click();
				Thread.sleep(5000);

	//          Scroll To find the Nokia Lumia 1020 and click on Nokia Lumia 1020
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().resourceId(\"com.nopstation.nopcommerce.nopstationcart:id/rvProductList\")).scrollForward(2)"));

				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Nokia Lumia 1020\"))")).click();
				Thread.sleep(5000);

	//          Find the Size and Select the size Large and select done
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Size\"))")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//android.widget.RadioButton[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/tvDone")).click();


	//          Increase the quantity to 2 and click on add to cart.
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnPlus"))));
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnPlus")).click();
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart"))));
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart")).click();
				Thread.sleep(4000);




			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		@Test
		public void placeOrder() throws IOException, CsvValidationException, InterruptedException, NullPointerException {


			csvRead data = new csvRead();



			while ((data.csvCell = data.address_data.readNext())!= null ){

			String firstName = data.csvCell[0];
			String lastName = data.csvCell[1];
			String email = data.csvCell[2];
			String company = data.csvCell[3];
			String city = data.csvCell[4];
			String address1 = data.csvCell[5];
			String address2 = data.csvCell[6];
			String zip = data.csvCell[7];
			String phnNo = data.csvCell[8];
			String fax = data.csvCell[9];
			String quantityAssertion = data.csvCell[10];
			String sizeAssertion = data.csvCell[11];
			String shippingAssertion = data.csvCell[12];
			String paymentAssertion = data.csvCell[13];
			String successMessageAssertion = data.csvCell[14];



	//          CLick on the Cart Icon
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/menu_cart")).click();
				Thread.sleep(3000);

	//          CLick on the checkout button.
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut")).click();
				Thread.sleep(2000);

	//          Checkout As Guest Button
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")).click();

	//          Billing Address


				Thread.sleep(2000);
	//          FirstName
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName")).sendKeys(firstName);

	//          LastName
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName")).sendKeys(lastName);

	//          Email
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail")).sendKeys(email);

	//          Country
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//android.widget.TextView[2]")).click();
				Thread.sleep(3000);

	//          Select State
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/stateSpinner")).click();
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"North Dakota\"))"));

				driver.findElement(By.xpath("//android.widget.TextView[@text = 'North Dakota']")).click();
				Thread.sleep(2000);


	//          Company
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")).sendKeys(company);

				//          Scroll Forward
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));


	//          City
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity")).sendKeys(city);

	//          Scroll Forward
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

	//          Street Address 1
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")).sendKeys(address1);

	//          Street Address 2
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress2")).sendKeys(address2);

	//          Zip Code
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode")).sendKeys(zip);

	//          Phone Number
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etPhone")).sendKeys(phnNo);


	//          fax
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFax")).sendKeys(fax);


	//          Continue
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
				Thread.sleep(3000);


	//          Shipping
				driver.findElement(By.xpath("//android.widget.RelativeLayout[3]")).click();
	//          Scroll Forward
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

	//          Continue
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
				Thread.sleep(3000);

	//          Find Check / Money Order
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Check / Money Order\"))"));


	//          Select Check/ Money order and then continue
				driver.findElement(By.xpath("//android.widget.TextView[@text = 'Check / Money Order']")).click();
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
				Thread.sleep(5000);


	//          Payment Information Next
				driver.findElement(By.xpath("//android.widget.Button[@text = 'Next']")).click();
				Thread.sleep(2000);




	//          Assertions

				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().resourceId(\"com.nopstation.nopcommerce.nopstationcart:id/allLayoutExceptButton\")).scrollForward()"));

	//          Assertion Quantity 2

				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Quantity: 2\"))"));

				String actualQuantity= driver.findElement(By.xpath("//android.widget.TextView[@text = 'Quantity: 2']")).getText();
				System.out.println(actualQuantity);
				Assert.assertEquals(actualQuantity,quantityAssertion, "Quantity is not matched.");


	//          Assertion Size Large
				String actualSize = driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/tvAttribute1")).getText();
				System.out.println(actualSize);
				Assert.assertTrue(actualSize.contains(sizeAssertion),"Size is not Large.");

	//          Assertion Next Day Air
				String actualShippingMethod = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Next Day Air']")).getText();
				System.out.println(actualShippingMethod);
				Assert.assertEquals(actualShippingMethod,shippingAssertion, "Shipping method is not Next day Air.");

	//          Assertion Payment Method
				driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Check / Money Order\"))"));
				String actualPaymentMethod = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Check / Money Order']")).getText();
				System.out.println(actualPaymentMethod);
				Assert.assertEquals(actualPaymentMethod,paymentAssertion,"Payment method is not Check / Money Order");


	//          Click Continue
				driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/checkoutButton")).click();
				Thread.sleep(7000);

				String actualSuccessMessage = driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message")).getText();
				Assert.assertTrue(actualSuccessMessage.contains(successMessageAssertion),"Order is not placed");

				Thread.sleep(2000);


	//         Go to Continue

			   driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/md_button_positive")).click();
			   Thread.sleep(2000);
		}


		}
	}
