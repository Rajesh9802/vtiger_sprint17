package leads_module;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CreatingNewLeadPage;
import pomRepository.HomePage;
import pomRepository.LeadsPage;
import pomRepository.leadsInformationPage;
/**
 * 
 * @author Raj
 *
 */
@Listeners(genericUtility.ListnersImplementationClass.class)
public class ToCreateALeadTest extends BaseClass{
	
	@Test(priority = 1, retryAnalyzer = genericUtility.RetryAnalyzerImplementationClass.class, groups = "smoke")
	public void toCreateALeadAndToVerifyTheLeadDetails() throws EncryptedDocumentException, FileNotFoundException, IOException, SQLException {
		
		//Test Data
		String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 0);
		String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		String leadCompanyName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 3);
		String leadAssignedToGroupOption = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 4);
		
		//Object creation statement of all POM Classes
		HomePage home = new HomePage(driver);
		LeadsPage lead = new LeadsPage(driver);
		CreatingNewLeadPage createLeads = new CreatingNewLeadPage(driver);
		leadsInformationPage leadsInfo = new leadsInformationPage(driver);
		
		//Actual Test Script
		home.clickOnLeadModule();
		lead.clickOnLeadsPlusButton();
		createLeads.selectLeadSalutation(leadSalutation);
		createLeads.enterLeadsFirstName(leadFirstName);
		createLeads.enterLeadsLasttName(leadLastName);
		createLeads.enterLeadsCompanyName(leadCompanyName);
		createLeads.clickOnAssignedToGroupRadioButton();
		createLeads.selectFromAssignToGroupDropdown(leadAssignedToGroupOption);
		createLeads.clickOnSaveButton();
		
		String actualLeadInfo = leadsInfo.verifyLeadInformation(leadFirstName, leadLastName);
		Assert.assertTrue(actualLeadInfo.contains(leadLastName));
		System.out.println("Pass: The Lead has been created");
		
		//System.out.println(dUtils.fetchDataFromDataBase(connection, "select * from lead;"));
		
		
	}

}
