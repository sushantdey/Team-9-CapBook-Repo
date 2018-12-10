package com.cg.capbook.stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.cg.capbook.pagebeans.LoginPage;
import com.cg.capbook.pagebeans.PostPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class PostStepDefinition {
	LoginPage loginPage;
	PostPage postPage;
	WebDriver driver;
	@Given("^User is on CapBook home page$")
	public void user_is_on_CapBook_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/capBookHome");
		loginPage=PageFactory.initElements(driver, LoginPage.class);       
	}
	@When("^User enters  the valid details$")
	public void user_enters_the_valid_details() throws Throwable {
		loginPage.setEmailId("vikash@gmail.com");
		loginPage.setPassword("vikash123");
		loginPage.onClick(); 
	}
	@Then("^User is navigated to the  CapBook Profile Page$")
	public void user_is_navigated_to_the_CapBook_Profile_Page() throws Throwable {
		String actualTitle= driver.getTitle();
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	@Given("^User is on the CapBook  'Profile Page'$")
	public void user_is_on_the_CapBook_Profile_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/userProfile");
		postPage=PageFactory.initElements(driver, PostPage.class); 
	}
	@When("^User writes something on the textfield$")
	public void user_writes_something_on_the_textfield() throws Throwable {
		postPage.setPlace("Hi I am fine");
	}
	@Then("^User post gets posted and is navigated to CapBook 'Profile Page'$")
	public void user_post_gets_posted_and_is_navigated_to_CapBook_Profile_Page() throws Throwable {
		postPage.onClick();
	}
}