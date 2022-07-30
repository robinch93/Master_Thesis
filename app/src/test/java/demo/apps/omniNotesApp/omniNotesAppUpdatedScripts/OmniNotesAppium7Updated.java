package demo.apps.omniNotesApp.omniNotesAppUpdatedScripts;
import demo.parser.AddScreenshot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium7Updated {

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

		MobileElement element0 = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium7", driver, element0 , "element0");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();


		Thread.sleep(200);
		MobileElement element1 = driver.findElementById("it.feio.android.omninotes.alpha:id/settings");
		AddScreenshot.elementScreenshot("OmniNotesAppium7", driver, element1 , "element1");
		driver.findElementById("it.feio.android.omninotes.alpha:id/settings").click();


		Thread.sleep(500);
		// click on Notifications
		MobileElement element2 = driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[7]");
		AddScreenshot.elementScreenshot("OmniNotesAppium7", driver, element2 , "element2");
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[7]").click();


		Thread.sleep(200);
		// click on Seconds reminder delay
		MobileElement element3 = driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[4]");
		AddScreenshot.elementScreenshot("OmniNotesAppium7", driver, element3 , "element3");
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[4]").click();


		Thread.sleep(200);
		// enter text in Seconds
		MobileElement element4 = driver.findElementByXPath("(//*[@class=\"android.widget.EditText\"])");
		AddScreenshot.elementScreenshot("OmniNotesAppium7", driver, element4 , "element4");
		driver.findElementByXPath("(//*[@class=\"android.widget.EditText\"])").sendKeys("20");


		MobileElement element5 = driver.findElementByXPath("//*[contains(@text,'OK')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium7", driver, element5 , "element5");
		driver.findElementByXPath("//*[contains(@text,'OK')]").click();


		Thread.sleep(200);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'1020 minutes')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium7", driver, element6 , "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'1020 minutes')]").isDisplayed());


	}

}
