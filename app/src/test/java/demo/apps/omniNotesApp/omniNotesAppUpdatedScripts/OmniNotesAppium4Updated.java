package demo.apps.omniNotesApp.omniNotesAppUpdatedScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.AddScreenshot;
import demo.parser.Globals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium4Updated {

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

		MobileElement element0 = driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element0, "element0");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button").click();

		Thread.sleep(200);
		MobileElement element1 = driver.findElementById("it.feio.android.omninotes.foss:id/fab_note");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element1, "element1");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_note").click();

		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_title");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element2, "element2");
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").sendKeys("Work Note");

		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("it.feio.android.omninotes.foss:id/menu_category");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element3, "element3");
		driver.findElementById("it.feio.android.omninotes.foss:id/menu_category").click();

		Thread.sleep(300);
		MobileElement element4 = driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element4, "element4");
		driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]").click();

		Thread.sleep(1000);
		MobileElement element5 = driver.findElementByXPath("//*[contains(@text,'Title')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element5, "element5");
		driver.findElementByXPath("//*[contains(@text,'Title')]").sendKeys("Work");

		MobileElement element6 = driver.findElementById("it.feio.android.omninotes.foss:id/save");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element6, "element6");
		driver.findElementById("it.feio.android.omninotes.foss:id/save").click();

		Thread.sleep(500);
		MobileElement element7 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_title");
		AddScreenshot.elementScreenshot("OmniNotesAppium4", driver, element7, "element7");
		assertTrue(driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").isDisplayed());

	}

}
