package demo.apps.unitConverterApp.unitConverterAppInputScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class UnitConverterAppium10 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.APP,
				"E:\\AndroidSimpleUnitConverter\\app\\build\\outputs\\apk\\debug\\app-debug.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerCategory").click();

		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text,'Temperature')]").click();

		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/input").sendKeys("1");
		;

		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsBase").click();

		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text,'Fahrenheit')]").click();

		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsResult").click();

		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text,'Celcius')]").click();

		Thread.sleep(500);
		driver.findElementById("com.rcarvalho.unitconverter:id/btnConvert").click();

		Thread.sleep(1000);
		assertTrue(driver.findElementByXPath("//*[contains(@text,'1 Fahrenheit is equal to "
				+ "-17.2222 Celcius')]").isDisplayed());

	}

}
