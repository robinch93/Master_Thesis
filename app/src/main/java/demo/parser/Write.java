package demo.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Write {

    public Write() {
    }

    // to write an updated file for each script by adding take screenshot action
    // after every event
    // to extract actions from the input script and write them to a sikuli script
    public static void writeUpdatedScripts(List<String> fileData, List<String> elementList, String inputFileName,
            String inputFilePath,
            String updatedFolderPath)
            throws IOException, InterruptedException {

        CreateDirectory(updatedFolderPath);
        String outputFileName = inputFileName.replace(".java", "") + "Updated.java";
        String destination = updatedFolderPath + outputFileName;

        while (elementList.remove(null)) {
        }

        String[] elementArray = elementList.toArray(new String[elementList.size()]);

        List<String> location = new ArrayList<String>();
        List<String> driverLineList = new ArrayList<String>();
        int j = 0, k = 0;
        // System.out.println(fileData);
        // System.out.println(fileData.get(0).length());
        // System.out.println(fileData.get(1).getClass());

        String fileName = inputFileName.replace(".java", "");

        // add lines to location list.
        for (int i = 0; i < fileData.size(); i++) {
            location.add(fileData.get(i));

            if (fileData.get(i).contains("public class " + inputFileName.replace(".java", ""))) {
                location.set(i, "public class " + outputFileName.replace(".java", "") + " {");
            }

            if (fileData.get(i).contains("package ")) {
                location.set(i, fileData.get(i).toString().replace("Input", "Updated"));
            }

            if (fileData.get(i).contains("driver.find")) {
                if (!fileData.get(i).startsWith("//")) {
                    driverLineList.add(fileData.get(i));
                    for (j = k; j < elementArray.length; j++) {

                        location.add("\t\tMobileElement " + "element" + k + " = " + "driver.find" + elementArray[j]
                                + ");" + "\n" + "\t\tAddScreenshot.elementScreenshot(\"" + fileName + "\", driver,"
                                + " element" + k
                                + " ,"
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
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
            for (String str : finalList) {
                bw.write(str);
                bw.newLine();

            }
        }

    }

    // To write action list in sikuli txt file
    public static void writeToSikuliFile(List<String> actionList, String inputFileName, String inputFilePath,
            String sikuliFolderPath)
            throws IOException, InterruptedException {

        // System.out.println(sikuliFolderPath);
        CreateDirectory(sikuliFolderPath);
        String sikuliFileName = inputFileName.replace(".java", "") + "sikuli.txt";
        String textFile = sikuliFolderPath + "/" + sikuliFileName;

        new File(sikuliFolderPath).mkdirs();

        while (actionList.remove(null)) {
        }

        List<String> guiList = new ArrayList<String>();

        for (int i = 0; i < actionList.size(); i++) {
            guiList.add(actionList.get(i));
            String action = actionList.get(i).toString();
            if (action.contains("click")) {
                guiList.set(i, "click(\"element" + i + ".png\")");
                // guiList.add(i + 1, "wait(2)");
            } else if (action.contains("sendKeys")) {
                String update = action.replace("sendKeys ", "");
                guiList.set(i, "type(\"" + update + "\")");
                // guiList.add(i + 1, "wait(2)");
            } else if (action.contains("isDisplayed")) {
                String update = action.replace("isDisplayed ", "");
                guiList.set(i, "exists(\"" + update + "\")");
                // guiList.add(i + 1, "wait(2)");
            }
        }

        // for (int i = 0; i < guiList.size(); i++) {
        // System.out.println(guiList.get(i));
        // }
        List<String> finalList = new ArrayList<String>();
        for (int i = 0; i < guiList.size(); i++) {
            finalList.add(guiList.get(i));
            if (i < guiList.size() - 1) {
                finalList.add("wait(2)");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(textFile))) {
            for (String str : finalList) {
                bw.write(str);
                bw.newLine();

            }
        } catch (NullPointerException n) {

        }
    }

    /** Creates parent directories if necessary. Then returns file */
    private static File CreateDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.exists())
            dir.mkdirs();
        return new File(directory + "/");
    }
}
