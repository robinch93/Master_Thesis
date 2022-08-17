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

public class OmniNotesAppium6Updated {

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

		MobileElement element1 = driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button");
		AddScreenshot.elementScreenshot("OmniNotesAppium6", driver, element1, "element1");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button").click();

		MobileElement element2 = driver.findElementById("it.feio.android.omninotes.foss:id/fab_checklist");
		AddScreenshot.elementScreenshot("OmniNotesAppium6", driver, element2, "element2");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_checklist").click();

		MobileElement element3 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_title");
		AddScreenshot.elementScreenshot("OmniNotesAppium6", driver, element3, "element3");
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").click();

		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").sendKeys("Checklist with Timestamp");

		MobileElement element4 = driver.findElementByXPath("//*[contains(@resource-id,'menu_attachment')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium6", driver, element4, "element4");
		driver.findElementByXPath("//*[contains(@resource-id,'menu_attachment')]").click();

		MobileElement element5 = driver.findElementByXPath("//*[contains(@text,'Timestamp')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium6", driver, element5, "element5");
		driver.findElementByXPath("//*[contains(@text,'Timestamp')]").click();

		MobileElement element6 = driver
				.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium6", driver, element6, "element6");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();

		MobileElement element7 = driver.findElementByXPath("//*[contains(@text,'Checklist with Timestamp')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium6", driver, element7, "element7");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'Checklist with Timestamp')]").isDisplayed());

	}

}
