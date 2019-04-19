package AutomationScripts.ContectScripts;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Base;
import uiComponents.Screens.ContectScreen;
import uiComponents.Screens.QaHome;
import utilities.RandomUtility;
import utilities.RandomUtility.Mode;

public class ContectDetailsTest extends Base {
	
	

	
	@Test(dataProvider="getData")
	public void contectFillDetails(String name, String email, String  mobile) {
		try {
			elogger.log(LogStatus.INFO, "Running test from excel");
            QaHome.getNavigation("Contact").click();
			ContectScreen.getField("name").sendKeys(name);
			ContectScreen.getField("email").sendKeys(email);
			ContectScreen.getField("mobile").sendKeys(mobile);
			Thread.sleep(5000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@DataProvider
	public Object[][] getData(){
		
		String sheetName= "QaClick_DataProvider";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum=2; rowNum<=rows;rowNum++){
			
			for(int colNum=0;colNum<cols;colNum++) {
				
				//Data[0][0] - First row rowNum-2=0,colNum=0 
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				
			}
			
			
			
		}
		
		return data;
		
	}
	
	

}
