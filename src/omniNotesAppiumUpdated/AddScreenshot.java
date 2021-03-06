package omniNotesAppiumUpdated;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
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
	static String inputFile = "OmniNotesAppium2"; // to be edited at every run
	static String destFile = inputFile + "Updated";
	static String inputFolderPath = "C:\\Users\\Robin Chaudhary\\eclipse-workspace\\parser_program\\src\\omniNotesAppium\\";
	static String updatedFolderPath = "C:\\Users\\Robin Chaudhary\\eclipse-workspace\\parser_program\\src\\omniNotesAppiumUpdated\\";
	public static String source = inputFolderPath + inputFile + ".java";

	static String destSikuliFolder = "D:\\sikuli\\" + inputFile.replaceAll("[0-9]+", "") + "\\" + inputFile
			+ "GUI.sikuli";

	public static List<String> readFile() throws IOException {

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
					String mobileElement = mobileElement(line);
					elementList.add(mobileElement);
					String action = actionType(line);
					actionList.add(action);
				} catch (NullPointerException n) {

				}
			}
			return fileData;
		}
	}

	public static void writeFile(List<String> fileData) throws IOException, InterruptedException {
		String destination = updatedFolderPath + destFile + ".java";
		String textFile = destSikuliFolder + "\\" + inputFile + "sikuli.txt";

		new File(destSikuliFolder).mkdirs();
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
		// add lines to location list.
		for (int i = 0; i < fileData.size(); i++) {
			location.add(fileData.get(i));

			if (fileData.get(i).contains("public class " + inputFile)) {
				location.set(i, "public class " + destFile + " {");
			}

			if (fileData.get(i).contains("package ")) {
				location.set(i, fileData.get(i).toString().replace(";", "") + "Updated;");
			}

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
			// System.out.println(finalList.get(c));
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

		List<String> guiList = new ArrayList();

		// String[] actionArray = actionList.toArray(new String[actionList.size()]);
		System.out.println("action list is below");

		for (int i = 0; i < actionList.size(); i++) {
			guiList.add(actionList.get(i));
			String action = actionList.get(i).toString();
			if (action.contains("click")) {
				guiList.set(i, "click(\"element" + i + ".png\")\nwait(2)");
			} else if (action.contains("sendKeys")) {
				String update = action.replace("sendKeys ", "");
				guiList.set(i, "type(\"" + update + "\")\nwait(2)");
			} else if (action.contains("isDisplayed")) {
				String update = action.replace("isDisplayed ", "");
				guiList.set(i, "exists(\"element" + i + ".png\")\nwait(2)");
			} else if (action.contains("getText")) {
				String update = action.replace("getText ", "");
				guiList.set(i, "exists(\"" + update + "\")\nwait(2)");
			}
		}

		for (int i = 0; i < guiList.size(); i++) {
			System.out.println(guiList.get(i));
		}

		// System.out.println("action list has elements: " + actionArray.length);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(textFile))) {
			for (String str : guiList) {
				bw.write(str);
				bw.newLine();

			}
		} catch (NullPointerException n) {

		}

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
					text = StringUtils.substringBetween(lineCode, "sendKeys(", ")")
							.replaceAll("^\"+|\"+$", "");
					return act + " " + text;
				} else if (act.equals("isDisplayed")) {
					String assertText = "";
					assertText = StringUtils.substringBetween(lineCode, "text,'", "'")
							.replaceAll("^\"+|\"+$", "");
					return act + " " + assertText;
				} else if (act.equals("getText")) {
					String assertEquals = "";
					assertEquals = StringUtils.substringBetween(lineCode, "getText(),\"", "\"")
							.replaceAll("^\"+|\"+$",
							"");
					return act + " " + assertEquals;
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
			System.out.println(point);
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			System.out.println(eleWidth + "and" + eleHeight);
			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
					eleWidth, eleHeight);

			// resizing the image
			Image reImage = eleScreenshot.getScaledInstance(eleWidth / 3, eleHeight / 3,
					Image.SCALE_DEFAULT);
			eleScreenshot = new BufferedImage(eleWidth / 3, eleHeight / 3, 
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = eleScreenshot.createGraphics();
			g2d.drawImage(reImage, 0, 0, null);
			g2d.dispose();

			ImageIO.write(eleScreenshot, "png", scrFile);

			String path = destSikuliFolder + "\\" + imageName + "" + ".png";
			screenshotLocation = new File(path);
			FileUtils.copyFile(scrFile, screenshotLocation);

			System.out.println(screenshotLocation.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return screenshotLocation.toString();

	}

	private static int id = 0;

	public static int seqNum() {
		return ++id;
	}

}
