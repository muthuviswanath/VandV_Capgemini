package scenarios.windows_handler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	static WebDriver drv;
	@FindBy(name = "q")
	private WebElement search_box;

	public GoogleHomePage(WebDriver drv) {
		this.drv = drv;
		PageFactory.initElements(drv,this);
	}
	
	void enterSearchText() throws Exception {
		search_box.sendKeys("selenium");
		Thread.sleep(20000);
		List<WebElement> suggestion_list = drv.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(suggestion_list);
		for (WebElement suggest : suggestion_list) {
			if(suggest.getText().toLowerCase().contains("selenium download")) {
				suggest.click();
				break;
			}
		}
	}
}
