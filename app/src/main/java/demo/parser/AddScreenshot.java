package demo.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AddScreenshot {

	static String cwd = System.getProperty("user.dir");

	static List<String> elementList = new ArrayList<String>();
	static List<String> actionList = new ArrayList<String>();

	public static void main(String[] args) throws InterruptedException, IOException {
		String fileName = "CalculatorAppium1.java";
		List<Object> filepaths = getFilePath(fileName);
		// System.out.println();
		List<String> data = readFile(filepaths.get(0).toString());
		writeToUpdatedScripts(data, fileName, filepaths.get(1).toString(),
				filepaths.get(2).toString());
		writeToSikuliFile(filepaths.get(3).toString(), filepaths.get(4).toString());
	}

	public static List<Object> getFilePath(String fileName) throws IOException {
		String inputFilePath = "";
		String outputFolderPath = "";
		String outputFileName = "";
		String sikuliFolderPath = "";
		String sikuliFileName = "";

		if (fileName.contains("Calculator")) {
			inputFilePath = cwd
					+ "/app/src/test/java/demo/apps/calculatorApp/calculatorAppInputScripts/";
			outputFolderPath = cwd
					+ "/app/src/test/java/demo/apps/calculatorApp/calculatorAppUpdatedScripts/";
			sikuliFolderPath = cwd
					+ "/app/src/test/java/demo/apps/calculatorApp/calculatorAppSikuliScripts/";
		} else if (fileName.contains("Omni")) {
			inputFilePath = cwd
					+ "/app/src/test/java/demo/apps/omniNotesApp/omniNotesAppInputScripts/";
			outputFolderPath = cwd
					+ "/app/src/test/java/demo/apps/omniNotesApp/omniNotesAppUpdatedScripts/";
			sikuliFolderPath = cwd
					+ "/app/src/test/java/demo/apps/calculatorApp/omniAppSikuliScripts/";
		} else if (fileName.contains("Unit")) {
			inputFilePath = cwd
					+ "/app/src/test/java/demo/apps/unitConverterApp/unitConverterAppInputScripts/";
			outputFolderPath = cwd
					+ "/app/src/test/java/demo/apps/unitConverterApp/unitConverterAppUpdatedScripts/";
			sikuliFolderPath = cwd
					+ "/app/src/test/java/demo/apps/calculatorApp/unitConverterAppSikuliScripts/";
		} else {
			System.out.println("No such file exists");
		}

		inputFilePath = inputFilePath + fileName;
		outputFileName = fileName.replace(".java", "Updated.java");
		sikuliFileName = fileName.replace(".java", "sikuli.txt");

		return Arrays.asList(inputFilePath, outputFolderPath, outputFileName, sikuliFolderPath, sikuliFileName);
	}

	// to read the input file test scripts for different mobile applications
	public static List<String> readFile(String filePath) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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

	// to write an updated file for each script by adding take screenshot action
	// after every event
	// to extract actions from the input script and write them to a sikuli script
	public static void writeToUpdatedScripts(List<String> fileData, String inputFileName, String updatedFolderPath,
			String outputFileName)
			throws IOException, InterruptedException {

		String destination = updatedFolderPath + outputFileName;

		while (elementList.remove(null)) {
		}

		String[] elementArray = elementList.toArray(new String[elementList.size()]);

		List<String> location = new ArrayList<String>();
		List<String> driverLineList = new ArrayList<String>();
		int j = 0, k = 0;
		System.out.println(fileData.get(1).length());
		System.out.println(fileData.get(1).getClass());
		int first_empty_line = fileData.indexOf("");
		// add lines to location list.
		for (int i = 0; i < fileData.size(); i++) {
			location.add(fileData.get(i));

			if (fileData.get(i).contains("public class " + inputFileName.replace(".java", ""))) {
				location.set(i, "public class " + outputFileName.replace(".java", "") + " {");
			}

			if (fileData.get(i).contains("package ")) {
				location.set(i, fileData.get(i).toString().replace("Input", "Updated"));
			}

			// if (i == first_empty_line) {
			// location.set(i, "import demo.parser.AddScreenshot;");
			// }

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

		// System.out.println("Number of lines containing driver.find in source file: "
		// + driverLineList.size());

		String[] driverLine = driverLineList.toArray(new String[driverLineList.size()]);
		List<String> finalList = new ArrayList<String>();
		j = 0;
		k = 0;
		for (int m = 0; m < location.size(); m++) {
			finalList.add(location.get(m));

			if (location.get(m).contains("package")) {
				finalList.add(m + 1, "import demo.parser.AddScreenshot;");
			}

			if (location.get(m).contains("AddScreenshot")) {
				for (j = k; j < driverLine.length; j++) {
					finalList.add(driverLine[j] + "\n");
					k++;
					break;
				}
			}
		}

		List<String> counted = new ArrayList<String>();
		for (int c = 0; c < finalList.size(); c++) {
			if (finalList.get(c).contains("driver.find")) {
				if (!finalList.get(c).startsWith("//")) {
					counted.add(finalList.get(c));
				}
			}
			// System.out.println(finalList.get(c));
		}

		// System.out.println("Number of lines containing driver.find in destination
		// file: " + counted.size());

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
			for (String str : finalList) {
				bw.write(str);
				bw.newLine();

			}
		}

	}

	public static void writeToSikuliFile(String sikuliFolderPath, String sikuliFileName)
			throws IOException, InterruptedException {

		String textFile = sikuliFolderPath + sikuliFileName;

		new File(sikuliFolderPath).mkdirs();

		while (actionList.remove(null)) {
		}

		List<String> guiList = new ArrayList<String>();

		for (int i = 0; i < actionList.size(); i++) {
			guiList.add(actionList.get(i));
			String action = actionList.get(i).toString();
			if (action.contains("click")) {
				guiList.set(i, "click(\"element" + i + ".png\")");
			} else if (action.contains("sendKeys")) {
				String update = action.replace("sendKeys ", "");
				guiList.set(i, "type(\"" + update + "\")");
			} else if (action.contains("isDisplayed")) {
				String update = action.replace("isDisplayed ", "");
				guiList.set(i, "exists(\"" + update + "\")");
			}
		}

		// for (int i = 0; i < guiList.size(); i++) {
		// System.out.println(guiList.get(i));
		// }

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(textFile))) {
			for (String str : guiList) {
				bw.write(str);
				bw.newLine();

			}
		} catch (NullPointerException n) {

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

		return act;
	}

	@SuppressWarnings("rawtypes")
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
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);

			// resizing the image
			Image reImage = eleScreenshot.getScaledInstance(eleWidth / 3, eleHeight / 3, Image.SCALE_DEFAULT);
			eleScreenshot = new BufferedImage(eleWidth / 3, eleHeight / 3, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = eleScreenshot.createGraphics();
			g2d.drawImage(reImage, 0, 0, null);
			g2d.dispose();

			ImageIO.write(eleScreenshot, "png", scrFile);

			String path = destSikuliFolder + "\\" + imageName + "" + ".png";
			screenshotLocation = new File(path);
			FileUtils.copyFile(scrFile, screenshotLocation);

			System.out.println(screenshotLocation.toString());

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
