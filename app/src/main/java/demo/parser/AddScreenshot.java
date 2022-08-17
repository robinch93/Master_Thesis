package demo.parser;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;;

public class AddScreenshot {

	static String cwd = System.getProperty("user.dir");

	// to read the input file test scripts for different mobile applications
	public static List<List<String>> readFile(String filePath) throws IOException {

		List<String> elementList = new ArrayList<String>(), actionList = new ArrayList<String>(),
				fileData = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

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
			return Arrays.asList(fileData, elementList, actionList);
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

		if (lineCode.contains("driver.find")) {
			String act = StringUtils.substringBetween(lineCode, ").", "(");
			if (act.length() != 0) {
				if (act.equals("sendKeys")) {
					String text = "";
					text = StringUtils.substringBetween(lineCode, "sendKeys(", ")").replaceAll("^\"+|\"+$", "");
					return act + " " + text;
				} else if (act.equals("isDisplayed")) {
					String assertText = "";
					assertText = StringUtils.substringBetween(lineCode, "text,'", "'").replaceAll("^\"+|\"+$", "");
					return act + " " + assertText;
				} else {
					return act;
				}
			}
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	public static String elementScreenshot(String inputFileName, AppiumDriver driver, MobileElement ele,
			String imageName)
			throws InterruptedException, IOException {

		List<Object> filepaths = UpdateScript.getFilePath(inputFileName);
		String destSikuliFolder = filepaths.get(2).toString().replace(".java", "");
		File screenshotLocation = null;
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			BufferedImage fullImg = ImageIO.read(scrFile);
			// Get the location of element on the page
			Point point = ele.getLocation();
			// System.out.println(point);
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// System.out.println(eleWidth + "and" + eleHeight);
			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);

			// resizing the image
			Image reImage = eleScreenshot.getScaledInstance(eleWidth / 3, eleHeight / 3, Image.SCALE_DEFAULT);
			eleScreenshot = new BufferedImage(eleWidth / 3, eleHeight / 3, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = eleScreenshot.createGraphics();
			g2d.drawImage(reImage, 0, 0, null);
			g2d.dispose();

			ImageIO.write(eleScreenshot, "png", scrFile);

			String path = destSikuliFolder + "/" + imageName + "" + ".png";
			screenshotLocation = new File(path);
			FileUtils.copyFile(scrFile, screenshotLocation);

			// System.out.println(screenshotLocation.toString());

		} catch (IOException e) {
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
