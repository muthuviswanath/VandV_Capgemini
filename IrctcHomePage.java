package scenarios.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IrctcHomePage {

	static WebDriver driver;
	@FindBy(xpath = "//input[@aria-controls='pr_id_1_list']")
	private WebElement from_searchbox;
	
	@FindBy(xpath = "//input[@aria-controls='pr_id_2_list']")
	private WebElement to_searchbox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search_trains;
	
	IrctcHomePage(WebDriver drv){
		driver =   drv;
		PageFactory.initElements(drv, this);
	}
	
	void searchTrains(String from_Station, String to_Station) throws Exception {
		from_searchbox.sendKeys(from_Station);
		Thread.sleep(2000);
		List<WebElement> from_suggestion = driver.findElements(By.xpath("//ul[@id='pr_id_1_list']/li"));
		for(WebElement from_sugg:from_suggestion) {
			if (from_sugg.getText().toLowerCase().equalsIgnoreCase("SMVT BENGALURU - SMVB\nKARNATAKA")){
				from_sugg.click();
				break;
			}
		}
		
		to_searchbox.sendKeys(to_Station);
		Thread.sleep(2000);
		List<WebElement> to_suggestion = driver.findElements(By.xpath("//ul[@id='pr_id_2_list']/li"));
		for(WebElement to_sugg:to_suggestion) {
			if (to_sugg.getText().toLowerCase().equalsIgnoreCase("MGR CHENNAI CTL - MAS (CHENNAI)\nTAMIL NADU")){
				to_sugg.click();
				break;
			}
		}
		Thread.sleep(2000);
		search_trains.click();
		
	}
}
