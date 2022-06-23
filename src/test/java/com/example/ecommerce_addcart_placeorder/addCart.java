package com.example.ecommerce_addcart_placeorder;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.*;
import io.appium.java_client.TouchAction;
//import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.*;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.ui.context.Theme;
import org.testng.annotations.*;

import javax.xml.bind.Element;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class addCart {

    public static AndroidDriver driver;
    TouchActions action ;
    WebDriverWait wait;

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

//        dc.setCapability("platformVersion", "11.0");
        dc.setCapability("platformVersion", "6.0.1");
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "ONE E1001");
        dc.setCapability("udid","2a5d2cf8");

//        dc.setCapability("deviceName", "emulator-5554");
//        dc.setCapability("udid","emulator-5554");
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

//            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.ImageView[@index = 0]"))));

            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept")).click();

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottom_nav_categories"))));

            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottom_nav_categories")).click();

//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Electronics']"))));
            driver.findElement(By.xpath("//android.widget.TextView[@text = 'Electronics']")).click();

            Thread.sleep(5000);

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"com.nopstation.nopcommerce.nopstationcart:id/rvProductList\")).scrollForward(2)"));


            MobileElement nokia = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Nokia Lumia 1020\"))"));


            nokia.click();

            Thread.sleep(5000);

            MobileElement size = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Size\"))"));

            System.out.println(size.getText());
            size.click();

            Thread.sleep(2000);

//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.RadioButton[2]"))));

            driver.findElement(By.xpath("//android.widget.RadioButton[2]")).click();

//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/tvDone"))));

            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/tvDone")).click();

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
    public void placeOrder()
    {

        csvRead csv = new csvRead();

//        String firstName = csv.csvCell[0];
//        String lastName = csv.csvCell[1];
//        String email = csv.csvCell[2];
//        String company = csv.csvCell[3];
//        String city = csv.csvCell[4];
//        String address1 = csv.csvCell[5];
//        String address2 = csv.csvCell[6];
//        String zip = csv.csvCell[7];
//        String phnNo = csv.csvCell[8];
//        String fax = csv.csvCell[9];

        try {
//          CLick on the Cart Icon
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/menu_cart")).click();
            Thread.sleep(2000);

//          CLick on the checkout button.
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut")).click();
            Thread.sleep(2000);

//          Checkout As Guest Button
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")).click();

//          Billing Address


//          FirstName
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName")).sendKeys("firstName");

//          LastName
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName")).sendKeys("lastName");

//          Email
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail")).sendKeys("email");

//          Country
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")).click();

//          Select Country
//            driver.findElementById("android:id/text1").ind)

//          Company
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")).sendKeys("company");

//          Scroll Forward
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

//          City
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity")).sendKeys("city");

//          Street Address 1
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")).sendKeys("address1");

//          Street Address 2
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress2")).sendKeys("address2");

//          Zip Code
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode")).sendKeys("zip");

//          Phone Number
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etPhone")).sendKeys("phnNo");

//          Scroll Forward
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

//          fax
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFax")).sendKeys("fax");

//          Continue
            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();

            Thread.sleep(5000);



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
