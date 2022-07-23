package demo.apps.omniNotesApp.omniNotesAppUpdatedScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.AddScreenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium9Updated {

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

		MobileElement element0 = driver.findElementById("it.feio.android.omninotes.alpha:id/fab_expand_menu_button");
		AddScreenshot.elementScreenshot(driver, element0, "element0");
		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_expand_menu_button").click();

		Thread.sleep(300);
		MobileElement element1 = driver.findElementById("it.feio.android.omninotes.alpha:id/fab_checklist");
		AddScreenshot.elementScreenshot(driver, element1, "element1");
		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_checklist").click();

		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title");
		AddScreenshot.elementScreenshot(driver, element2, "element2");
		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title").sendKeys("First Checklist");

		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("it.feio.android.omninotes.alpha:id/menu_category");
		AddScreenshot.elementScreenshot(driver, element3, "element3");
		driver.findElementById("it.feio.android.omninotes.alpha:id/menu_category").click();

		Thread.sleep(300);
		MobileElement element4 = driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]");
		AddScreenshot.elementScreenshot(driver, element4, "element4");
		driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]").click();

		Thread.sleep(1500);
		MobileElement element5 = driver.findElementByXPath("//*[contains(@resource-id,'category_title')]");
		AddScreenshot.elementScreenshot(driver, element5, "element5");
		driver.findElementByXPath("//*[contains(@resource-id,'category_title')]").sendKeys("Work");

		MobileElement element6 = driver.findElementById("it.feio.android.omninotes.alpha:id/save");
		AddScreenshot.elementScreenshot(driver, element6, "element6");
		driver.findElementById("it.feio.android.omninotes.alpha:id/save").click();

		Thread.sleep(200);
		MobileElement element7 = driver
				.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]");
		AddScreenshot.elementScreenshot(driver, element7, "element7");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();

		Thread.sleep(1500);
		MobileElement element8 = driver.findElementById("//*[contains(@text,'First Checklist')]");
		AddScreenshot.elementScreenshot(driver, element8, "element8");
		assertTrue(driver.findElementById("//*[contains(@text,'First Checklist')]").isDisplayed());

	}

}
