package demo.parser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UpdateScript {

    static String cwd = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException, InterruptedException {
        updateFolderScripts("omni");
        // updateFileScript("OmniNotesAppium4.java");
    }

    public static void updateFileScript(String fileName) throws IOException, InterruptedException {
        List<Object> filepaths = getFilePath(fileName);
        String inputFilePath = filepaths.get(0).toString();
        List<List<String>> content = AddScreenshot.readFile(inputFilePath);
        List<String> data = content.get(0);
        List<String> elementList = content.get(1);
        // System.out.println(elementList);
        List<String> actionList = content.get(2);
        Write.writeUpdatedScripts(data, elementList, fileName, inputFilePath, filepaths.get(1).toString());
        Write.writeToSikuliFile(actionList, fileName, inputFilePath, filepaths.get(2).toString());
    }

    // This method updates the scripts iterting over all files in the folder
    public static void updateFolderScripts(String app) throws IOException, InterruptedException {
        // String app = "calculator";
        String cwd = System.getProperty("user.dir");
        app = app.toLowerCase();
        String directory;
        switch (app) {
            case "calculator":
                directory = cwd + "/app/src/test/java/demo/apps/calculatorApp/calculatorAppInputScripts/";
                break;
            case "omninotes":
            case "omni":
                directory = cwd + "/app/src/test/java/demo/apps/omniNotesApp/omniNotesAppInputScripts/";
                break;
            case "unitconverter":
            case "unit":
            case "converter":
                directory = cwd + "/app/src/test/java/demo/apps/unitConverterApp/unitConverterAppInputScripts/";
                break;
            default:
                directory = "invalid app name";
                break;
        }

        File dir = new File(directory);
        // System.out.println(directory);
        // System.out.println(dir);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                // System.out.println("---------------");
                // System.out.println(child.getName());
                // System.out.println("---------------");
                updateFileScript(child.getName());
            }
        } else {
            System.out.println("Directory" + dir.toString() + "does not exist");
        }
    }

    // This method returns the absolute file path for updated scripts and sikuli
    // folder within the project for the file
    public static List<Object> getFilePath(String fileName) {
        String inputFilePath = "";
        String outputFolderPath = "";
        String sikuliFolderPath = "";

        String file = fileName.toLowerCase();
        if (file.contains("calculator")) {
            inputFilePath = cwd
                    + "/app/src/test/java/demo/apps/calculatorApp/calculatorAppInputScripts/";
            outputFolderPath = cwd
                    + "/app/src/test/java/demo/apps/calculatorApp/calculatorAppUpdatedScripts/";
            sikuliFolderPath = cwd
                    + "/app/src/test/java/demo/apps/calculatorApp/calculatorAppSikuliScripts/";
        } else if (file.contains("omni") || file.contains("omninotes") || file.contains("notes")) {
            inputFilePath = cwd
                    + "/app/src/test/java/demo/apps/omniNotesApp/omniNotesAppInputScripts/";
            outputFolderPath = cwd
                    + "/app/src/test/java/demo/apps/omniNotesApp/omniNotesAppUpdatedScripts/";
            sikuliFolderPath = cwd
                    + "/app/src/test/java/demo/apps/omniNotesApp/omniAppSikuliScripts/";
        } else if (file.contains("unit") || file.contains("unitconverter") || file.contains("converter")) {
            inputFilePath = cwd
                    + "/app/src/test/java/demo/apps/unitConverterApp/unitConverterAppInputScripts/";
            outputFolderPath = cwd
                    + "/app/src/test/java/demo/apps/unitConverterApp/unitConverterAppUpdatedScripts/";
            sikuliFolderPath = cwd
                    + "/app/src/test/java/demo/apps/unitConverterApp/unitConverterAppSikuliScripts/";
        } else {
            System.out.println("No such file exists");
        }

        inputFilePath = inputFilePath + fileName;
        fileName = fileName.replace(".java", "");
        sikuliFolderPath = sikuliFolderPath + fileName + ".sikuli";

        return Arrays.asList(inputFilePath, outputFolderPath, sikuliFolderPath);
    }

}
