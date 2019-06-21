package ae.tajawal.flightbooking.pages.responses;

public class FlightSelectionPageDTO {
	
	public class IternaryPriceData{
		public String priceCurrency;
		public Double price;
		@Override
		public String toString() {
			return "IternaryPriceData [priceCurrency=" + priceCurrency + ", price=" + price + "]";
		}
		
		
	}
	public class SortingChecker{
		public Double firstElementPrice;
		public Double lowestPrice;
		
		
	}

}
