package unitConverterAppium;

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

public class UnitConverterAppium9 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.APP,
				"E:\\AndroidSimpleUnitConverter\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerCategory").click();
		
		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text,'Temperature')]").click();
		
		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/input").sendKeys("1");;
		
		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsBase").click();

		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text,'Celcius')]").click();
		
		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsResult").click();

		Thread.sleep(500);
		driver.findElementByXPath("//*[contains(@text,'Fahrenheit')]").click();
		
		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/btnConvert").click();
		
		Thread.sleep(1000);
		assertTrue(driver.findElementByXPath("//*[contains(@text,'1 Celcius is equal "
				+ "to 33.8000 Fahrenheit')]").isDisplayed());

	} 

}
