package demo.apps.omniNotesApp.omniNotesAppInputScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

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

		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();

		Thread.sleep(200);
		driver.findElementById("it.feio.android.omninotes.alpha:id/settings").click();

		Thread.sleep(500);
		// click on Interface
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[4]").click();

		Thread.sleep(200);
		// click on Language
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[2]").click();

		Thread.sleep(200);
		// click on cancel button
		driver.findElementByXPath("(//*[@class=\"android.widget.Button\"])[1]").click();

	}

}
