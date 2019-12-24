package tests;

import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTest {
	
	
	
	
	
	private static DesiredCapabilities caps;
	
	
	
	private static void test000_prova() throws InterruptedException {
		
		//Instantiate Appium Driver
		try {
			
			setDesiredCapabilities() ;

				AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
				driver.context("NATIVE_APP");
				Thread.sleep(3000);

				System.out.println("try");

				
				List<WebElement> elements = new ArrayList<WebElement>();;
				
				String pageSrc = driver.getPageSource();		

				//System.out.println(pageSrc);
				
				
				
				
				
				System.out.println("clicking on menu search");
				driver.findElementById("menu_search").click();
				
		//		driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/menu_search']").click();

				
				//JavascriptExecutor executor = (JavascriptExecutor) driver;
				//Object object=executor.executeScript("var result = []; ", elements.toArray());
				
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		System.out.println("try2");

		
		System.out.println("test 1 ok");

		
	}

	
	private static void test1_personewrong() throws InterruptedException {
		
		//Instantiate Appium Driver
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
				
				
				
				driver.context("WEBVIEW_it.polito.politoapp");
				
				Thread.sleep(5000);
				driver.findElementByXPath("//div[contains(text(), 'PERSONE')]").click();
				
				Thread.sleep(500);
				
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'Cerca persona')]").isDisplayed());

				driver.findElementByXPath("//input[@id='tb_name']").sendKeys("a");
				
				
				driver.findElementById("tb_name").sendKeys("a");
				
				driver.findElement(By.id("tb_name")).sendKeys("a");
				
				//search with id "tb_name"
				//type instruction
				//parameter = "a"
				
				
				driver.findElementByXPath("//span[contains(text(), 'CERCA')]").click();
				//search with text "CERCA"
				//click instruction
				//parameter = NULL
				Thread.sleep(3000);
				
				assertTrue(driver.findElementByXPath("//div[contains(text(), 'Per favore, inserisci almeno tre caratteri per il nome/cognome.')]").isDisplayed());

				
				Thread.sleep(3000);
				driver.findElementByXPath("//button[contains(text(), 'OK')]").click();
				Thread.sleep(500);
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
				
				assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());


		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("test 1 ok");

		
	}
	
	private static void test2_personeright() throws InterruptedException {
		
		//Instantiate Appium Driver
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

				driver.context("WEBVIEW_it.polito.politoapp");
				
				Thread.sleep(2000);

				driver.findElementByXPath("//div[contains(text(), 'PERSONE')]").click();
				
				Thread.sleep(500);
				
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'Cerca persona')]").isDisplayed());

				
				driver.findElementByXPath("//input[@id='tb_name']").sendKeys("bar");
				driver.findElementByXPath("//span[contains(text(), 'CERCA')]").click();

				Thread.sleep(5000);
				
				
				driver.findElementByXPath("//ons-list-item[contains(text(), 'Elena Maria')]").click();
				
				Thread.sleep(2000);
							
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'Elena Maria BARALIS')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'Dipartimento di Automatica e Informatica (DAUIN)')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'elena.baralis@polito.it')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), '0110907075')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'INSERISCI IN RUBRICA')]").isDisplayed());

				
				Thread.sleep(2000);
				
				
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

				Thread.sleep(500);
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

				Thread.sleep(500);
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

				



				assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());




		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("test 2 ok");

	}
	
	
	private static void test3_contatti() throws InterruptedException {
		//Instantiate Appium Driver
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
				
			
				driver.context("WEBVIEW_it.polito.politoapp");
				
				Thread.sleep(4000);

				driver.findElementByXPath("//div[contains(text(), 'GESTIONE')]").click();

				
				Thread.sleep(2000);

				Thread.sleep(500);
				
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'SEGNALA EMERGENZA')]").isDisplayed());

				assertTrue(driver.findElementByXPath("//*[contains(text(), 'Gestione emergenze')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'Nessuna risposta?')]").isDisplayed());

				
				driver.findElementByXPath("//*[contains(text(), 'DOVE?')]").click();
				
				
				Thread.sleep(2000);
				
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'TO - Sede Centrale')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'TO - Valentino')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'TO - via Morgari')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'TO - Lingotto')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'TO - Mirafiori')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'ALESSANDRIA')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'BIELLA')]").isDisplayed());
				assertTrue(driver.findElementByXPath("//*[contains(text(), 'MONDOVI')]").isDisplayed());

				driver.findElementByXPath("//*[contains(text(), 'TO - Sede Centrale')]").click();
				
				

				
				//aggiungere qua verifica in ambiente native_android.
				
				HashSet<String> contexts = (HashSet<String>) driver.getContextHandles();
				for (String s: contexts) { System.out.println(s); }

				
				//COME TESTARE SCHERMATA DI CHIAMATA? VEDERE CON I LOCATOR DI UIAUTOMATOR
				/*
				driver.findElement(By.xpath("//*[contains(text(), 'Create new contact')]"));
				driver.findElement(By.xpath("//*[contains(text(), 'Add to a contact')]"));
				driver.findElement(By.xpath("//*[contains(text(), 'Send SMS')]"));
				driver.findElement(By.xpath("//*[contains(text(), '090102')]"));
				*/


				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

				Thread.sleep(500);
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

				Thread.sleep(500);
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

				Thread.sleep(500);

				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));


				Thread.sleep(2000);

				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
				Thread.sleep(500);
				
				assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());




		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		
		System.out.println("test 3 ok");

		
	}
	
	
	
	private static void test4_segnalaproblema() throws InterruptedException, MalformedURLException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		
		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);

		driver.findElementByXPath("//*[contains(text(), 'SEGNALA')]").click();
		
		Thread.sleep(2000);
		
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Segnala problema')]").isDisplayed());		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'INVIA')]").isDisplayed());

		driver.findElementByXPath("//*[contains(text(), 'seleziona il tipo di problema...')]").click();

		Thread.sleep(500);
		
		driver.findElementByXPath("//*[contains(text(), 'App')]").click();
		
		Thread.sleep(500);
		
		driver.findElementByXPath("//*[@placeholder='Descrivi il problema...']").sendKeys("aaa");
		
		
		Thread.sleep(3000);
		

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());


		
		System.out.println("test 4 ok");

	}
	
	
	
	private static void test5_bibliotecasearchauthor() throws MalformedURLException, InterruptedException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		
		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);

		driver.findElementByXPath("//*[contains(text(), 'BIBLIOTECA')]").click();
		
		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Biblioteca')]").isDisplayed());
		driver.findElementByXPath("//*[@placeholder='autore']").sendKeys("Sommerville");

		driver.findElementByXPath("//*[contains(text(), 'CERCA')]").click();

		Thread.sleep(2000);
		
		driver.findElementByXPath("//*[text()='Software engineering']").click();
		
		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[text()='Software engineering' and @class='titolo ng-binding']").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Addison- Wesley')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[text()='1995' and @class='anno ng-binding ng-scope']").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Autore:')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[text()='Sommerville, Ian' and @class='ng-binding ng-scope']").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Formato:')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'xvi, 742 p. ; 24 cm')]").isDisplayed());


		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(500);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(500);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(500);

		
		assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());


		
		System.out.println("test 5 ok");

	}
	
	
	private static void test6_bibliotecasearchtitleyear() throws InterruptedException, MalformedURLException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		
		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);

		driver.findElementByXPath("//*[contains(text(), 'BIBLIOTECA')]").click();
		
		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Biblioteca')]").isDisplayed());
		driver.findElementByXPath("//*[@placeholder='titolo']").sendKeys("Chemical");
		driver.findElementByXPath("//*[@placeholder='anno']").sendKeys("2019");

		driver.findElementByXPath("//*[contains(text(), 'CERCA')]").click();

		Thread.sleep(4000);
		
		driver.findElementByXPath("//*[text()=\"Perry's chemical engineers' handbook\"]").click();
		
		Thread.sleep(4000);
		
		assertTrue(driver.findElementByXPath("//*[text()=\"Perry's chemical engineers' handbook\" and @class='titolo ng-binding']").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'McGraw-Hill Education')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[text()='2019' and @class='anno ng-binding ng-scope']").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Autori:')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[text()='Green, Don W.' and @class='ng-binding ng-scope']").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Formato:')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), '1 v. (varie sequenze) ; 26 cm')]").isDisplayed());


		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(500);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(500);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(500);

		
		assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());

		System.out.println("test 6 ok");


		
	}
	
	private static void test7_notifiche() throws InterruptedException, MalformedURLException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		
		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);

		
		driver.findElementByXPath("//div[@class='campanellaNotif ng-scope']").click();
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Messaggi')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Al momento non sono presenti messaggi.')]").isDisplayed());
		
		
		
		
		//CLICK SU CAMPANELLA
		
		//CHECK DEL TESTO SPECIFICO
		
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		
		assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());

		
		System.out.println("test 7 ok");

	}
	
	
	private static void test8_studentlogin() throws InterruptedException, MalformedURLException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);

		driver.findElementByXPath("//*[@class='c_sign ng-scope']").click();

		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'LOGIN')]").isDisplayed());
		driver.findElementByXPath("//*[@placeholder='user name']").sendKeys("s231479");
		driver.findElementByXPath("//*[@placeholder='password']").sendKeys("fVazquez20");
		
		driver.findElementByXPath("//*[contains(text(), 'ACCEDI')]").click();

		Thread.sleep(15000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Riccardo COPPOLA')]").isDisplayed());

		System.out.println("test 8 ok");

	}
	
	
	private static void test9_caricodidattico() throws InterruptedException, MalformedURLException {
		
		//presuppone login effettuato
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		
		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(5000);

		driver.findElementByXPath("//*[contains(text(), 'CARICO')]").click();
		
		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Carico didattico')]").isDisplayed());

		assertTrue(driver.findElementByXPath("//*[contains(text(), 'The new Internet Society')]").isDisplayed());
		
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(2000);
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Riccardo COPPOLA')]").isDisplayed());


		System.out.println("test 9 ok");

		
	}
	
	private static void test10_libretto() throws InterruptedException, MalformedURLException {
		

		//presuppone login effettuato
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(5000);

		driver.findElementByXPath("//*[contains(text(), 'LIBRETTO')]").click();
		
		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Libretto')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Empirical methods in software')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Project management')]").isDisplayed());

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(2000);
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Riccardo COPPOLA')]").isDisplayed());

		System.out.println("test 10 ok");


	}
	
	
	
	private static void test11_logout() throws InterruptedException, MalformedURLException {
		
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);
		
	
		driver.findElementByXPath("//*[@class='fa fa-power-off ng-scope']").click();

		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Sei sicuro di voler effettuare il logout?')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[text()='Attenzione']").isDisplayed());
		driver.findElementByXPath("//*[contains(text(), 'OK')]").click();

		
		Thread.sleep(2000);

		assertTrue(driver.findElementByXPath("//div[contains(text(), 'Politecnico')]").isDisplayed());

		

		System.out.println("test 11 ok");

		
	}
	
	
	private static void test12_loginteacher() throws InterruptedException, MalformedURLException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);

		driver.findElementByXPath("//*[@class='c_sign ng-scope']").click();

		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'LOGIN')]").isDisplayed());
		driver.findElementByXPath("//*[@placeholder='user name']").sendKeys("D38485");
		driver.findElementByXPath("//*[@placeholder='password']").sendKeys("fVazquez20");
		
		driver.findElementByXPath("//*[contains(text(), 'ACCEDI')]").click();

		
		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'RICCARDO COPPOLA')]").isDisplayed());

		System.out.println("test 12 ok");

		
		
	}
	
	
	private static void test13_incarichi() throws InterruptedException, MalformedURLException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(2000);

		driver.findElementByXPath("//*[contains(text(), 'INCARICHI')]").click();
		
		Thread.sleep(500);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Incarichi')]").isDisplayed());

		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Databases')]").isDisplayed());

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(500);
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'RICCARDO COPPOLA')]").isDisplayed());

		System.out.println("test 13 ok");

	}
	
	
	public static void test14_appelliesami() throws InterruptedException, MalformedURLException {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		
		driver.context("WEBVIEW_it.polito.politoapp");
		
		Thread.sleep(5000);

		driver.findElementByXPath("//*[contains(text(), 'APPELLI')]").click();
		
		Thread.sleep(2000);
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Appelli esami')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Object-oriented programming')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), '19/04/2019')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), '14:00')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'prenotati')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), '01SXPPT')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'SCRITTO')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'scade il 16/04/2019')]").isDisplayed());

		driver.findElementByXPath("//*[contains(text(), 'Object-oriented programming')]").click();
		
		
		Thread.sleep(5000);
		
		//SISTEMARE COME NEL TEST BIBLIOTECA (DOPPIO IDENTIFICATORE CLASSE+TEXT PRECISO)
		//assertTrue(driver.findElementByXPath("//*[contains(text(), 'INVIA PRESENZE')]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), \"Iscritti all'appello\")]").isDisplayed());
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Aggiungi studente')]").isDisplayed());

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(500);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(500);

		assertTrue(driver.findElementByXPath("//*[contains(text(), 'RICCARDO COPPOLA')]").isDisplayed());
		
		System.out.println("test 14 ok");

		
	}
	



	
	

	private static void test15_expandedsegnalaproblema() throws Exception {
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		Thread.sleep(10000);

		
		driver.context("WEBVIEW_it.polito.politoapp");
		



		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_UP));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

		driver.findElementByXPath("//*[contains(text(), 'SEGNALA')]").click();
		
		Thread.sleep(2000);
		
		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'Segnala problema')]").isDisplayed());		
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'INVIA')]").isDisplayed());

		driver.findElementByXPath("//*[contains(text(), 'seleziona il tipo di problema...')]").click();

		Thread.sleep(500);
		
		driver.findElementByXPath("//*[contains(text(), 'Logistico elettrico')]").click();
		
		driver.findElementByXPath("//*[@placeholder='Locale/luogo']").sendKeys("100");
		
		Thread.sleep(2000);
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(2000);
		assertTrue(driver.findElementByXPath("//*[contains(text(), 'RICCARDO COPPOLA')]").isDisplayed());

		System.out.println("test 15 ok");

		

		
	}
	
	
	private static DesiredCapabilities desiredCapabilities = null;
	
