package com.example.ecommerce_addcart_placeorder;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.*;
import io.appium.java_client.TouchAction;
//import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
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

        dc.setCapability("platformVersion", "11.0");
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("udid","emulator-5554");
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

//        WebElement


            Thread.sleep(5000);

//            MobileElement list = (MobileElement) driver.findElementsById("com.nopstation.nopcommerce.nopstationcart:id/ivProductThumb");
//
           
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Nokia Lumia 1020\").instance(0))").click();

//            MobileElement listItem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
//                    "new UiScrollable(new UiSelector().scrollIntoView(new UiSelector().description(\"Nokia Lumia 1020\")))"));
//
//
//            System.out.println(listItem.getLocation());
//            listItem.click();



            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//    private void scrollScreen()
//    {
//        Dimension dim = driver.manage().window().getSize();
//        int height = dim.getHeight();
//        int width = dim.getWidth();
//
//
//        int startX = width;
//        int endX = width;
//        int startY =(int) (height* .40);
//        int endY = (int) (height*.10);
//
//        action = new TouchActions(driver);
//        action.longPress(PointOption(startX,startY)).moveToElement(PointOption.point(endX,endY)).release().perform();
//
//    }

}
