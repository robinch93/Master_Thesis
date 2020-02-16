package parser_program;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OmniNotesAppiumOld {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// Created object of DesiredCapabilities class.
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.APP, "E:\\Omni-Notes\\omniNotes\\build\\outputs\\apk\\alpha\\debug\\OmniNotes.apk");
				
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		   
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		Thread.sleep(3000);
		
		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_expand_menu_button").click();
		
		Thread.sleep(200);
		System.out.println("clicking on Text Note button");
		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_note").click();
		
		Thread.sleep(200);
		System.out.println("clicking on Title text field");
		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title").click();
		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title").sendKeys("First Note");
	
//		Thread.sleep(200);
//		MobileElement content_text= driver.findElementById("it.feio.android.omninotes.alpha:id/detail_content");
//		elementScreenshot(driver, content_text, "content_text");
//		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_content").click();
//		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_content").sendKeys("this is the first note");
		
		//click to add a category
//		driver.findElementById("it.feio.android.omninotes.alpha:id/menu_category").click();
//		Thread.sleep(200);
//		driver.context("NATIVE_APP");
//	    driver.findElement(By.xpath(".//android.widget.Button[@text='ADD CATEGORY']")).click();
//		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();
		
		// write the name of category title
//		Thread.sleep(200);
//		driver.findElementById("it.feio.android.omninotes.alpha:id/category_title").click();
//		driver.findElementById("it.feio.android.omninotes.alpha:id/category_title").sendKeys("Notes category");
//		driver.findElementById("it.feio.android.omninotes.alpha:id/save").click();
		
		// click on back button on top left corner
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_expand_menu_button").click();
		
		Thread.sleep(300);
		MobileElement checklist_button = driver.findElementById("it.feio.android.omninotes.alpha:id/fab_checklist");
		System.out.println("clicking on checklist button");
		elementScreenshot(driver, checklist_button, "checklist_button");
		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_checklist").click();
		
		Thread.sleep(200);
		System.out.println("clicking on Title text field");
		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title").click();
		driver.findElementById("it.feio.android.omninotes.alpha:id/detail_title").sendKeys("First Checklist");
		
		//click to add a category
//		driver.findElementById("it.feio.android.omninotes.alpha:id/menu_category").click();
//		Thread.sleep(200);
//		driver.findElementById("it.feio.android.omninotes.alpha:id/buttonDefaultPositive").click();
		
		// write the name of category title
//		Thread.sleep(200);
//		driver.findElementById("it.feio.android.omninotes.alpha:id/category_title").click();
//		driver.findElementById("it.feio.android.omninotes.alpha:id/category_title").sendKeys("Checklist category");
//		driver.findElementById("it.feio.android.omninotes.alpha:id/save").click();
		
		// click on back button on top left corner
//		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"drawer open\"]").click();
		
		// allow camera access - use Mobileby.element
		//remember photo location 
		// com.android.camera2:id/confirm_button
//		System.out.println("clicking on photo button");
//		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_checklist").click();
//
//		System.out.println("clicking on photo button");
//		driver.findElementById("it.feio.android.omninotes.alpha:id/fab_camera").click();

		
		
	}
	
	public static String elementScreenshot(AppiumDriver driver,MobileElement ele, String imageName) throws InterruptedException
	{
	Thread.sleep(200);
	File screenshotLocation = null;
	try{
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	BufferedImage fullImg = ImageIO.read(scrFile);
	//Get the location of element on the page
	Point point = ele.getLocation();
	//Get width and height of the element
	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();
	//Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
	ImageIO.write(eleScreenshot, "png" , scrFile);
	String path = "Screenshots/" + imageName + "" + ".png";
	screenshotLocation = new File(System.getProperty("user.dir") + "/" + path);
	System.out.println(path);
	FileUtils.copyFile(scrFile, screenshotLocation);

	System.out.println(screenshotLocation.toString());

	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return screenshotLocation.toString();

	}

}
