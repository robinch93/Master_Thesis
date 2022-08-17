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

    /*
     * To write an updated file for each script by adding take screenshot action
     * after every event to extract actions from the input script and write them to
     * a sikuli script
     */
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
        int n = 1, m = 0;

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
                if (!fileData.get(i).contains("sendKeys") && !fileData.get(i).contains("clear")
                        && !fileData.get(i).startsWith("//")) {
                    driverLineList.add(fileData.get(i));
                    location.add("\t\tMobileElement " + "element" + n + " = " + "driver.find" + elementArray[m]
                            + ");" + "\n" + "\t\tAddScreenshot.elementScreenshot(\"" + fileName + "\", driver,"
                            + " element" + n
                            + " ,"
                            + " \"element" + n + "\");");
                    location.remove(i);
                    n++;
                }
                m++;
            }
        }

        String[] driverLine = driverLineList.toArray(new String[driverLineList.size()]);
        List<String> finalList = new ArrayList<String>();
        int j = 0, k = 0;
        for (int f = 0; f < location.size(); f++) {
            finalList.add(location.get(f));

            if (location.get(f).contains("package")) {
                finalList.add(f + 1, "import demo.parser.AddScreenshot;");
            }

            if (location.get(f).contains("AddScreenshot")) {
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
        String sikuliFileName = inputFileName.replace(".java", "") + "sikuli.py";
        String textFile = sikuliFolderPath + "/" + sikuliFileName;

        new File(sikuliFolderPath).mkdirs();

        while (actionList.remove(null)) {
        }

        List<String> guiList = new ArrayList<String>();
        int j = 1;
        for (int i = 0; i < actionList.size(); i++) {
            guiList.add(actionList.get(i));
            String action = actionList.get(i).toString();
            if (action.contains("click")) {
                guiList.set(i, "click(\"element" + j + ".png\")");
                j++;
            } else if (action.contains("sendKeys")) {
                String update = action.replace("sendKeys ", "");
                guiList.set(i, "type(\"" + update + "\")");
            } else if (action.contains("isDisplayed")) {
                guiList.set(i, "exists(\"element" + j + ".png\")");
                j++;
            } else if (action.contains("clear")) {
                guiList.set(i, "type('a',Key.CMD) \ntype(Key.DELETE)");
            }
        }

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
