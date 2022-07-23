package demo.apps.calculatorApp.calculatorAppUpdatedScripts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.AddScreenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorAppium9Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.APP,
				"E:\\CalculatorApp\\app\\build\\outputs\\apk\\app-debug.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		MobileElement element0 = driver.findElementById("anubhav.calculatorapp:id/button");
		AddScreenshot.elementScreenshot(driver, element0, "element0");
		driver.findElementById("anubhav.calculatorapp:id/button").click();

		Thread.sleep(1500);
		MobileElement element1 = driver.findElementById("anubhav.calculatorapp:id/clear");
		AddScreenshot.elementScreenshot(driver, element1, "element1");
		driver.findElementById("anubhav.calculatorapp:id/clear").click();

		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("anubhav.calculatorapp:id/num9");
		AddScreenshot.elementScreenshot(driver, element2, "element2");
		driver.findElementById("anubhav.calculatorapp:id/num9").click();

		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("anubhav.calculatorapp:id/num0");
		AddScreenshot.elementScreenshot(driver, element3, "element3");
		driver.findElementById("anubhav.calculatorapp:id/num0").click();

		Thread.sleep(200);
		MobileElement element4 = driver.findElementById("anubhav.calculatorapp:id/sin");
		AddScreenshot.elementScreenshot(driver, element4, "element4");
		driver.findElementById("anubhav.calculatorapp:id/sin").click();

		Thread.sleep(200);
		MobileElement element5 = driver.findElementById("anubhav.calculatorapp:id/equal");
		AddScreenshot.elementScreenshot(driver, element5, "element5");
		driver.findElementById("anubhav.calculatorapp:id/equal").click();

		Thread.sleep(200);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'1.0')]");
		AddScreenshot.elementScreenshot(driver, element6, "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'1.0')]").isDisplayed());

	}

}
