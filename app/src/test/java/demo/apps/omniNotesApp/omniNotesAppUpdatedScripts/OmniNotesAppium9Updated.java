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

public class OmniNotesAppium9Updated {

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
		AddScreenshot.elementScreenshot("OmniNotesAppium9", driver, element1, "element1");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button").click();

		MobileElement element2 = driver.findElementById("it.feio.android.omninotes.foss:id/fab_checklist");
		AddScreenshot.elementScreenshot("OmniNotesAppium9", driver, element2, "element2");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_checklist").click();

		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").sendKeys("First Checklist");

		MobileElement element3 = driver.findElementById("it.feio.android.omninotes.foss:id/menu_category");
		AddScreenshot.elementScreenshot("OmniNotesAppium9", driver, element3, "element3");
		driver.findElementById("it.feio.android.omninotes.foss:id/menu_category").click();

		MobileElement element4 = driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium9", driver, element4, "element4");
		driver.findElementByXPath("//*[contains(@text,'ADD CATEGORY')]").click();

		driver.findElementByXPath("//*[contains(@resource-id,'category_title')]").sendKeys("Work");

		MobileElement element5 = driver.findElementById("it.feio.android.omninotes.foss:id/save");
		AddScreenshot.elementScreenshot("OmniNotesAppium9", driver, element5, "element5");
		driver.findElementById("it.feio.android.omninotes.foss:id/save").click();

		MobileElement element6 = driver
				.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium9", driver, element6, "element6");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();

		MobileElement element7 = driver.findElementByXPath("//*[contains(@text,'First Checklist')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium9", driver, element7, "element7");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'First Checklist')]").isDisplayed());

	}

}
