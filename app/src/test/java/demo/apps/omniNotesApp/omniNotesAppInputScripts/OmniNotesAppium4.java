package demo.apps.omniNotesApp.omniNotesAppInputScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium4 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException  {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.APP,
				"E:\\Omni-Notes\\omniNotes\\build\\outputs\\apk\\alpha\\debug\\OmniNotes.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_expand_menu_button").click();

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_note").click();

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title").sendKeys("Work Note");

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.alpha:id/menu_category").click();

		Thread.sleep(300);
		driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]").click();

		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text,'Title')]").sendKeys("Work");

		driver.findElementById("it.feio.android.omninotes.alpha:id/save").click();

		Thread.sleep(500);
		assertTrue(driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title").isDisplayed());
	}

}
