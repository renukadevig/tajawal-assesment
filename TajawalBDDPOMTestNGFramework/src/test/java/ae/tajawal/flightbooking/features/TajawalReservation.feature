Feature: Tajawal Flight reservation
This feature verifies the functionality of Tajawal Flight booking.


Scenario: Verify the search query data given in searchFlightdetails screen is aligned with search summary module
	Given Search input details should be entered in searchFlightdetails page
	When Click on Search Flights button in searchFlightdetails page
	Then Search summary module should be displayed as per the search query data
	When Apply filter to carrier Emirates or Air India
	Then listing results should be filtered only with the selected carrier in flightSearchResult screen
	When Click on Price sort if Price is not already sorted with ascending order
	Then verify the first listed price is the cheapest one compare to the others
	When Select random flight & related price in flightSearchResult screen
	Then the displayed cart price in Cart details page should be aligned with listing price
	When User enter the travelers details in the details page
	Then Screenshot should be taken at last page
	
	

		
