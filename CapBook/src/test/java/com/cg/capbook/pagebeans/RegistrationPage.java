package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class RegistrationPage {
	@FindBy(how=How.NAME, name="firstName")
	private WebElement firstName;
	@FindBy(how=How.NAME, name="lastName")
	private WebElement lastName;
	@FindBy(how=How.NAME, name="emailId")
	private WebElement emailId;
	@FindBy(how=How.NAME, name="gender")
	private WebElement gender;
	@FindBy(how=How.NAME, name="homeTown")
	private WebElement homeTown;
	@FindBy(how=How.NAME, name="password")
	private WebElement password;
	@FindBy(how=How.NAME, name="confirmPassword")
	private WebElement confirmPassword;
	@FindBy(how=How.NAME, name="dateOfBirth")
	private WebElement dateOfBirth;
	@FindBy(how=How.NAME, name="SignUp")
	private WebElement register;
	@FindBy(how=How.NAME,name="gender")
	private WebElement radioButton;
	@FindBy(how=How.NAME, name="securityAnswer")
	private WebElement securityAnswer;
	public RegistrationPage(WebElement firstName, WebElement lastName, WebElement emailId, WebElement gender,
			WebElement homeTown, WebElement password, WebElement confirmPassword, WebElement dateOfBirth,
			WebElement register, WebElement radioButton, WebElement securityAnswer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
		this.homeTown = homeTown;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dateOfBirth;
		this.register = register;
		this.radioButton = radioButton;
		this.securityAnswer = securityAnswer;
	}
	public RegistrationPage() {
		super();
	}
	public String getFirstName() {
		return firstName.getAttribute("value");
	}
	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	public String getLastName() {
		return lastName.getAttribute("value");
	}
	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	public String getEmailId() {
		return emailId.getAttribute("value");
	}
	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}
	public String getGender() {
		return gender.getAttribute("value");
	}
	public void setGender(String gender) {
		this.gender.sendKeys(gender);
	}
	public String getHomeTown() {
		return homeTown.getAttribute("value");
	}
	public void setHomeTown(String homeTown) {
		this.homeTown.sendKeys(homeTown);
	}
	public String getPassword() {
		return password.getAttribute("value");
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public String getConfirmPassword() {
		return confirmPassword.getAttribute("value");
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
	}
	public String getDateOfBirth() {
		return dateOfBirth.getAttribute("value");
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth.sendKeys(dateOfBirth);
	}
	public String getSecurityAnswer() {
		return securityAnswer.getAttribute("value");
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer.sendKeys(securityAnswer);
	}
	public void onClick() {
		register.click();
	}
	public void onRadioClick() {
		radioButton.click();
	}
}