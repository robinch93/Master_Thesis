package demo.apps.omniNotesApp.omniNotesAppUpdatedScripts;

import demo.parser.AddScreenshot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.Globals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium8Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, Globals.AUTOMATION_NAME);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Globals.PLATFORM_NAME);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, Globals.PLATFORM_VERSION);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, Globals.DEVICE_NAME);
		dc.setCapability(MobileCapabilityType.APP, Globals.cwd + "/apks/omni-notes.apk");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3000");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		MobileElement element1 = driver
				.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element1, "element1");
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]").click();

		// click on - Reduced View

		MobileElement element2 = driver.findElementByXPath("//*[contains(@resource-id,'title')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element2, "element2");
		driver.findElementByXPath("//*[contains(@resource-id,'title')]").click();

		MobileElement element3 = driver
				.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element3, "element3");
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]").click();

		// click on - Expanded View

		MobileElement element4 = driver.findElementByXPath("//*[contains(@resource-id,'title')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element4, "element4");
		driver.findElementByXPath("//*[contains(@resource-id,'title')]").click();

		MobileElement element5 = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Sort\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element5, "element5");
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Sort\"]").click();

		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'Creation date')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium8", driver, element6, "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'Creation date')]").isDisplayed());

	}

}
