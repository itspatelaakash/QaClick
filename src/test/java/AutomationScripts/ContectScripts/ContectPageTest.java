package AutomationScripts.ContectScripts;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Base;
import logging.Verify;
import uiComponents.Screens.ContectScreen;
import uiComponents.Screens.QaHome;
import utilities.RandomUtility;
import utilities.RandomUtility.Mode;

public class ContectPageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void contectTest() throws Exception{
		log.info("Logging Step");
		
        test.log(LogStatus.INFO, "Clicking on Contect");
		QaHome.getNavigation("Contact").click();
		test.log(LogStatus.INFO, "Sending Name");
		ContectScreen.getField("name").sendKeys("Aakash Patel");
		test.log(LogStatus.INFO, "Sending Message");
	
		ContectScreen.getField("message").sendKeys(RandomUtility.generateRandomString(150, Mode.ALPHA));
		log.info("Failing test");
	   
		Verify.verifyTrue(false);
		
		System.out.print("Soft verifications worked");
		log.info("Logging Step");
	}
}



