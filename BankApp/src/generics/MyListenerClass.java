package generics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyListenerClass extends BaseTestClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test started");
				
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String failed = result.getName();
		Reporter.log("Test Failed");
		TakesScreenshot ts=(TakesScreenshot)dr;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+failed+".jpg");
		
			try {
				Files.copy(src,dst);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
