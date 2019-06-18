Feature: Tajawal Flight reservation
This feature verifies the functionality of Tajawal Flight booking.

@ChromeTest
Scenario: Verify the search query data given in searchFlightdetails screen is aligned with search summary module
	Given Search input details should be entered in searchFlightdetails page
	When Click on Search Flights button in searchFlightdetails page
	Then Search summary module should be displayed as per the search query data

@ChromeTest	
Scenario: Verify the listing results should be filtered only with the selected carrier	
	Given User should be in FlightSearchResult screen
	When Apply filter result to Emirates carrier in flightSearchResult screen
	Then listing results should be filtered only with the selected carrier in flightSearchResult screen

@ChromeTest	
Scenario: Verify the displayed cart price in Cart details page should be aligned with listing price		
	Given User should be in FlightSearchResult 
	When Select random flight & related price in flightSearchResult screen
	Then the displayed cart price in Cart details page should be aligned with listing price

@ChromeTest	
Scenario: Verify the User should able to enter the travelers details in the details page and captured the screenshot		
	Given User should be in Cart page	
	When User enter the travelers details in the details page
	Then Screenshot should be taken at last page
	
#Scenario: Verify the first price INTs are the lowest comparing to other prices
	#Given Any search input details should be entered in searchFlightdetails screen
	#And Click on Search Flights button
	#When Sort the price from low to High in FlightsSearchResult
	#Then The first price INTS displayed in listing price should be the lowest comparing to other prices
	
@FirefoxTest
Scenario: Verify the search query data given in searchFlightdetails screen is aligned with search summary module_F
	Given Search input details should be entered in searchFlightdetails page_F
	When Click on Search Flights button in searchFlightdetails page_F
	Then Search summary module should be displayed as per the search query data_F

@FirefoxTest	
Scenario: Verify the listing results should be filtered only with the selected carrier_F
	Given User should be in FlightSearchResult screen_F
	When Apply filter result to Emirates carrier in flightSearchResult screen_F
	Then listing results should be filtered only with the selected carrier in flightSearchResult screen_F

@FirefoxTest	
Scenario: Verify the displayed cart price in Cart details page should be aligned with listing price_F	
	Given User should be in FlightSearchResult_F
	When Select random flight & related price in flightSearchResult screen_F
	Then the displayed cart price in Cart details page should be aligned with listing price_F

@FirefoxTest	
Scenario: Verify the User should able to enter the travelers details in the details page and captured the screenshot_F		
	Given User should be in Cart page_F
	When User enter the travelers details in the details page_F
	Then Screenshot should be taken at last page_F