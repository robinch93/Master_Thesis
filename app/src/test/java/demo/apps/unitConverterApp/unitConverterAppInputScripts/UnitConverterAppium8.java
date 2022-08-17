package demo.apps.unitConverterApp.unitConverterAppInputScripts;

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

public class UnitConverterAppium8 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, Globals.AUTOMATION_NAME);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Globals.PLATFORM_NAME);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, Globals.PLATFORM_VERSION);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, Globals.DEVICE_NAME);
		dc.setCapability(MobileCapabilityType.APP, Globals.cwd + "/apks/unit-converter.apk");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3000");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text='Volume']").click();

		driver.findElementById("com.androidapps.unitconverter:id/chip_to_unit_name").click();

		driver.findElementByXPath("//android.widget.TextView[@text='cubic meter']").click();

		driver.findElementById("com.androidapps.unitconverter:id/bt_simple_units_view").click();

		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").click();
		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").clear();
		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").sendKeys("5");

		assertTrue(driver.findElementByXPath("//*[contains(@text,'0.005')]").isDisplayed());

	}

}
