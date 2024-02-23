package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
	
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(name = "salutationtype")
	private WebElement leadsSalutationDropdown;
	
	@FindBy(name = "firstname")
	private WebElement leadFirstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement leadLastNameTextField;
	
	@FindBy(name = "company")
	private WebElement leadsCompanyNameTextField;
	
	@FindBy(xpath = "//input[@value=\"T\"]")
	private WebElement leadsAssignToGroupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement leadAssignToDropdown; 
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement leadSaveButton;

	public WebElement getLeadsSalutationDropdown() {
		return leadsSalutationDropdown;
	}

	public WebElement getLeadFirstNameTextField() {
		return leadFirstNameTextField;
	}

	public WebElement getLeadLastNameTextField() {
		return leadLastNameTextField;
	}

	public WebElement getLeadsCompanyNameTextField() {
		return leadsCompanyNameTextField;
	}

	public WebElement getLeadsAssignToGroupRadioButton() {
		return leadsAssignToGroupRadioButton;
	}

	public WebElement getLeadAssignToDropdown() {
		return leadAssignToDropdown;
	}

	public WebElement getLeadSaveButton() {
		return leadSaveButton;
	}
	
	public void selectLeadSalutation(String option) {
		Select select = new Select(leadsSalutationDropdown);
				select.selectByVisibleText(option);
	}
	
	public void enterLeadsFirstName(String firstName) {
		leadFirstNameTextField.sendKeys(firstName);
	}
	
	public void enterLeadsLasttName(String lastName) {
		leadLastNameTextField.sendKeys(lastName);
	}
	
	public void enterLeadsCompanyName(String companyName) {
		leadsCompanyNameTextField.sendKeys(companyName);
	}
	
	public void clickOnAssignedToGroupRadioButton() {
		leadsAssignToGroupRadioButton.click();
	}
	
	public void selectFromAssignToGroupDropdown(String option) {
		Select select = new Select(leadAssignToDropdown);
		select.selectByVisibleText(option);
	}
	
	public void clickOnSaveButton() {
		leadSaveButton.click();
	}
	
	

}
