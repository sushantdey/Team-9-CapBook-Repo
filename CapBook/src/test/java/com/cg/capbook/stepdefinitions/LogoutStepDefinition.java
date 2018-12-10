package com.cg.capbook.stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.cg.capbook.pagebeans.LoginPage;
import com.cg.capbook.pagebeans.LogoutPage;
import com.cg.capbook.pagebeans.ProfilePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LogoutStepDefinition {
	LoginPage loginPage;
	ProfilePage profilePage;
	LogoutPage logoutPage;
	WebDriver driver;
	@Given("^User is on the Capbook 'capBookHome'\\.$")
	public void user_is_on_the_Capbook_capBookHome() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/capBookHome");
		loginPage=PageFactory.initElements(driver, LoginPage.class);  
	}
	@When("^User enters all required  details\\.$")
	public void user_enters_all_required_details() throws Throwable {
		loginPage.setEmailId("vikash@gmail.com");
		loginPage.setPassword("vikash123");
		loginPage.onClick();
	}
	@Then("^User is directed to'profilePage'\\.$")
	public void user_is_directed_to_profilePage() throws Throwable {
		String actualTitle= driver.getTitle();
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	@Given("^User is on the Capbook 'profilePage'\\.$")
	public void user_is_on_the_Capbook_profilePage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/userProfile");
		profilePage =PageFactory.initElements(driver, ProfilePage.class); 
	}
	@When("^User clicks on 'logout'$")
	public void user_clicks_on_logout() throws Throwable {
		logoutPage.onClick();
	}
	@Then("^User is directed to 'capBookHome'\\.$")
	public void user_is_directed_to_capBookHome() throws Throwable {
		String actualTitle= driver.getTitle();
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close(); 
	}
}