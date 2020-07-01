package testvagrant.ndtv.weather;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import locators.pagewise.HomePage;
import utility.methods.UtilityClass;

public class Ndtv_Weather  extends UtilityClass {

	public static HomePage homePage;
	
	@BeforeClass
	public void appLaunch() {
		browserLaunch();
		url("https://www.ndtv.com/", 10);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		homePage = new HomePage();
	}
	
	// UI part
	@Test
	public static void weather_finder() throws AWTException {
		executionTime("start", "Weather_finder");
		click(homePage.getSubMenu());
		click(homePage.getWeather());
		click(homePage.getSearchBox());
		fill(homePage.getSearchBox(), "Ajmer");
		keyEnter(1);
		click(homePage.getCheckBox());
		click(homePage.getSelectAjmerWeather());
		
		// To retrieve the data from web appliaction
		text(homePage.getCityName(), "The name of the selected city is: ");
		text(homePage.getCondition(), "The condition of the selected city is: ");
		text(homePage.getWind(), "The wind of the selected city is: ");
		text(homePage.getFarenheit(), "The Farenheit of the selected city is: ");
		text(homePage.getHumidity(), "The Humidity of the selected city is: ");
		text(homePage.getDegree(), "The Temperature of the selected city is: ");
		String temperature = homePage.getDegree().getText();
		System.out.println("The temperature of the selected city is: " + temperature);
		executionTime("end", "Weather_finder");
	}
	
	
	// API part
	@Test
	public static void GET_Request() {
		
		// Specify base URI
		RestAssured.baseURI = "http://api.openweathermap.org";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response object
		Response response = httpRequest.request(Method.GET,
		"/data/2.5/forecast?q=Coimbatore&APPID=7fe67bf08c80ded756e598d6f8fedaea");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :" + statusCode);
		Assert.assertEquals(statusCode, 200);

		// validating headers
		String contentType = response.header("Content-Type");// capture details of Content-Type header
		System.out.println("Content Type is:" + contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");

	}
		
	@AfterClass
	public static void quitBrowser() {
		
		quit();

	}
	}
	
	