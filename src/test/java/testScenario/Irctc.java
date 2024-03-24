package testScenario;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testObjectRepository.IrctcElements;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ScreenShot;

public class Irctc {
	public static String browser = "chrome";
	public static WebDriver driver;
	
	// Instantiate driver
	public static void driverconfig(String browser) {
		driver = DriverSetup.driverInstantiate(browser);
	} 

	// validate the site is opened or not
	public static void validateUrl() {
		String actualUrl = "https://www.air.irctc.co.in/";
		if (actualUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Yes, appropriate site is opened!");
		} else {
			System.out.println("No, appropriate site is Not opened!");
		}
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "appropriate site opened");
		} catch (Exception  e) {
			System.out.println(e);
		}
	}

	// validate respective application is opened!
	public static void respectiveAppOpenOrNot() {
		String expectedTitle = "Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air";
		if (expectedTitle.equals(driver.getTitle())) {
			System.out.println("Respective application is opened!");
		} else {
			System.out.println("No, application is not opened!");
		}
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "maximize application opened");
		} catch (Exception  e) {
			System.out.println(e);
		}
	}

	// Select "Hyd" in “From” city, in the auto listed results, select "HYDERABAD (HYD)"
	public static void selectOrigin(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement origin = IrctcElements.click_and_send_keys(driver);
		origin.click();
			
		String selectFromCity = "hyd";
		String selectOriginCity = "Hyderabad (HYD)"; //if directly compare "IN" in it
		
		WebElement selectOrigin = IrctcElements.click_and_send_keys(driver);
		selectOrigin.sendKeys(selectFromCity);
		
		//list after hyd sendkeys
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 .ui-menu-item div")));
		
		List<WebElement> originCityList = IrctcElements.new_origin_List(driver);
		for (WebElement element : originCityList) {
			//can't use JS direct that why JavascriptExecutor interface is used & object cast to JS executor  
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//script variable contains JS code
			String script = IrctcElements.select_origin_city(driver);
			//he JavaScript code is executed on element The result is cast to a string and stored in the text variable.
			String text = (String) js.executeScript(script, element);
			if (text.equals(selectOriginCity)) {
				element.click();
				// System.out.println("Origin city is selected!");
				System.out.println("Validating the origin city");
				System.out.println(text);
				break;
			}
		}	
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "hyderabad selected");
		} catch (Exception  e) {
			System.out.println(e);
		}

	}

	// Enter "Pune" in "To" city, in the auto listed results, select "PUNE (PNQ)"
	public static void selectDestination() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		String selectToCity = "Pune";
		String selectDestinationCity = "Pune (PNQ)"; 
		//sending value
		WebElement selectDestination = IrctcElements.select_Destination(driver);
		selectDestination.sendKeys(selectToCity);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-2 .ui-menu-item div")));
		
		List<WebElement> DestinationList = IrctcElements.Destination_List(driver); //after giving value as "Pune"
		for (WebElement element : DestinationList) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = IrctcElements.select_Desti_city(driver);
			String text = (String) js.executeScript(script, element);
			if (text.equals(selectDestinationCity)) { 	//directly compare getting "IN" in it
				element.click();
				// System.out.println("Destination city is selected!");
				System.out.println("Validating the Destination city");
				System.out.println(text);
				break;
			}
		}
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "pune selected");
		} catch (Exception  e) {
			System.out.println(e);
		}
	}

	// select todays date
	public static void selectMonthYearDate() {
		/*
		String year = "2024";
		String month = "MARCH";
		String dateToClick = "22";
		 
		List<WebElement> years = IrctcElements.years_(driver);
		List<WebElement> myClickButton = IrctcElements.my_click_button(driver);
		List<WebElement> months = IrctcElements.months_(driver);

		for (int i = 0; i < years.size() - 1; i++) {
			String s1 = years.get(i).getText();
			String s2 = months.get(i).getText();
			if (s1.equals(year) && s2.equals(month)) {
				myClickButton.get(i).click();
				// System.out.println("month and year got clicked!");

		
				JavascriptExecutor js = (JavascriptExecutor) driver;
		
				js.executeScript(IrctcElements.select_pick_date(driver, dateToClick));
			}
		}

		System.out.println("Validating the Date");
		WebElement fullDate = driver.findElement(By.xpath("//input[@id='originDate']"));
		System.out.println(fullDate.getAttribute("value"));
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "todays date selected");
		} catch (Exception e) {
			System.out.println(e);
		}
		*/
		
		 WebElement directdate=IrctcElements.direct_date(driver); 
		 directdate.click();
		 System.out.println("Validating the Date"); 
		 WebElement fullDate=IrctcElements.full_date(driver);
		 System.out.println(fullDate.getAttribute("value"));
		
	}
	
	// selecting business class
	public static void selectBusinessClass() {
		IrctcElements.click_Class_placeholder(driver).click();
		
		IrctcElements.click_on_class(driver);
	
		// Selected business class
		Select objSelect = IrctcElements.select_business_class(driver);
		objSelect.selectByVisibleText("Business");
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver, "business class selected");
		} catch (Exception  e) {
			System.out.println(e);
		}

	}

	// click on searchbutton
	public static void searchButton() {
		WebElement searchButton = IrctcElements.search_button(driver);
		searchButton.click();

		try {
			ScreenShot.screenShotTC(driver, "clicked on search button");
		} catch (Exception  e) {
			System.out.println(e);
		}
	}

	// Display the name of the flights
	public static void DisplayNameAndAvailableFlights() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-oneway/div/main/div/div/div[2]//b")));
			
			// implicitly wait used here if there is no flights it will close browser after 20 secs
			List<WebElement> flightList = IrctcElements.display_name_and_no_of_flights(driver);
			List<WebElement> flightListId = IrctcElements.display_flight_id(driver);
	
			System.out.println("List of the flights");
			for (int i = 0; i < flightList.size(); i++) {	
				System.out.println(flightList.get(i).getText() + " " + flightListId.get(i).getText());
	
			}
			// System.out.println("Flights list has showned!");
			try {
				// Take screen shot
				ScreenShot.screenShotTC(driver, "displayed available flights");
			} catch (Exception  e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println("No flight available for this route.");
		}
		System.out.println("Number of available Flights: " + IrctcElements.display_name_and_no_of_flights(driver).size());
		
	}

	public static void main(String[] args) {
		driverconfig(browser);
		validateUrl();
		respectiveAppOpenOrNot(); // using title
		selectOrigin();
		selectDestination();
		selectMonthYearDate();
		selectBusinessClass();
		searchButton();
		DisplayNameAndAvailableFlights();
		DriverSetup.driverTearDown();
	}

	
}
