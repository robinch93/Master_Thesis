package demo.apps.calculatorApp.calculatorAppUpdatedScripts;
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

public class CalculatorAppium1Updated {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {

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

		MobileElement element0 = driver.findElementById("anubhav.calculatorapp:id/button1");
		AddScreenshot.elementScreenshot("CalculatorAppium1", driver, element0 , "element0");
		driver.findElementById("anubhav.calculatorapp:id/button1").click();


		Thread.sleep(1000);
		MobileElement element1 = driver.findElementById("anubhav.calculatorapp:id/clear");
		AddScreenshot.elementScreenshot("CalculatorAppium1", driver, element1 , "element1");
		driver.findElementById("anubhav.calculatorapp:id/clear").click();


		Thread.sleep(200);
		MobileElement element2 = driver.findElementById("anubhav.calculatorapp:id/num5");
		AddScreenshot.elementScreenshot("CalculatorAppium1", driver, element2 , "element2");
		driver.findElementById("anubhav.calculatorapp:id/num5").click();


		Thread.sleep(200);
		MobileElement element3 = driver.findElementById("anubhav.calculatorapp:id/plus");
		AddScreenshot.elementScreenshot("CalculatorAppium1", driver, element3 , "element3");
		driver.findElementById("anubhav.calculatorapp:id/plus").click();


		Thread.sleep(200);
		MobileElement element4 = driver.findElementById("anubhav.calculatorapp:id/num4");
		AddScreenshot.elementScreenshot("CalculatorAppium1", driver, element4 , "element4");
		driver.findElementById("anubhav.calculatorapp:id/num4").click();


		Thread.sleep(200);
		MobileElement element5 = driver.findElementById("anubhav.calculatorapp:id/equal");
		AddScreenshot.elementScreenshot("CalculatorAppium1", driver, element5 , "element5");
		driver.findElementById("anubhav.calculatorapp:id/equal").click();


		Thread.sleep(200);
		MobileElement element6 = driver.findElementByXPath("//*[contains(@text,'9.0')]");
		AddScreenshot.elementScreenshot("CalculatorAppium1", driver, element6 , "element6");
		assertTrue(driver.findElementByXPath("//*[contains(@text,'9.0')]").isDisplayed());


	}

}
