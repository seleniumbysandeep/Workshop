package com.orangehrm.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.generics.BaseClass;
import com.orangehrm.generics.FileLib;
import com.orangehrm.generics.WebDriverCommonLib;
import com.orangehrm.pom.AdminPage;
import com.orangehrm.pom.HomePage;

@Listeners(com.orangehrm.generics.ListenerImplementation.class)
public class OrganisationModule extends BaseClass{
	@Test
	public void testEditOrganisation() throws InterruptedException, EncryptedDocumentException, IOException, InvalidFormatException {
		Reporter.log("Edit Organization",true);
		FileLib f=new FileLib();
		String OrganisationName = f.getExcelValue("EditOrganisation", 1, 0);
		String Email = f.getExcelValue("EditOrganisation", 1, 1);
		HomePage h=new HomePage(driver);
		AdminPage ap=new AdminPage(driver);
		//mouse hover to admin dropdown
		w.mouseHover(driver, h.getAdminDropDown());
		//mouse hover to organisation drop down
		w.mouseHover(driver, ap.getOrganizationDropDown());
		//click on General inforamtion option	
		ap.getGeneralInformationOption().click();	
		//click on edit button
		ap.getEditBtn().click();
		ap.getOrganisationNametbx().clear();		
		ap.getOrganisationNametbx().sendKeys(OrganisationName);		
		ap.getEmailTbx().clear();		
		ap.getEmailTbx().sendKeys(Email);	
		String ActualOrganization = ap.getOrganisationNametbx().getAttribute("value");
		Assert.assertEquals(ActualOrganization, OrganisationName);		
	}
}
