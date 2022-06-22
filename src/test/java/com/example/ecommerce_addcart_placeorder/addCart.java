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

    @BeforeTest
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
        dc.setCapability("noReset", "true");
        dc.setCapability("fullReset","false");


        driver = new AndroidDriver(new URL("http://127.0.1.1:4723/wd/hub"),dc);
    }
    @AfterTest
    public  void tearDown()
    {
        driver.quit();

    }

    @Test
    public void addCart()  {
        try {
            Thread.sleep(5000);

//            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.ImageView[@index = 0]"))));

            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottom_nav_categories")).click();
//            category.tap();


//            wait.until(ExpectedConditions.visibilityOf(driver.findElement( By.xpath("//android.widget.TextView[@text = Electronics]"))));
            driver.findElement(By.xpath("//android.widget.TextView[@text = 'Electronics']")).click();
//            electronics.click();



            Thread.sleep(5000);

            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.nopstation.nopcommerce.nopstationcart:id/rvProductList\")).scrollForward(2)"));


            MobileElement nokia = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Nokia Lumia 1020\"))"));

            System.out.println(nokia.getText());
            nokia.click();

            Thread.sleep(5000);

            MobileElement size = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Size\"))"));

            System.out.println(size.getText());
            size.click();

//            WebElement btmLayout = driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottomSheetLayout"));
//            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottomSheetLayout")).click();


            Thread.sleep(2000);
//            driver.switchTo().activeElement();
//            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/bottomSheetLayout")).click();
//            btmLayout.click();

//            System.out.printf(btmLayout.getText());
//            action = new TouchActions(driver);
//            action.singleTap(btmLayout);


//            driver.findElement(By.("android.widget.RadioButton")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.RadioButton[2]")).click();

            Thread.sleep(2000);

            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/tvDone")).click();

            Thread.sleep(2000);

            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnPlus")).click();

            Thread.sleep(2000);

            driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart")).click();

            Thread.sleep(6000);




        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
