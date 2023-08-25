package StepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.google.common.base.Stopwatch;

import PageObject.AddingCustomer;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	WebDriver driver;
	
	LoginPage loginPage;
	
	AddingCustomer AddCustomer;

	@Given("when user open microsoft edge browser")
	public void when_user_open_microsoft_edge_browser() {
//		System.setProperty("webdriver.chrome.driver","F:\\BrowserDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		loginPage=new LoginPage(driver);
		
		AddCustomer = new AddingCustomer(driver);
	}

	@When("user open the url {string}")
	public void user_open_the_url(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) {
		loginPage.EnterEmail(emailAdd);
		loginPage.EnterPassword(password);
	}

	@When("click on login button")
	public void click_on_login_button() {
		loginPage.ClickLoginButton();
	}

	@Then("page title shoud be {string}")
	public void page_title_shoud_be(String expectedString) {
		String actualString = driver.getTitle();
		
		if(actualString.equals(expectedString)) {
			Assert.assertTrue(true);
		}
		
		else {
			Assert.assertTrue(false);
		}
	}

	@Then("click on Logout Button")
	public void click_on_logout_button() {
		loginPage.ClickOnLogOutButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedHomePageTitle) {
		String ActualHomePageTitle = driver.getTitle();
		
		if(ExpectedHomePageTitle.equals(ActualHomePageTitle)) {
			Assert.assertTrue(true);
		}
		
		else {
			Assert.assertTrue(false);
		}
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
		driver.quit();
	}

	//////////////////////////////////Add New Customer///////////////////////////////

//	@Given("user open the microsoft edge browser")
//	public void user_open_the_microsoft_edge_browser() {
////		System.setProperty("webdriver.chrome.driver","F:\\BrowserDriver\\chromedriver-win64\\chromedriver.exe");
//		WebDriverManager.edgedriver().setup();
//		driver=new EdgeDriver();
//		
////		loginPage=new LoginPage(driver);
//		
//		AddCustomer = new AddingCustomer(driver);
//	}
//	@When("user enter the url {string}")
//	public void user_enter_the_url(String url) {
//		driver.get(url);
//	}
//	@When("enter the email as {string} and passowrd as {string}")
//	public void enter_the_email_as_and_passowrd_as(String emailadd, String passwordadd) {
//	    
//	}
//	@When("user click on Login Button")
//	public void user_click_on_login_button() {
//	    
//	}



	
	
	
	
	@Then("user can view dashboard and title as {string}")
	public void user_can_view_dashboard_and_title_as(String ExpectedDashboardTitle) {
	    String ActualDashboardTitle=driver.getTitle();
	    
	    if(ActualDashboardTitle.equals(ExpectedDashboardTitle)) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	   
	    
	}

	@When("user select on customers dropdown")
	public void user_select_on_customers_dropdown() {
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Stopwatch watch = null;
		
//		try {
//			watch = Stopwatch.createStarted();
			AddCustomer.customersDropDown();
//		}
		
//		catch(Exception e) {
//			watch.stop();
//			System.out.println(e);
//			System.out.println(watch.elapsed(TimeUnit.SECONDS)+ " seconds ");
//		}
	    
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
//	    AddCustomer.customersDropDown();
	}

	@When("user click on customers menu item")
	public void user_click_on_customers_menu_item() {
	    AddCustomer.customers();
	    
//	    try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@When("user click on Add New Button")
	public void user_click_on_add_new_button() {
	    AddCustomer.AddNew();
	}

	@When("user enter customer info")
	public void user_enter_customer_info() {
		   AddCustomer.EmailInfo("amar877057@gmail.com");
		   AddCustomer.PasswordInfo("123456789");
		   AddCustomer.firstNameInfo("Amar");
		   AddCustomer.lastNameInfo("Singh");
		   AddCustomer.GenderInfo();
		   AddCustomer.DateofBirthInfo("23/08/2023");
		   AddCustomer.isTaxExemptInfo();
//		   AddCustomer.NewsLetterInfo();
//		   AddCustomer.CustomerRolesInfo();
		   AddCustomer.ManagerofVendorInfo();
		   
	}

	@When("click on save button")
	public void click_on_save_button() {
	   AddCustomer.SaveButton();
	}

//	@Then("user can view confirmation message {string}")
//	public void user_can_view_confirmation_message(String string) {
////	    driver.findElement(null)
//	}

	
	
}
