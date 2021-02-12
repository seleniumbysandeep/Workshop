package com.orangehrm.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.pom.HomePage;
import com.orangehrm.pom.LoginPage;

public class BaseClass {
	static {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
	}
	public static WebDriver driver;
	public WebDriverCommonLib w=new WebDriverCommonLib();
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		w.waitForElementInGui(driver);
	}
	@BeforeMethod
	public void login() throws IOException {
		FileLib f=new FileLib();
		String url = f.getPropertyValue("url");
		String un = f.getPropertyValue("username");
		String pw = f.getPropertyValue("password");
		driver.get(url);		
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);

	}
	@AfterMethod
	public void logout() {
		HomePage h=new HomePage(driver);
		h.setLogout();
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
