package demo.apps.calculatorApp.calculatorAppInputScripts;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorAppium1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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

		driver.findElementById("anubhav.calculatorapp:id/button1").click();

		Thread.sleep(1000);
		driver.findElementById("anubhav.calculatorapp:id/clear").click();

		Thread.sleep(200);
		driver.findElementById("anubhav.calculatorapp:id/num5").click();

		Thread.sleep(200);
		driver.findElementById("anubhav.calculatorapp:id/plus").click();
		
		Thread.sleep(200);
		driver.findElementById("anubhav.calculatorapp:id/num4").click();

		Thread.sleep(200);
		driver.findElementById("anubhav.calculatorapp:id/equal").click();
		
		Thread.sleep(200);
		assertTrue(driver.findElementByXPath("//*[contains(@text,'9.0')]").isDisplayed());

	} 

}
