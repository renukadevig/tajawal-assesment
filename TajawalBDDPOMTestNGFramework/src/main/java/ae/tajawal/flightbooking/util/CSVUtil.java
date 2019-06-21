package ae.tajawal.flightbooking.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CSVUtil {
	
	public static CSVPrinter createCSVFile(String file, String[] headers) {
		 BufferedWriter writer;
		 CSVPrinter csvPrinter = null;
		try {
			writer = Files.newBufferedWriter(Paths.get(file));
			csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
	                 .withHeader(headers));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
         return csvPrinter;
		
	}
	
	public static boolean writeRecord(CSVPrinter csvPrinter, Object[] values) {
        try {
			csvPrinter.printRecord (values);
			csvPrinter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
	}
	

	/*
	 * private void printDataToCSV() { String
	 * fileName=DirectoryConstants.DATA_EXPORT_FOLDER+"/Scenario1StepDef1_"+System.
	 * currentTimeMillis()+".csv";
	 * FileUtil.ensureFolderExistence(DirectoryConstants.DATA_EXPORT_FOLDER);
	 * 
	 * System.out.println("Start priinting"); String[] headers= {"Airline"};
	 * String[] values= {"3400.00"}; CSVPrinter csvPrinter=
	 * CSVUtil.createCSVFile(fileName,headers ); CSVUtil.writeRecord(csvPrinter,
	 * values); System.out.println("End priinting");
	 * 
	 * 
	 * }
	 * 
	 * public static void main(String[] args)throws Exception { CSVUtil csvUtil=new
	 * CSVUtil(); csvUtil.printDataToCSV(); }
	 */

}
