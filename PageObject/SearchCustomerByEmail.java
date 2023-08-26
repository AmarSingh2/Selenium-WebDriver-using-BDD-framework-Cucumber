package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByEmail {

	WebDriver iDriver;

	public SearchCustomerByEmail(WebDriver rDriver) {
		this.iDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement email;
	
	@FindBy(id = "search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement searchResult;
	
	// locating element for rows
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr")
	List<WebElement> totalRows;
	
	// locating element for rows
		@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr[1]/td")
		List<WebElement> totalColumn;
	
	public void email(String emailStr) {
		email.sendKeys(emailStr);
	}
	
	public void searchBtn() {
		searchBtn.click();
	}
	
	public boolean searchResultforEmail(String actualMailID) {
		
		boolean found = false ;
		
		for(int i=1;i<=totalRows.size();i++) {
		WebElement WebElementMailID	= iDriver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr["+i+"]/td[2]"));
		String ExpectedMailID	= WebElementMailID.getText();
		
		if(ExpectedMailID.equals(actualMailID)) {
			found = true;
			
		}
		
		}
		
		return found;
	}
	
	
}
