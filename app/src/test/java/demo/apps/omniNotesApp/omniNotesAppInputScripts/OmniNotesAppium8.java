package demo.apps.omniNotesApp.omniNotesAppInputScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.Globals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium8 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel4");
		dc.setCapability(MobileCapabilityType.APP, Globals.cwd + "/apks/omni-notes.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]").click();

		// click on - Reduced View
		Thread.sleep(200);
		driver.findElementByXPath("//*[contains(@resource-id,'title')]").click();

		Thread.sleep(200);
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]").click();

		// click on - Expanded View
		Thread.sleep(300);
		driver.findElementByXPath("//*[contains(@resource-id,'title')]").click();

		Thread.sleep(200);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Sort\"]").click();

		Thread.sleep(200);
		assertTrue(driver.findElementByXPath("//*[contains(@text,'Creation date')]").isDisplayed());

	}

}