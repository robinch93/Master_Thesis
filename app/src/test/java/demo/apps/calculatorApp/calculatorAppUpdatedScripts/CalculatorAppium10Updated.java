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

public class CalculatorAppium10Updated {

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

		MobileElement element0 = driver.findElementById("com.google.android.calculator:id/collapse_expand");
		AddScreenshot.elementScreenshot("CalculatorAppium10", driver, element0 , "element0");
		driver.findElementById("com.google.android.calculator:id/collapse_expand").click();


		Thread.sleep(200);
		MobileElement element1 = driver.findElementById("com.google.android.calculator:id/fun_ln");
		AddScreenshot.elementScreenshot("CalculatorAppium10", driver, element1 , "element1");
		driver.findElementById("com.google.android.calculator:id/fun_ln").click();


		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("com.google.android.calculator:id/digit_1");
		AddScreenshot.elementScreenshot("CalculatorAppium10", driver, element2 , "element2");
		driver.findElementById("com.google.android.calculator:id/digit_1").click();


		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("com.google.android.calculator:id/eq");
		AddScreenshot.elementScreenshot("CalculatorAppium10", driver, element3 , "element3");
		driver.findElementById("com.google.android.calculator:id/eq").click();


		Thread.sleep(200);
		MobileElement element4 = driver.findElementByXPath("//*[contains(@text,'0')]");
		AddScreenshot.elementScreenshot("CalculatorAppium10", driver, element4 , "element4");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'0')]").isDisplayed());


	}

}
