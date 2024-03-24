# RCTC Flight Search Automation

## Case Study: IRCTC Flight Search Automation 

### Problem Statement:   
IRCTC Flight Search automation 
Get the list of flights available today from Hyderabad to Pune. 
Suggested site: https://www.air.irctc.co.in/ 

### Detailed Description: 
Launch https://www.air.irctc.co.in/ in a web browser, and verify the appropriate site is opened or not. 
Maximize the window and verify the respective application is opened or not 
Enter "Hyd" in “From” city, in the auto listed results, select "HYDERABAD (HYD)"  
Enter "Pune" in "To" city, in the auto listed results, select "PUNE (PNQ)"  
Select today’s date from the date picker. 
Select "Business" class, from “Choose class” dropdown box in Traveller details field. 
Click on "Search" button. 
Verify the results shown are valid, by checking the city and date values are same as given in previous page. 
Display the name and Number of available Flights on the console 
Capture the results screenshot and save in the project folder. 
Close the Application. 

### Key Automation Scope:
- Multi Browser automation (Chrome and Firefox)
- Extract multiple options items & store in arrays or collections
- Filling form (in different objects in web page)
- Capture results, warning or error messages
- Handle bootstrap dropdown elements
- Validating results

---------------------------------------------------------------output-----------------------------------------------------------
Enter the browser type (Chrome or Edge): chrome
Yes, appropriate site is opened!
Maximized the window, and respective application is opened!
Validating the origin city
Hyderabad (HYD)
Validating the Destination city
Pune (PNQ)
Validating the Date
19-03-2024
List of the flights
Air India AI-616/841
Air India AI-559/857
Vistara UK-890/935
Vistara UK-890/973
Air India AI-872/841
Vistara UK-541/935
Number of available Flights: 6
