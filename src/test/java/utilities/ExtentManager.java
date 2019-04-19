package utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports extent; // Creating instance of class
	
	//Method to get instance of ExtentReport
	public static ExtentReports getInstance() {
		
		if(extent==null)
		{
			//setting path of report in any folder
			extent= new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			
			//Adding ExtentReport config File
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ExtentConfig\\ReportsConfig.xml"));
		
		}
		
		
		return extent;
		
	}

}
