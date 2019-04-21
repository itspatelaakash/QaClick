package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.Base;





public class TestUtil extends Base {
	
	public static String screenShotName;
	 public static String screenShotpath;
    /*This method takes screen shots*/
	public static void takeScreenShot(String methodName) throws IOException {

		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
	    screenShotName =d.toString().replace(":","_").replace(" ","_")+"_"+methodName+".jpg";
	    screenShotpath = System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\ScreenShots\\"+screenShotName;
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\ScreenShots\\"+screenShotName));

	}
	
	
	
	
	/*This is commom data provider*/
	@DataProvider(name="TestDP")
	public Object[][] getData(Method m) {
		//Method m is java reflection which gives method name when ever this method is called

		String sheetName = m.getName();//as we kept method name same as sheet name this will select required sheet 
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				// Data[0][0] - First row rowNum-2=0,colNum=0
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}
		}
        return data;
      }



}



