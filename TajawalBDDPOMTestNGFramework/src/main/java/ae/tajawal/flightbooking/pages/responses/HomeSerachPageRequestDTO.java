package ae.tajawal.flightbooking.pages.responses;

import java.util.Date;

public class HomeSerachPageRequestDTO {
	
	public class SearchData{
		public String origin;
		public String destination;
		public Date depatureDate;
		public Date returnDate;
		public String cabinType;
		public Integer passengerAdultCount;
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((cabinType == null) ? 0 : cabinType.hashCode());
			result = prime * result + ((depatureDate == null) ? 0 : depatureDate.hashCode());
			result = prime * result + ((destination == null) ? 0 : destination.hashCode());
			result = prime * result + ((origin == null) ? 0 : origin.hashCode());
			result = prime * result + ((passengerAdultCount == null) ? 0 : passengerAdultCount.hashCode());
			result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SearchData other = (SearchData) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (cabinType == null) {
				if (other.cabinType != null)
					return false;
			} else if (!cabinType.equals(other.cabinType))
				return false;
			if (depatureDate == null) {
				if (other.depatureDate != null)
					return false;
			} else if (!depatureDate.equals(other.depatureDate))
				return false;
			if (destination == null) {
				if (other.destination != null)
					return false;
			} else if (!destination.equals(other.destination))
				return false;
			if (origin == null) {
				if (other.origin != null)
					return false;
			} else if (!origin.equals(other.origin))
				return false;
			if (passengerAdultCount == null) {
				if (other.passengerAdultCount != null)
					return false;
			} else if (!passengerAdultCount.equals(other.passengerAdultCount))
				return false;
			if (returnDate == null) {
				if (other.returnDate != null)
					return false;
			} else if (!returnDate.equals(other.returnDate))
				return false;
			return true;
		}
		private HomeSerachPageRequestDTO getEnclosingInstance() {
			return HomeSerachPageRequestDTO.this;
		}
		
		
		
	}

}
