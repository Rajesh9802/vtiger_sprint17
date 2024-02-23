package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class leadsInformationPage {
	WebDriver driver;
	public leadsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
        this.driver = driver;
}
	
	public String verifyLeadInformation(String firstName, String lastName) {
	   
	   return driver.findElement(By.xpath("//span[contains(text(), '"+lastName+" "+firstName+"')]")).getText();
		
	}
}
	
	
