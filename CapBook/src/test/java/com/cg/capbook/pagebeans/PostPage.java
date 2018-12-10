package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class PostPage {
	@FindBy(how=How.NAME, name="places")
	private WebElement place;
	@FindBy(how=How.NAME, name="post")
	private WebElement post;
	public PostPage(WebElement places, WebElement post) {
		super();
		this.place = places;
		this.post = post;
	}
	public PostPage() {
		super();
	}
	public String getPlace() {
		return place.getAttribute("value");
	}
	public void setPlace(String place) {
		this.place.sendKeys("place");;
	}
	public void onClick() {
		post.click();
	}
}