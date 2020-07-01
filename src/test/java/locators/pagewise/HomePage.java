package locators.pagewise;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.methods.UtilityClass;

public class HomePage extends UtilityClass {

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "h_sub_menu")
	private WebElement subMenu;
	
	@FindBy (xpath = "//a[text()='WEATHER']")
	private WebElement weather;
	
	@FindBy (id = "searchBox")
	private WebElement searchBox;
	
	@FindBy (xpath = "//*[@id=\"Ajmer\"]")
	private WebElement checkBox;
	
	@FindBy (xpath = "//div[@class='cityText' and text()='Ajmer']")
	private WebElement selectAjmerWeather;
	
	@FindBy (xpath = "//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]/div/div/div/span[2]")
	private WebElement cityName;
	
	@FindBy (xpath = "//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]/div/div/span[1]/b")
	private WebElement condition;
	
	@FindBy (xpath = "//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]/div/div/span[4]/b")
	private WebElement degree;
	
	@FindBy (xpath = "//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]/div/div/span[2]/b")
	private WebElement wind;
	
	@FindBy (xpath = "//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]/div/div/span[3]/b")
	private WebElement humidity;
	
	@FindBy (xpath = "//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]/div/div/span[5]/b")
	private WebElement farenheit;

	public WebElement getSubMenu() {
		return subMenu;
	}

	public WebElement getWeather() {
		return weather;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getSelectAjmerWeather() {
		return selectAjmerWeather;
	}

	public WebElement getCityName() {
		return cityName;
	}

	public WebElement getCondition() {
		return condition;
	}

	public WebElement getDegree() {
		return degree;
	}

	public WebElement getWind() {
		return wind;
	}

	public WebElement getHumidity() {
		return humidity;
	}

	public WebElement getFarenheit() {
		return farenheit;
	}

}