package omniNotesAppium;

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

public class OmniNotesAppium7 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.APP,
				"E:\\Omni-Notes\\omniNotes\\build\\outputs\\apk\\alpha\\debug\\OmniNotes.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.alpha:id/settings").click();

		Thread.sleep(500);
		// click on Notifications
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[7]").click();

		Thread.sleep(200);
		// click on Seconds reminder delay
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[4]").click();
		
		Thread.sleep(200);
		// enter text in Seconds
		driver.findElementByXPath("(//*[@class=\"android.widget.EditText\"])").sendKeys("20");
		
		driver.findElementByXPath("//*[contains(@text,'OK')]").click();
		
		Thread.sleep(200);            
		assertTrue(driver.findElementByXPath("//*[contains(@text,'1020 minutes')]").isDisplayed());

	}

}
