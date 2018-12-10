package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class EditProfilePage {
	@FindBy(how=How.NAME, name="designation")
	private WebElement designation;
	@FindBy(how=How.NAME, name="userBio")
	private WebElement userBio;
	@FindBy(how=How.NAME, name="currentCity")
	private WebElement currentCity;
	@FindBy(how=How.NAME, name="highestEducation")
	private WebElement highestEducation;
	@FindBy(how=How.NAME, name="UpdateProfile")
	private WebElement UpdateProfile;
	public EditProfilePage(WebElement designation, WebElement userBio, WebElement currentCity,
			WebElement highestEducation, WebElement updateProfile) {
		super();
		this.designation = designation;
		this.userBio = userBio;
		this.currentCity = currentCity;
		this.highestEducation = highestEducation;
		this.UpdateProfile = updateProfile;
	}
	public EditProfilePage() {
		super();
	}
	public String getDesignation() {
		return designation.getAttribute("value");
	}
	public void setDesignation(String designation) {
		this.designation.sendKeys(designation);
	}
	public String getUserBio() {
		return userBio.getAttribute("value");
	}
	public void setUserBio(String userBio) {
		this.userBio.sendKeys(userBio);
	}
	public String getCurrentCity() {
		return currentCity.getAttribute("value");
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity.sendKeys(currentCity);
	}
	public String getHighestEducation() {
		return highestEducation.getAttribute("value");
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation.sendKeys(highestEducation);
	}
	public void onClick() {
		UpdateProfile.click();
	}
}