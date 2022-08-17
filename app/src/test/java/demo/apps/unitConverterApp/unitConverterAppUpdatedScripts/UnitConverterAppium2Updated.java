package demo.apps.unitConverterApp.unitConverterAppUpdatedScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.AddScreenshot;
import demo.parser.Globals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UnitConverterAppium2Updated {

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

		MobileElement element1 = driver.findElementByXPath("//android.widget.TextView[@text='Length']");
		AddScreenshot.elementScreenshot("UnitConverterAppium2", driver, element1, "element1");
		driver.findElementByXPath("//android.widget.TextView[@text='Length']").click();

		MobileElement element2 = driver.findElementById("com.androidapps.unitconverter:id/chip_to_unit_name");
		AddScreenshot.elementScreenshot("UnitConverterAppium2", driver, element2, "element2");
		driver.findElementById("com.androidapps.unitconverter:id/chip_to_unit_name").click();

		MobileElement element3 = driver.findElementByXPath("//android.widget.TextView[@text='meter']");
		AddScreenshot.elementScreenshot("UnitConverterAppium2", driver, element3, "element3");
		driver.findElementByXPath("//android.widget.TextView[@text='meter']").click();

		MobileElement element4 = driver.findElementById("com.androidapps.unitconverter:id/bt_simple_units_view");
		AddScreenshot.elementScreenshot("UnitConverterAppium2", driver, element4, "element4");
		driver.findElementById("com.androidapps.unitconverter:id/bt_simple_units_view").click();

		MobileElement element5 = driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val");
		AddScreenshot.elementScreenshot("UnitConverterAppium2", driver, element5, "element5");
		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").click();

		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").clear();
		driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val").sendKeys("0.5");

		MobileElement element6 = driver.findElementById("com.androidapps.unitconverter:id/et_from_unit_val");
		AddScreenshot.elementScreenshot("UnitConverterAppium2", driver, element6, "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'500.000')]").isDisplayed());

	}

}
