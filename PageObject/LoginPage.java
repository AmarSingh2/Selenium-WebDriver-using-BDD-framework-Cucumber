package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class LoginPage {

	WebDriver iDriver;

	public LoginPage(WebDriver rDriver) {
		this.iDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logOutBtn;
	
	public void EnterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void EnterPassword(String passwordAdd) {
		password.clear();
		password.sendKeys(passwordAdd);
	}
	public void ClickLoginButton() {
		loginBtn.click();
	}
	
	public void ClickOnLogOutButton() {
		logOutBtn.click();
	}
	
}