private static void setDesiredCapabilities() {
		
		// customize the code. 
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "My Phone");
		desiredCapabilities.setCapability("udid", "emulator-5556"); 			//Give Device ID of your mobile phone
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "7.1.1");
		desiredCapabilities.setCapability("appPackage", "it.feio.android.omninotes");
		desiredCapabilities.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");
		desiredCapabilities.setCapability("noReset", "true");					
		desiredCapabilities.setCapability("unicodeKeyboard", true);			//make the keyboard never appear
		desiredCapabilities.setCapability("resetKeyboard", true);

	}
	
	public static void main(String[] args) throws Exception {
		
	//	AppiumDriverLocalService   service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(0).usingDriverExecutable(new File("path to node")).withAppiumJS(new File("path to appium.js")));
//	       String service_url = service.getUrl().toString();
	//       service.start();

	//	service.Start();
		String adbPath=System.getenv("LOCALAPPDATA")+"\\Android\\Sdk\\platform-tools";

		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe", "/c\"", adbPath + "\\adb\" shell screencap -p /sdcard/screen.png");

		System.out.println(adbPath + "\\adb\" shell screencap -p /sdcard/screen.png");
		builder.redirectErrorStream(true);
		
		builder.directory(new File(adbPath));
		Process p = builder.start();

		//
		
		//Runtime runtime = Runtime.getRuntime();

		/*try {
			//runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
			//Thread.sleep(4000);
			driver = new AppiumDriverCustom<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
			//driver.context("NATIVE_APP");
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}*/

		
		/*
		//Set the Desired Capabilities
		caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "emulator-5556"); 			//Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		//caps.setCapability("appPackage", "it.polito.politoapp");
	//	caps.setCapability("appActivity", "it.polito.politoapp.MainActivity");
		caps.setCapability("appPackage", "it.feio.android.omninotes");
		caps.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");

		caps.setCapability("noReset", "true");					
		caps.setCapability("unicodeKeyboard", true);			//make the keyboard never appear
		caps.setCapability("resetKeyboard", true);


		
		*/
		
		System.out.println("CIAO");
		try { test000_prova(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 1 failed"); }

		//try { test1_personewrong(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 1 failed"); }
		//try { test2_personeright(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 2 failed"); }
		//try { test3_contatti(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 3 failed"); }
		//try { test4_segnalaproblema(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 4 failed"); }
		//try { test5_bibliotecasearchauthor(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 5 failed"); }
		//try { test6_bibliotecasearchtitleyear(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 6 failed"); }
		//try { test7_notifiche(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 7 failed"); }
		//try { test8_studentlogin(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 8 failed"); }
		//try { test9_caricodidattico(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 9 failed"); }
		//try { test10_libretto(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 10 failed"); }
		//try { test11_logout(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 11 failed"); }
		//try { test12_loginteacher(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 12 failed"); }
		//try { test13_incarichi(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 13 failed"); }
		//try { test14_appelliesami(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 14 failed"); }
		//try { test15_expandedsegnalaproblema(); } catch (Exception e) { e.printStackTrace(); System.out.println("test 15 failed"); }
		//LOGOUT ALLA FINE DELL'ESECUZIONE DI TUTTI
		
	}
	

}
