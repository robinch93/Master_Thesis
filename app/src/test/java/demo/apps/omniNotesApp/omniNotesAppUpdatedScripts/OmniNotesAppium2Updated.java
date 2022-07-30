package demo.apps.omniNotesApp.omniNotesAppUpdatedScripts;
import demo.parser.AddScreenshot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OmniNotesAppium2Updated {

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

		MobileElement element0 = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]");
		AddScreenshot.elementScreenshot("OmniNotesAppium2", driver, element0 , "element0");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();


		Thread.sleep(200);
		MobileElement element1 = driver.findElementById("it.feio.android.omninotes.alpha:id/settings");
		AddScreenshot.elementScreenshot("OmniNotesAppium2", driver, element1 , "element1");
		driver.findElementById("it.feio.android.omninotes.alpha:id/settings").click();


		Thread.sleep(500);
		// click on Interface
		MobileElement element2 = driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[4]");
		AddScreenshot.elementScreenshot("OmniNotesAppium2", driver, element2 , "element2");
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[4]").click();


		Thread.sleep(200);
		// click on Language
		MobileElement element3 = driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[2]");
		AddScreenshot.elementScreenshot("OmniNotesAppium2", driver, element3 , "element3");
		driver.findElementByXPath("(//*[@class=\"android.widget.RelativeLayout\"])[2]").click();


		Thread.sleep(200);
		// click on cancel button
		MobileElement element4 = driver.findElementByXPath("(//*[@class=\"android.widget.Button\"])[1]");
		AddScreenshot.elementScreenshot("OmniNotesAppium2", driver, element4 , "element4");
		driver.findElementByXPath("(//*[@class=\"android.widget.Button\"])[1]").click();


	}

}
