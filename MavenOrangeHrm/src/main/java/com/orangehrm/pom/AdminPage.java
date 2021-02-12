package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	@FindBy(id="menu_admin_Organization")
	private WebElement OrganizationDropDown;

	@FindBy(id="menu_admin_viewOrganizationGeneralInformation")
	private WebElement GeneralInformationOption;

	@FindBy(id="btnSaveGenInfo")
	private WebElement EditBtn;	
	
	@FindBy(id="organization_name")
	private WebElement OrganisationNametbx;
	
	@FindBy(id="organization_email")
	private WebElement EmailTbx;
	
	@FindBy(id="btnSaveGenInfo")
	private WebElement SaveBtn;	
	
public  AdminPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getOrganizationDropDown() {
	return OrganizationDropDown;
}

public WebElement getGeneralInformationOption() {
	return GeneralInformationOption;
}

public WebElement getEditBtn() {
	return EditBtn;
}

public WebElement getOrganisationNametbx() {
	return OrganisationNametbx;
}

public WebElement getEmailTbx() {
	return EmailTbx;
}

}
