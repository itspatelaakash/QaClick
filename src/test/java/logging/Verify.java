package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import AutomationScripts.ContectScripts.CommonDataProviderTest;
import base.Base;

public class Verify extends Base{
	public static Logger log = LogManager.getLogger(Verify.class.getName());
	
	public static void verifyTrue(Boolean object) {
		
		try {
			Assert.assertTrue(object);
		}catch(Exception e){
			log.error(e.getMessage());
			test.log(LogStatus.FAIL, "Verification Failed With : _"+e.getMessage());
		}
		
		
	}

}
