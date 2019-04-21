package AutomationScripts.ContectScripts;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import uiComponents.Screens.ContectScreen;
import uiComponents.Screens.QaHome;
import utilities.RandomUtility;
import utilities.RandomUtility.Mode;
import utilities.TestUtil;

public class CommonDataProviderTest extends Base {


	public static Logger log = LogManager.getLogger(CommonDataProviderTest.class.getName());
	/*This is the example of common data provider for that we are keeping class and test name same
	 * Here we are mentioning data provider class and name of data provider*/

	@Test(dataProviderClass=TestUtil.class,dataProvider="TestDP")
	public void commonDataProviderTest(String name, String email, String mobile) {

		//Checking run mode
		if(!(TestUtil.isTestRunnable("openAccountTest", excel))){
			throw new SkipException("Skipping the test "+"commonDataProviderTest".toUpperCase()+ "as the Run mode is NO");
		}


		try {
			log.info("Test");
			QaHome.getNavigation("Contact").click();
			ContectScreen.getField("name").sendKeys(name);
			log.info("Test");
			log.info("Test");
			ContectScreen.getField("email").sendKeys(email);
			ContectScreen.getField("mobile").sendKeys(mobile);
			Thread.sleep(5000);
			log.info("Test");

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
