package com.orangehrm.generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseClass implements ITestListener{
	public void onFinish(ITestContext arg0) {
				
	}
	public void onStart(ITestContext arg0) {
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
	public void onTestFailure(ITestResult arg) {
		String result = arg.getName();
		TakesScreenshot t=(TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+result+".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult arg0) {
		
	}
	public void onTestStart(ITestResult arg0) {
		
	}
	public void onTestSuccess(ITestResult arg0) {
		
	}

	
}
