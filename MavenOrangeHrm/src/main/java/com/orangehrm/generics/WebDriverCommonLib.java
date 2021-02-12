package com.orangehrm.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Generic class
 * @author BTM-FACULTY
 *
 */
public class WebDriverCommonLib {
	/**
	 * implicit wait	
	 * @param driver
	 */
	public void waitForElementInGui(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * custom wait
	 * @param element
	 */
	public void customWait(WebElement element) {
		int i=0;
		while(i<1000) {
			try {
				element.isDisplayed();
				break;
			}
			catch(Exception e) {
				i++;
			}
		}
	}
	/**
	 * Explicit wait for visisbility of the element
	 * @param driver
	 * @param element
	 */
	public void waitElementVisibilty(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void rightClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	public void selectUsingIndex(WebElement element,int i) {
		Select s=new Select(element);
		s.selectByIndex(i);
	}
	public void selectUsingText(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
}
