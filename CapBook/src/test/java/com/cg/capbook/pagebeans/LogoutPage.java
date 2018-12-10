package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LogoutPage {
	@FindBy(how=How.NAME, name="Logout")
	private WebElement Logout;
	public LogoutPage(WebElement logout) {
		super();
		Logout = logout;
	}
	public LogoutPage() {
		super();
	}
	public void onClick() {
		Logout.click();
	}
}