package demo.apps.omniNotesApp.omniNotesAppUpdatedScripts;
import demo.parser.AddScreenshot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium8Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException  {

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

		MobileElement element0 = driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element0 , "element0");
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]").click();


		// click on - Reduced View
		Thread.sleep(200);
		MobileElement element1 = driver.findElementByXPath("//*[contains(@resource-id,'title')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element1 , "element1");
		driver.findElementByXPath("//*[contains(@resource-id,'title')]").click();


		Thread.sleep(200);
		MobileElement element2 = driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element2 , "element2");
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]").click();


		// click on - Expanded View
		Thread.sleep(300);
		MobileElement element3 = driver.findElementByXPath("//*[contains(@resource-id,'title')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element3 , "element3");
		driver.findElementByXPath("//*[contains(@resource-id,'title')]").click();


		Thread.sleep(200);
		MobileElement element4 = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Sort\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element4 , "element4");
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Sort\"]").click();


		Thread.sleep(200);
		MobileElement element5 = driver.findElementByXPath("//*[contains(@text,'Creation date')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element5 , "element5");
		driver.findElementByXPath("//*[contains(@text,'Creation date')]").click();


	}

}
