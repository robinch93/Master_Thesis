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

public class OmniNotesAppium1Updated {

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
		AddScreenshot.elementScreenshot("OmniNotesAppium1", driver, element0, "element0");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button").click();

		Thread.sleep(200);
		MobileElement element1 = driver.findElementById("it.feio.android.omninotes.foss:id/fab_note");
		AddScreenshot.elementScreenshot("OmniNotesAppium1", driver, element1, "element1");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_note").click();

		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_title");
		AddScreenshot.elementScreenshot("OmniNotesAppium1", driver, element2, "element2");
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").sendKeys("First Note");

		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_content");
		AddScreenshot.elementScreenshot("OmniNotesAppium1", driver, element3, "element3");
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_content").click();

		MobileElement element4 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_content");
		AddScreenshot.elementScreenshot("OmniNotesAppium1", driver, element4, "element4");
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_content").sendKeys("this is the first note");

		MobileElement element5 = driver
				.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium1", driver, element5, "element5");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();

		Thread.sleep(500);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'this is the first note')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium1", driver, element6, "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'this is the first note')]").isDisplayed());

	}

}
