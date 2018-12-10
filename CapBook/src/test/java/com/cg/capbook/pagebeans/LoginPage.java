package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginPage {
	@FindBy(how=How.NAME, name="emailId")
	private WebElement emailId;
	@FindBy(how=How.NAME, name="password")
	private WebElement password;
	@FindBy(how=How.NAME, name="logIn")
	private WebElement logIn;
	public LoginPage(WebElement emailId, WebElement password, WebElement logIn) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.logIn = logIn;
	}
	public LoginPage() {
		super();
	}
	public String getEmailId() {
		return emailId.getAttribute("value");
	}
	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}
	public String getPassword() {
		return password.getAttribute("value");
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public void onClick() {
		logIn.click();
	}
}
