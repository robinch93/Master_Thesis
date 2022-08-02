package demo.apps.omniNotesApp.omniNotesAppUpdatedScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.AddScreenshot;
import demo.parser.Globals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium5Updated {

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
		AddScreenshot.elementScreenshot("OmniNotesAppium5", driver, element0, "element0");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button").click();

		Thread.sleep(300);
		MobileElement element1 = driver.findElementById("it.feio.android.omninotes.foss:id/fab_checklist");
		AddScreenshot.elementScreenshot("OmniNotesAppium5", driver, element1, "element1");
		driver.findElementById("it.feio.android.omninotes.foss:id/fab_checklist").click();

		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_title");
		AddScreenshot.elementScreenshot("OmniNotesAppium5", driver, element2, "element2");
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").click();

		MobileElement element3 = driver.findElementById("it.feio.android.omninotes.foss:id/detail_title");
		AddScreenshot.elementScreenshot("OmniNotesAppium5", driver, element3, "element3");
		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").sendKeys("Discard This Checklist");

		Thread.sleep(300);
		MobileElement element4 = driver
				.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium5", driver, element4, "element4");
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"More options\"]").click();

		Thread.sleep(300);
		MobileElement element5 = driver.findElementByXPath("(//*[@class=\"android.widget.TextView\"])[3]");
		AddScreenshot.elementScreenshot("OmniNotesAppium5", driver, element5, "element5");
		driver.findElementByXPath("(//*[@class=\"android.widget.TextView\"])[3]").click();

		Thread.sleep(100);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'OK')]");
		AddScreenshot.elementScreenshot("OmniNotesAppium5", driver, element6, "element6");
		driver.findElementByXPath("//*[contains(@text,'OK')]").click();

	}

}
