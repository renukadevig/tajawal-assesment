$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/ae/tajawal/flightbooking/features/TajawalReservation.feature");
formatter.feature({
  "line": 1,
  "name": "Tajawal Flight reservation",
  "description": "This feature verifies the functionality of Tajawal Flight booking.",
  "id": "tajawal-flight-reservation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Verify the search query data given in searchFlightdetails screen is aligned with search summary module",
  "description": "",
  "id": "tajawal-flight-reservation;verify-the-search-query-data-given-in-searchflightdetails-screen-is-aligned-with-search-summary-module",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Search input details should be entered in searchFlightdetails page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Click on Search Flights button in searchFlightdetails page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Search summary module should be displayed as per the search query data",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Apply filter to carrier Emirates or Air India",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "listing results should be filtered only with the selected carrier in flightSearchResult screen",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Click on Price sort if Price is not already sorted with ascending order",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "verify the first listed price is the cheapest one compare to the others",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Select random flight \u0026 related price in flightSearchResult screen",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the displayed cart price in Cart details page should be aligned with listing price",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User enter the travelers details in the details page",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Screenshot should be taken at last page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.enterFlightInputDetails()"
});
