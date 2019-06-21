package ae.tajawal.flightbooking.util;

import java.io.File;

public class FileUtil {
	
	
	public static boolean ensureFolderExistence(String folderName){
		try {
			File folder=new File(folderName);
			
			if (!folder.exists()){
				folder.mkdirs();
	        }
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
