package parser_program;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.spi.LocationInfo;
import org.apache.xml.serializer.OutputPropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AddScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {

		List<String> data = readFile();
		writeFile(data);
	}

	static List<String> elementList = new LinkedList<String>(), actionList = new LinkedList<String>();

	public static List<String> readFile() throws IOException {
		String source = "C:\\Users\\Robin Chaudhary\\eclipse-workspace\\parser_program\\src\\parser_program\\OmniNotesAppium.java";
		try (BufferedReader br = new BufferedReader(new FileReader(source))) {
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			List<String> fileData = new ArrayList<String>();
			String line;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
				fileData.add(line);

				try {
//					String mobileElement = mobileElement(line);
//					elementList.add(mobileElement);
					String action = actionType(line);
					actionList.add(action);
				} catch (NullPointerException n) {

				}
			}
			return fileData;
		}
	}

	public static void writeFile(List<String> fileData) throws IOException, InterruptedException {
		String destination = "C:\\Users\\Robin Chaudhary\\eclipse-workspace\\parser_program\\src\\parser_program\\OmniNotesUpdated.java";
		String textFile = "C:\\Users\\Robin Chaudhary\\eclipse-workspace\\parser_program\\src\\parser_program\\outputText.txt";
		int count = 0;

		while (elementList.remove(null)) {
		}

		
		String[] elementArray = elementList.toArray(new String[elementList.size()]);

		for (int i = 0; i < elementArray.length; i++) {
			System.out.println(elementArray[i]);
		}

		List<String> location = new ArrayList();
		List<String> driverLineList = new ArrayList();
		int j = 0, k = 0;
		for (int i = 0; i < fileData.size(); i++) {
			location.add(fileData.get(i));

			if (fileData.get(i).contains("driver.find")) {
				if (!fileData.get(i).startsWith("//")) {
					driverLineList.add(fileData.get(i));
					for (j = k; j < elementArray.length; j++) {

						location.add("\t\tMobileElement " + "element" + k + " = " + "driver.find" + elementArray[j]
								+ ");" + "\n" + "\t\tAddScreenshot.elementScreenshot(driver," + " element" + k + " ,"
								+ " \"element" + k + "\");");
						location.remove(i);
						k++;
						break;
					}
				}
			}
		}

		System.out.println("Number of lines containing driver.find in source file: " + driverLineList.size());

		String[] driverLine = driverLineList.toArray(new String[driverLineList.size()]);
		List<String> finalList = new ArrayList();
		j = 0;
		k = 0;
		for (int m = 0; m < location.size(); m++) {
			finalList.add(location.get(m));
			if (location.get(m).contains("AddScreenshot")) {
				for (j = k; j < driverLine.length; j++) {
					finalList.add(driverLine[j] + "\n");
					k++;
					break;
				}
			}
		}

		List<String> counted = new ArrayList();
		for (int c = 0; c < finalList.size(); c++) {
			if (finalList.get(c).contains("driver.find")) {
				if (!finalList.get(c).startsWith("//")) {
					counted.add(finalList.get(c));
				}
			}
//			System.out.println(finalList.get(c));
		}

		System.out.println("Number of lines containing driver.find in destination file: " + counted.size());

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
			for (String str : finalList) {
				bw.write(str);
				bw.newLine();

			}
		}

		while (actionList.remove(null)) {
		}
		
		String[] actionArray = actionList.toArray(new String[actionList.size()]);
		System.out.println("action list is below");
		
		for (int i = 0; i < actionArray.length; i++) {
			System.out.println(actionArray[i]);
		}
		
		System.out.println("action list has elements: " + actionArray.length);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(textFile))) {
			for (String str : actionList) {
				bw.write(str);
				bw.newLine();

			}
		}catch(NullPointerException n) {
			
		}
	}

	public static String locatorType(String lineCode) {
		int count = 0;
		if (lineCode.contains("findElementById")) {
			String loc_1 = StringUtils.substringBetween(lineCode, "driver.findElementById(", ")")
					.replaceAll("^\"+|\"+$", "");
			if (loc_1.length() != 0) {
				count = count + 1;
				return loc_1;
			}
		} else if (lineCode.contains("findElementByXPath")) {
			String loc_2 = StringUtils.substringBetween(lineCode, "driver.findElementByXPath(", ")")
					.replaceAll("^\"+|\"+$", "");
			if (loc_2.length() != 0) {
				return loc_2;
			}
		}

		return null;
	}

	public static String mobileElement(String lineCode) {
		int count = 0;
		if (lineCode.contains("driver.find")) {
			String loc = StringUtils.substringBetween(lineCode, "driver.find", ").");
			if (loc.length() != 0) {
				count = count + 1;
				return loc;
			}
		}
		return null;
	}

	public static String actionType(String lineCode) {
		String act = StringUtils.substringBetween(lineCode, ").", "(");
		if (lineCode.contains("driver.find")) {
			if (act.length() != 0) {
				if (act.equals("sendKeys")) {
					String text = "";
					text = StringUtils.substringBetween(lineCode, "sendKeys(", ")").replaceAll("^\"+|\"+$", "");
					return act + " " +text;
				} else {
					return act;
				}
			}
		}
		return act;
	}

	public static String elementScreenshot(AppiumDriver driver, MobileElement ele, String imageName)
			throws InterruptedException {
		Thread.sleep(200);
		File screenshotLocation = null;
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			BufferedImage fullImg = ImageIO.read(scrFile);
			// Get the location of element on the page
			Point point = ele.getLocation();
			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", scrFile);
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

	private static int id = 0;

	public static int seqNum() {
		return ++id;
	}

}
