package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingCustomer {

	WebDriver iDriver;

	public AddingCustomer(WebDriver rDriver) {
		this.iDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customersDropDown;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customers;
	
	@FindBy(xpath = "//a[normalize-space()='Add new']")
	WebElement AddNewBtn;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement Gender;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement dateofbirth;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyName;
	
	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement isTaxExempt;
	
	@FindBy(xpath = "//select[@id='SelectedNewsletterSubscriptionStoreIds']")
	WebElement Newsletter;
	
	@FindBy(xpath = "//div[@class='input-group-append input-group-required']//div[@role='listbox']")
	WebElement customerRole;
	
	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement ManagerofVendor;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement SaveButton;
	
	public void customersDropDown() {		
		customersDropDown.click();
	}
	
	public void customers() {
		customers.click();
	}
	
	public void AddNew() {
		AddNewBtn.click();
	}
	
	public void EmailInfo(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void PasswordInfo(String passwordAdd) {
		password.clear();
		password.sendKeys(passwordAdd);
	}
	
	public void firstNameInfo(String firstNameAdd) {
		firstname.clear();
		firstname.sendKeys(firstNameAdd);
	}
	
	public void lastNameInfo(String lastNameAdd) {
		lastName.clear();
		lastName.sendKeys(lastNameAdd);
	}
	
	public void GenderInfo() {
		Gender.click();
	}
	
	public void DateofBirthInfo(String DOB) {
		dateofbirth.sendKeys(DOB);
	}
	
	public void CompanyNameInfo(String company) {
		companyName.clear();
		companyName.sendKeys(company);
	}
	
	public void isTaxExemptInfo() {
		isTaxExempt.click();
	}
	
	public void NewsLetterInfo() {
		Select select = new Select(Newsletter); 
		select.selectByIndex(0);
	}
	
	public void CustomerRolesInfo() {
		customerRole.clear();
		Select selectNew = new Select(Newsletter); 
		selectNew.selectByIndex(3);
	}
	
	public void ManagerofVendorInfo() {
		Select selectQuess = new Select(ManagerofVendor); 
		selectQuess.selectByIndex(0);
	}
	
	public void SaveButton() {
		SaveButton.click();
	}	
}
