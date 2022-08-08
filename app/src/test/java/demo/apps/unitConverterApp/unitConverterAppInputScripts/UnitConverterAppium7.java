package demo.apps.unitConverterApp.unitConverterAppInputScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.Globals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UnitConverterAppium7 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel4");
		dc.setCapability(MobileCapabilityType.APP, Globals.cwd + "/apks/unit-converter.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		driver.findElementByXPath("//android.widget.TextView[@text='Area']").click();

		Thread.sleep(200);
		driver.findElementById("com.androidapps.unitconverter:id/chip_to_unit_name").click();

		Thread.sleep(200);
		driver.findElementByXPath("//android.widget.TextView[@text='Square kilometer']").click();

		Thread.sleep(200);
		driver.findElementById("com.androidapps.unitconverter:id/bt_simple_units_view").click();

		Thread.sleep(200);
		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").clear();
		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").sendKeys("5");

		Thread.sleep(200);
		assertTrue(driver.findElementByXPath("//*[contains(@text,'5.000')]").isDisplayed());

	}

}
