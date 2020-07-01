package utility.methods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

public class UtilityClass {

public static WebDriver driver;
	
	// To launch the browser
	
	public static void browserLaunch() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\GOWTHAM\\eclipse-workspace\\AutomationScripts\\Chrome Driver 83\\chromedriver.exe");
			ChromeOptions popup = new ChromeOptions();
			ChromeOptions disable = popup.addArguments("--disable-notifications");
			driver = new ChromeDriver(disable);
			driver.manage().window().maximize();
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// To enter the URL
	
	public static void url(String url, int time) {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
    // To pass the values to any field
	
	public static void fill(WebElement e, String data) {
		
		try {
			e.clear();
			e.sendKeys(data);
		}
		
		catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	// To click any kind of buttons 
	
	public static void click(WebElement e) {
		
		try {
			e.click();
		} 
		
		catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
	}
	
	// To get input from user end
	public static String testData() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Pls enter the city name to find the weather: " + " ");
		String cityName = scan.next();
		System.out.println("The city name to find the weather is: " + " " + cityName);

		return cityName;
	}
	
	// TO NOTE DATE & TIME
	
	public static void executionTime(String text, String testName) {
		String dateName = new SimpleDateFormat("dd-mm-yyyy hhhh-mm-ss").format(new Date());
		
		if (text.equals("start")) {
			System.out.println("The start time of the script is: " + " " + testName + " " + dateName);
		} 
		else {
			System.out.println("The end time of the script is: " + " " + testName + " " + dateName);
		}
		
	}	
	
	public static void keyEnter(int n) throws AWTException {
		try {
			Robot key = new Robot();
			for (int i = 0; i <= n; i++) {
				key.keyPress(KeyEvent.VK_ENTER);
				key.keyRelease(KeyEvent.VK_ENTER);
			}	
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// To take Screenshots
	
	public static String screenshots(WebDriver driver, String name) throws IOException  {
		String dateName = new SimpleDateFormat("dd-mm-yyyy hhhh-mm-ss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		System.out.println("The source folder location is :" + source);
		String destination = System.getProperty("user.dir") + "/FailedTestScreenshots/" + name + dateName + ".jpeg";
		File finalDestination = new File(destination);
		System.out.println("The destination folder location is :" + finalDestination);
		try {
		FileUtils.copyFile(source, finalDestination);
		}
		catch (IOException e) {
			System.out.println("Capture failed" + e.getMessage());
		}
		return destination;
	}
	
	public static void Scroll(WebElement e) {
		JavascriptExecutor scrolling = (JavascriptExecutor) driver;
		scrolling.executeScript("arguments[0].scrollIntoView(true)", e);

	}
	
	public static void text(WebElement e, String message) {
		System.out.println(message + e.getText());

	}
	
	public static void quit() {
		try {
			driver.quit();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
	
	
		

	
	
	
	
	
	
	
