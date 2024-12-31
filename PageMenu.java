package scenarios.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMenu {
	static WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'HOTELS')]")
	private WebElement hotel_menu;

	PageMenu(WebDriver drv){
		driver =   drv;
		PageFactory.initElements(drv, this);
	}
	
	void click_Hotels() {
		hotel_menu.click();
	}
}
