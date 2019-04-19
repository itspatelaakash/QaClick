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
		
		Base.elogger= rep.startTest(result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		elogger.log(LogStatus.INFO,result.getName()+"_Passed" );
		
	    Base.elogger.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		Base.rep.endTest(Base.elogger);
		Base.rep.flush();
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("Capturing Screenshot");
		elogger.log(LogStatus.INFO,result.getName()+"_Failed" );
	
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
		elogger.log(LogStatus.FAIL, result.getName().toUpperCase(), result.getThrowable()); // adding ststus,TestCase name, Stack trace
		elogger.log(LogStatus.INFO, "Capturing ScreenShot");
		elogger.log(LogStatus.FAIL, elogger.addScreenCapture(TestUtil.screenShotName)); // adding screenshots using ExtentReports
		
		rep.endTest(elogger); //ending report
		rep.flush();// updating info in report
		
		
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
