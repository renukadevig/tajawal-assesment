package ae.tajawal.flightbooking.util;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberUtil {
	
	public static Double commaSeperatedDouble(String value) {
		Number valueNum=null;
		try {
			valueNum = NumberFormat.getNumberInstance(java.util.Locale.US).parse(value);
			if(valueNum!=null && valueNum.doubleValue() >=0)
				return valueNum.doubleValue();
			return null;
			
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}		
	}

}
