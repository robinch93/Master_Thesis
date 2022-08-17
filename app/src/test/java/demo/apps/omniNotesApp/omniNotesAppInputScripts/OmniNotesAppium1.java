package demo.apps.omniNotesApp.omniNotesAppInputScripts;

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

public class OmniNotesAppium1 {

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

		driver.findElementById("it.feio.android.omninotes.foss:id/fab_expand_menu_button").click();

		driver.findElementById("it.feio.android.omninotes.foss:id/fab_note").click();

		driver.findElementById("it.feio.android.omninotes.foss:id/detail_title").sendKeys("First Note");

		driver.findElementById("it.feio.android.omninotes.foss:id/detail_content").click();

		driver.findElementById("it.feio.android.omninotes.foss:id/detail_content").sendKeys("this is the first note");

		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();

		Thread.sleep(100);
		assertTrue(driver.findElementByXPath("//*[contains(@text,'this is the first note')]").isDisplayed());

	}

}
