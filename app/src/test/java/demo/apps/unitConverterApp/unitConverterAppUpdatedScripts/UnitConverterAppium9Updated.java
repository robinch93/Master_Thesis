package demo.apps.unitConverterApp.unitConverterAppUpdatedScripts;
import demo.parser.AddScreenshot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class UnitConverterAppium9Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException  {

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

		MobileElement element0 = driver.findElementById("com.rcarvalho.unitconverter:id/spinnerCategory");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element0 , "element0");
		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerCategory").click();


		Thread.sleep(1000);
		MobileElement element1 = driver.findElementByXPath("//*[contains(@text,'Temperature')]");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element1 , "element1");
		driver.findElementByXPath("//*[contains(@text,'Temperature')]").click();


		Thread.sleep(500);
		MobileElement element2 = driver.findElementById("com.rcarvalho.unitconverter:id/input");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element2 , "element2");
		driver.findElementById("com.rcarvalho.unitconverter:id/input").sendKeys("1");

		;

		Thread.sleep(500);
		MobileElement element3 = driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsBase");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element3 , "element3");
		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsBase").click();


		Thread.sleep(1000);
		MobileElement element4 = driver.findElementByXPath("//*[contains(@text,'Celcius')]");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element4 , "element4");
		driver.findElementByXPath("//*[contains(@text,'Celcius')]").click();


		Thread.sleep(500);
		MobileElement element5 = driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsResult");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element5 , "element5");
		driver.findElementById("com.rcarvalho.unitconverter:id/spinnerUnitsResult").click();


		Thread.sleep(500);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'Fahrenheit')]");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element6 , "element6");
		driver.findElementByXPath("//*[contains(@text,'Fahrenheit')]").click();


		Thread.sleep(500);
		MobileElement element7 = driver.findElementById("com.rcarvalho.unitconverter:id/btnConvert");
		AddScreenshot.elementScreenshot("UnitConverterAppium9", driver, element7 , "element7");
		driver.findElementById("com.rcarvalho.unitconverter:id/btnConvert").click();


		Thread.sleep(1000);
		assertTrue(driver.findElementByXPath("//*[contains(@text,'1 Celcius is equal "
				+ "to 33.8000 Fahrenheit')]").isDisplayed());

	}

}
