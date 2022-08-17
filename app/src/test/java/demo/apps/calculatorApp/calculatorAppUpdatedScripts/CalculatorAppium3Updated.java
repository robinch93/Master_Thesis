package demo.apps.calculatorApp.calculatorAppUpdatedScripts;

import demo.parser.AddScreenshot;

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

public class CalculatorAppium3Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, Globals.AUTOMATION_NAME);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Globals.PLATFORM_NAME);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, Globals.PLATFORM_VERSION);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, Globals.DEVICE_NAME);
		dc.setCapability(MobileCapabilityType.APP, Globals.cwd + "/apks/calculator.apk");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3000");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		MobileElement element1 = driver.findElementById("com.google.android.calculator:id/digit_5");
		AddScreenshot.elementScreenshot("CalculatorAppium3", driver, element1, "element1");
		driver.findElementById("com.google.android.calculator:id/digit_5").click();

		MobileElement element2 = driver.findElementById("com.google.android.calculator:id/op_mul");
		AddScreenshot.elementScreenshot("CalculatorAppium3", driver, element2, "element2");
		driver.findElementById("com.google.android.calculator:id/op_mul").click();

		MobileElement element3 = driver.findElementById("com.google.android.calculator:id/digit_4");
		AddScreenshot.elementScreenshot("CalculatorAppium3", driver, element3, "element3");
		driver.findElementById("com.google.android.calculator:id/digit_4").click();

		MobileElement element4 = driver.findElementById("com.google.android.calculator:id/eq");
		AddScreenshot.elementScreenshot("CalculatorAppium3", driver, element4, "element4");
		driver.findElementById("com.google.android.calculator:id/eq").click();

		MobileElement element5 = driver.findElementByXPath("//*[contains(@text,'20')]");
		AddScreenshot.elementScreenshot("CalculatorAppium3", driver, element5, "element5");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'20')]").isDisplayed());

	}

}
