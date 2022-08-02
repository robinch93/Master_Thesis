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

public class CalculatorAppium8Updated {

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
		AddScreenshot.elementScreenshot("CalculatorAppium8", driver, element0 , "element0");
		driver.findElementById("com.google.android.calculator:id/collapse_expand").click();


		Thread.sleep(200);
		MobileElement element1 = driver.findElementById("com.google.android.calculator:id/fun_cos");
		AddScreenshot.elementScreenshot("CalculatorAppium8", driver, element1 , "element1");
		driver.findElementById("com.google.android.calculator:id/fun_cos").click();


		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("com.google.android.calculator:id/digit_9");
		AddScreenshot.elementScreenshot("CalculatorAppium8", driver, element2 , "element2");
		driver.findElementById("com.google.android.calculator:id/digit_9").click();


		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("com.google.android.calculator:id/digit_0");
		AddScreenshot.elementScreenshot("CalculatorAppium8", driver, element3 , "element3");
		driver.findElementById("com.google.android.calculator:id/digit_0").click();


		Thread.sleep(200);
		MobileElement element4 = driver.findElementById("com.google.android.calculator:id/parens");
		AddScreenshot.elementScreenshot("CalculatorAppium8", driver, element4 , "element4");
		driver.findElementById("com.google.android.calculator:id/parens").click();


		Thread.sleep(200);
		MobileElement element5 = driver.findElementById("com.google.android.calculator:id/eq");
		AddScreenshot.elementScreenshot("CalculatorAppium8", driver, element5 , "element5");
		driver.findElementById("com.google.android.calculator:id/eq").click();


		Thread.sleep(200);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'0')]");
		AddScreenshot.elementScreenshot("CalculatorAppium8", driver, element6 , "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'0')]").isDisplayed());


	}

}
