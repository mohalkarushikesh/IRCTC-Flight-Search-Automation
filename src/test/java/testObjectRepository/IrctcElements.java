package testObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testScenario.Irctc;

public class IrctcElements {
	public static WebElement element = null;
	public static WebDriver driver;

	//select origin use to sendKeys
	public static WebElement click_and_send_keys(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"stationFrom\"]"));
		return element;
	}
	//after hyd new origin list
	public static List<WebElement> new_origin_List(WebDriver driver) { // to iterate 
		List<WebElement> Departueretxt = driver.findElements(By.cssSelector("#ui-id-1 .ui-menu-item div"));
		return Departueretxt;
	}
	//copy the first argument from to clone var
	//select all <b> tag and store in b
	//remove <b> tag
	//trim and return clone vars
	//select origin city
	public static String select_origin_city(WebDriver driver) {  // clicking on element
		String scripttxt = "var clone = arguments[0].cloneNode(true); " + "var b = clone.querySelector('b'); " 
				+ "if (b) b.remove(); " + "return clone.textContent.trim();";
		return scripttxt;
	}
	//click on destination
	public static WebElement select_Destination(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"stationTo\"]"));
		return element;
	}
	//destination list
	public static List<WebElement> Destination_List(WebDriver driver) {
		List<WebElement> Destinationtxt = driver.findElements(By.cssSelector("#ui-id-2 .ui-menu-item div"));
		return Destinationtxt;
	}
	//select destination city
	public static String select_Desti_city(WebDriver driver) {
		String scripttxt = "var clone = arguments[0].cloneNode(true); " + "var b = clone.querySelector('b'); "
				+ "if (b) b.remove(); " + "return clone.textContent.trim();";
		return scripttxt;
	}
	
	
	/*
	//years List
	public static List<WebElement> years_(WebDriver driver) {
		List<WebElement> yearstxt = driver.findElements(By.xpath("//datepickermodifi[@class='form-control']//tr//sub"));
		return yearstxt;
	}
	
	//months list
	public static List<WebElement> months_(WebDriver driver) {
		List<WebElement> monthstxt = driver.findElements(By.xpath(
				"//*[@id=\"carouselExampleInterval\"]/div[1]/div/div/div[2]/form/div[3]/datepickermodifi/div/div[2]/div[1]/table//span[@class='ML-Month d-none d-md-block']"));
		return monthstxt;
	}
	
	//click on month and year
	public static List<WebElement> my_click_button(WebDriver driver) {
		List<WebElement> myclickbuttontxt = driver.findElements(By.xpath(
				"//*[@id=\"carouselExampleInterval\"]/div[1]/div/div/div[2]/form/div[3]/datepickermodifi/div/div[2]/div[1]/table/tr/td/span[1]"));
		return myclickbuttontxt;
	}

	//select all span ele with class act and <td> descendents with date
	//find first child nodes == date to click 
	// clicking on dateElement
	//select pick date 
	public static String select_pick_date(WebDriver driver, String dateToClick) {
		String scriptClickDate = "var dateElement = Array.from(document.querySelectorAll('td.date span.act')).find(span => span.childNodes[0].nodeValue.trim() === '"
				+ dateToClick + "'); dateElement.click();";
		return scriptClickDate;
	}
	
	*/
	
	
	// slect todays date direct
	public static WebElement direct_date(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='act active-red']"));
		return element;
	}
	//full date to print
	public static WebElement full_date(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='originDate']"));
		return element;
	}
	//click class
	public static WebElement click_Class_placeholder(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='noOfpaxEtc']"));
		return element;
	}
	//click on class dropdown
	public static WebElement click_on_class(WebDriver driver) {
		element = driver.findElement(By.xpath("//select[@id='travelClass']"));
		element.click();
		return element;
	}
	//select bussiness class from drop down
	public static Select select_business_class(WebDriver driver) {
		element = driver.findElement(By.xpath("//select[@id='travelClass']"));
		Select select = new Select(element);
		return select;
	}
	//click on search button
	public static WebElement search_button(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		return element;
	}
	//flight names list
	public static List<WebElement> display_name_and_no_of_flights(WebDriver driver) {
		List<WebElement> names = driver
				.findElements(By.xpath("/html/body/app-root/app-oneway/div/main/div/div/div[2]//b"));
		return names;
	}
	//flight id list
	public static List<WebElement> display_flight_id(WebDriver driver) {
		List<WebElement> number = driver
				.findElements(By.xpath("//div[@class='right-searchbarbtm-in']//div/div[2]//span"));
		return number;

	}


}
