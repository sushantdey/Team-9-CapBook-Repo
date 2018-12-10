package com.cg.capbook.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class ProfilePage {
	@FindBy(how=How.ID, id="editProfile")
	private WebElement editProfile;
	@FindBy(how=How.NAME, name="changeProfilePic")
	private WebElement changeProfilePic;
	@FindBy(how=How.NAME, name="accountSetting")
	private WebElement accountSetting;
	@FindBy(how=How.NAME, name="Logout")
	private WebElement Logout;
	public ProfilePage(WebElement editProfile, WebElement changeProfilePic, WebElement accountSetting) {
		super();
		this.editProfile = editProfile;
		this.changeProfilePic = changeProfilePic;
		this.accountSetting = accountSetting;
	}
	public ProfilePage(WebElement editProfile, WebElement changeProfilePic, WebElement accountSetting,
			WebElement logout) {
		super();
		this.editProfile = editProfile;
		this.changeProfilePic = changeProfilePic;
		this.accountSetting = accountSetting;
		Logout = logout;
	}
	public ProfilePage() {
		super();
	}
	public String getEditProfile() {
		return editProfile.getAttribute("value");
	}
	public void setEditProfile(String editProfile) {
		this.editProfile.sendKeys(editProfile);
	}
	public String getChangeProfilePic() {
		return changeProfilePic.getAttribute("value");
	}
	public void setChangeProfilePic(String changeProfilePic) {
		this.changeProfilePic.sendKeys(changeProfilePic);
	}
	public String getAccountSetting() {
		return accountSetting.getAttribute("value");
	}
	public void setAccountSetting(String accountSetting) {
		this.accountSetting.sendKeys(accountSetting);
	}
	public void onClick() {
		editProfile.click();
	}
}
