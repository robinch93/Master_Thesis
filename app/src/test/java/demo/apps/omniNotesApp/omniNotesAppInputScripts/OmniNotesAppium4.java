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

public class OmniNotesAppium4 {

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

		driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button").click();

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_note").click();

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").sendKeys("Work Note");

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.foss:id/menu_category").click();

		Thread.sleep(300);
		driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]").click();

		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text,'Title')]").sendKeys("Work");

		driver.findElementById("it.feio.android.omninotes.foss:id/save").click();

		Thread.sleep(500);
		assertTrue(driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").isDisplayed());
	}

}
