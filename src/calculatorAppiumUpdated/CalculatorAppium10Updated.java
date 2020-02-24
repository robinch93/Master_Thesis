package calculatorAppiumUpdated;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalculatorAppium10Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.APP,
				"E:\\CalculatorApp\\app\\build\\outputs\\apk\\app-debug.apk");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		MobileElement element0 = driver.findElementById("anubhav.calculatorapp:id/button");
		AddScreenshot.elementScreenshot(driver, element0 , "element0");
		driver.findElementById("anubhav.calculatorapp:id/button").click();


		Thread.sleep(1500);
		MobileElement element1 = driver.findElementById("anubhav.calculatorapp:id/clear");
		AddScreenshot.elementScreenshot(driver, element1 , "element1");
		driver.findElementById("anubhav.calculatorapp:id/clear").click();


		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("anubhav.calculatorapp:id/toggle");
		AddScreenshot.elementScreenshot(driver, element2 , "element2");
		driver.findElementById("anubhav.calculatorapp:id/toggle").click();

		
		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("anubhav.calculatorapp:id/num2");
		AddScreenshot.elementScreenshot(driver, element3 , "element3");
		driver.findElementById("anubhav.calculatorapp:id/num2").click();


		Thread.sleep(200);
		MobileElement element4 = driver.findElementById("anubhav.calculatorapp:id/xpowy");
		AddScreenshot.elementScreenshot(driver, element4 , "element4");
		driver.findElementById("anubhav.calculatorapp:id/xpowy").click();

		
		Thread.sleep(200);
		MobileElement element5 = driver.findElementById("anubhav.calculatorapp:id/equal");
		AddScreenshot.elementScreenshot(driver, element5 , "element5");
		driver.findElementById("anubhav.calculatorapp:id/equal").click();

		
		Thread.sleep(200);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'100.0')]");
		AddScreenshot.elementScreenshot(driver, element6 , "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'100.0')]").isDisplayed());


	} 

}
