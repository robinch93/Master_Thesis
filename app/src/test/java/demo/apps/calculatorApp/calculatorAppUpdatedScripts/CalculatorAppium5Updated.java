package demo.apps.calculatorApp.calculatorAppUpdatedScripts;
import demo.parser.AddScreenshot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import demo.parser.Globals;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorAppium5Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel4");
		dc.setCapability(MobileCapabilityType.APP, Globals.cwd + "/apks/calculator.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);

		MobileElement element0 = driver.findElementById("com.google.android.calculator:id/digit_5");
		AddScreenshot.elementScreenshot("CalculatorAppium5", driver, element0 , "element0");
		driver.findElementById("com.google.android.calculator:id/digit_5").click();


		Thread.sleep(200);
		MobileElement element1 = driver.findElementById("com.google.android.calculator:id/op_fact");
		AddScreenshot.elementScreenshot("CalculatorAppium5", driver, element1 , "element1");
		driver.findElementById("com.google.android.calculator:id/op_fact").click();


		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("com.google.android.calculator:id/eq");
		AddScreenshot.elementScreenshot("CalculatorAppium5", driver, element2 , "element2");
		driver.findElementById("com.google.android.calculator:id/eq").click();


		Thread.sleep(200);
		MobileElement element3 = driver.findElementByXPath("//*[contains(@text,'120')]");
		AddScreenshot.elementScreenshot("CalculatorAppium5", driver, element3 , "element3");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'120')]").isDisplayed());


	}

}
