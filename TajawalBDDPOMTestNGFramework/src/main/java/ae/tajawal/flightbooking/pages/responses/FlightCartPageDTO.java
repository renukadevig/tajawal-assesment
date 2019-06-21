package ae.tajawal.flightbooking.pages.responses;

public class FlightCartPageDTO {
	
	
	public class CartFeeData{
		public String serviceFeeCurrencyCd;
		public String fareFeeCurrencyCd;
		public Double serviceFee;
		public Double fareFee;
		public String orginalFareCurrenctCd;
		public Double orginalFare;
		@Override
		public String toString() {
			return "CartFeeData [serviceFeeCurrencyCd=" + serviceFeeCurrencyCd + ", fareFeeCurrencyCd="
					+ fareFeeCurrencyCd + ", serviceFee=" + serviceFee + ", fareFee=" + fareFee
					+ ", orginalFareCurrenctCd=" + orginalFareCurrenctCd + ", orginalFare=" + orginalFare + "]";
		}
		
		
		
	}

}
