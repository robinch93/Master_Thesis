package parser_program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.worker.Worker;
import com.google.common.net.HostSpecifier;

public class locator_reader {

	private static Row row;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, Exception, IOException {
		
//		FileOutputStream matches = new FileOutputStream("parameters.txt");
		String path = "C:\\Users\\Robin Chaudhary\\eclipse-workspace\\parser_program\\src\\parser_program\\AppiumTest.java";
		BufferedReader br = new BufferedReader(new FileReader(path));  
		StringBuilder  stringBuilder = new StringBuilder();
		String         ls = System.getProperty("line.separator"); 	
		String pathOutput = System.getProperty("user.dir");
		pathOutput += "\\output.xlsx";
		FileOutputStream fos = new FileOutputStream(pathOutput);	
		Workbook workbook = new XSSFWorkbook();	
		Sheet sheet = workbook.createSheet("Sheet1");
//		Sheet sheet = workbook.getSheet("Sheet1");	
		int noRows= sheet.getLastRowNum();
		Row header = sheet.createRow(0);
		String[] headerName = { "code line", "Locator","Container","Attribute","Value", "Action"};
		
		// to creat heading for the column names
		for(int i=0; i< headerName.length; i++) {
			header.createCell(i).setCellValue(headerName[i]);
		}
		
		List<String> codelineList= new LinkedList<String>(), locatorList = new LinkedList<String>();
		List<String> containerList= new LinkedList<String>() , attributeList= new LinkedList<String>();
		List<String> valueList= new LinkedList<String>(), actionList = new LinkedList<String>();
		
		int count = 0;
		String line = "";
		while((line = br.readLine()) != null) {	
			if(!line.equals("")) {
			 if(line.contains("driver.find")) {
			   if(line.startsWith("//") == false) {   // to ignore the lines which are commented in file. 
				line = line.trim();
//				line = line.replaceAll("\\s", "");
				stringBuilder.append(line);
			    stringBuilder.append(ls);
			    try {
			    	
//			    Thread.sleep(100);
			    String locator = locatorType(line);
			    String container = containerType(line);
			    String attribute = attributeType(line);
			    String value = valueType(line);  
			    String action = actionType(line);
			    
			    count = count +1;
			    
			    // to add all the values line by line into the respective linked list. 
			    codelineList.add(line);
			    locatorList.add(locator);
			    containerList.add(container);
			    attributeList.add(attribute);
			    valueList.add(value);
			    actionList.add(action);
			      
			    System.out.println(count + ": " + line);
			    System.out.println(locator  + " --  " + locator);
			    
			    }catch(NullPointerException e) {
			    	
			    }
			 }
			}
		  }
		}
		
		String[] codelineArray = codelineList.toArray(new String[codelineList.size()]);
		String[] locatorArray = locatorList.toArray(new String[locatorList.size()]);
		String[] containerArray = containerList.toArray(new String[containerList.size()]);
		String[] attributeArray = attributeList.toArray(new String[attributeList.size()]);
		String[] valueArray = valueList.toArray(new String[valueList.size()]);
		String[] actionArray = actionList.toArray(new String[actionList.size()]);
		
		for(int i=2; i< count; i++) {
			Row content = sheet.createRow(i);
			content.createCell(0).setCellValue(codelineArray[i]);	
			content.createCell(1).setCellValue(locatorArray[i]);
			content.createCell(2).setCellValue(containerArray[i]);	
			content.createCell(3).setCellValue(attributeArray[i]);
			content.createCell(4).setCellValue(valueArray[i]);	
			content.createCell(5).setCellValue(actionArray[i]);
		}
		
		for(int i=0; i< headerName.length; i++) {
			sheet.autoSizeColumn(i);
		}
		
		workbook.write(fos);
		fos.close();
		br.close();	
	}
	
	// this method extract the locator type used by the driver. 
	// few examples are: driver.findElementByXPath,  driver.findElementById 
	public static String locatorType(String locator) {
		int count = 0;
			if(locator.contains("findElementBy")) {
				String loc_1 = StringUtils.substringBetween(locator, "driver.findElementBy", "(");
				if(loc_1.length() != 0 ) {
					count = count + 1;
					return loc_1;
				}
			}else if(locator.contains("findElement(")){
				String loc_2 = StringUtils.substringBetween(locator, "driver.findElement(By.", "(");
				if(loc_2.length() != 0) {
					return loc_2;
					}
			}
				
		return null;
	}
	
	// this method extracts the container. eg. div, span, input, button
	public static String containerType(String container) {
		String contain = "";
		int count = 0;
		
			contain = StringUtils.substringBetween(container, "//", "[").replaceAll("[^A-Za-z]+", "");		
			if(contain.length() !=  0) {
				count = count + 1;				
				return contain;
				}
			return null;
	}

	// this method extracts the attribute from the string. eg. id, text  after @, before =', before ,'
		public static String attributeType(String attribute) {
			int count = 0;
			
				if(attribute.contains("@")) {
					String type_1 = StringUtils.substringBetween(attribute, "@","=");
					if(type_1.length() != 0 ) {
						count = count + 1;
						return type_1;
					}
				}
				if(attribute.contains("contains(")) {
					String type_2 = StringUtils.substringBetween(attribute, "contains(","()");
					if(type_2.length() != 0) {
						return type_2;
						}
				}
			return null;
		}
	
	// this method extracts the value from the string. eg. CERCA , PERSONE, Cerca persona
		public static String valueType(String value) {
			int count = 0;
			
				if(value.contains("@")) {
					String type_1 = StringUtils.substringBetween(value, "'","'");
					if(type_1.length() != 0 ) {
						count = count + 1;
						return type_1;
					}
				}
				if(value.contains("contains(")) {
					String type_2 = StringUtils.substringBetween(value, "'","'");
					if(type_2.length() != 0) {
						return type_2;
						}
				}
				
				Pattern p = Pattern.compile("\"([^\"]*)\"");
				
				if(value.contains("driver.findElement")) {
					String type_4 = StringUtils.substringBetween(value, "driver.findElement",")");
					Matcher m = p.matcher(type_4);
					while (m.find()) {
					  return m.group(1);
					}
				}
				
//				if(value.contains("driver.findElementByXPath")) {
//					String type_4 = StringUtils.substringBetween(value, "driver.findElement",")");
//					Matcher m = p.matcher(type_4);
//					while (m.find()) {
//					  return m.group(1);
//					}
//				}
			
		return null;
		}
		
	// this method extracts the action performed from the string. eg. input text, click
		public static String actionType(String action) {
			String to = StringUtils.substringBetween(action, ").", "()");		
			if(to.length() != 0) {
				return to;	
				}
			return null;			
		}
		
	// this method sends the input to the element eg. robin - for input text name field. (send keys) 
	public String inputValue(String text) {
	String [] words = text.split(" ");
									 
	return text;
	}
		
}
