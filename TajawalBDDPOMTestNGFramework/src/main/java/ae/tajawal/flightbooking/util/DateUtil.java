package ae.tajawal.flightbooking.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date parseDateEEEDDMM(String date) {
	     try {
	         return new SimpleDateFormat("EEE, dd/mm").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	

}
