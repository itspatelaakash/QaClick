package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.LogStatus;

import base.Base;
import utilities.TestUtil;




public class Listeners extends Base implements ITestListener {


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("On Test Start"+result.getName());
		test=rep.startTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("On Test Success"+result.getName());
		
	    test.log(LogStatus.PASS, result.getName()+" PASSED");
		rep.endTest(test);
		rep.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("Capturing Screenshot");
		System.out.println("On Test Fail"+result.getName());
		
	
		try {
			TestUtil.takeScreenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Adding screen shot in ReportNG report
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+" height=200 width=200></img></a>");
	  
		
		//Adding ExtentReport
		test.log(LogStatus.FAIL, result.getName()+"FAILED with exception"+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotpath));
		rep.endTest(test);
		rep.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
