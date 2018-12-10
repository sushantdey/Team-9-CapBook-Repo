package com.cg.capbook.stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.cg.capbook.pagebeans.EditProfilePage;
import com.cg.capbook.pagebeans.LoginPage;
import com.cg.capbook.pagebeans.ProfilePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class EditProfileStepDefinition {
	LoginPage loginPage;
	ProfilePage profilePage;
	EditProfilePage editProfilePage;
	WebDriver driver;
	@Given("^User is on Capbook 'capBookHome'\\.$")
	public void user_is_on_Capbook_capBookHome() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/capBookHome");
		loginPage=PageFactory.initElements(driver, LoginPage.class); 
	}
	@When("^User enters all the valid details\\.$")
	public void user_enters_all_the_valid_details() throws Throwable {
		loginPage.setEmailId("vikash@gmail.com");
		loginPage.setPassword("vikash123");
		loginPage.onClick();
	}
	@Then("^User is directed to the'profilePage'\\.$")
	public void user_is_directed_to_the_profilePage() throws Throwable {
		String actualTitle= driver.getTitle();
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();  
	}
	@Given("^User is on Capbook 'profilePage'\\.$")
	public void user_is_on_Capbook_profilePage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/userProfile");
		profilePage=PageFactory.initElements(driver, ProfilePage.class); 
	}
	@When("^User clicks on 'editProfile'\\.$")
	public void user_clicks_on_editProfile() throws Throwable {
		profilePage.onClick();
	}
	@Then("^User is directed to 'editProfilePage'\\.$")
	public void user_is_directed_to_editProfilePage() throws Throwable {
		String actualTitle= driver.getTitle();
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();  
	}
	@Given("^User is on Capbook 'editProfilePage'\\.$")
	public void user_is_on_Capbook_editProfilePage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/editProfile");
		editProfilePage=PageFactory.initElements(driver, EditProfilePage.class); 
	}
	@When("^User enters all valid inputs and cliks on 'updateProfile'$")
	public void user_enters_all_valid_inputs_and_cliks_on_updateProfile() throws Throwable {
		editProfilePage.setCurrentCity("Pune");
		editProfilePage.setDesignation("Analyst");
		editProfilePage.setHighestEducation("Graduate");
		editProfilePage.setUserBio("I am an Indian");
	}
	@Then("^User profile is directed to 'editProfilePage'updated with alert message\\.$")
	public void user_profile_is_directed_to_editProfilePage_updated_with_alert_message() throws Throwable {
		editProfilePage.onClick();
		Alert actualAlertMessage = driver.switchTo().alert();
		actualAlertMessage.getText();
		String expectedAlertMessage= "You have successfully updated your profile";
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		driver.close(); 
	}
}