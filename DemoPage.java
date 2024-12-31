package scenarios.windows_handler;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoPage {
	@FindBy(xpath="//button[contains(text(),'Open Window')]")
	private WebElement new_window;

	@FindBy(xpath="//button[contains(text(),'Open Tab')]")
	private WebElement new_tab;

	@FindBy(xpath="//button[contains(text(),'Open New Window')]")
	private WebElement multiple_new_windows;

	@FindBy(xpath="//select[@id='multiple-select-example']")
	private WebElement  multiple_select;
	
	@FindBy(id="mousehover")
	private WebElement mouseover_button;
	
	@FindBy(linkText = "Top")
	private WebElement top_option;
	
	@FindBy(linkText = "Reload")
	private WebElement reload_option;
	
	public DemoPage(WebDriver drv) {
		PageFactory.initElements(drv, this);
	}
	
	void openNewWindow() {
		new_window.click();
	}
	
	void openNewTab() {
		new_tab.click();
	}
	void openNewWindows() {
		multiple_new_windows.click();
	}
	
	void select_multiple_options() {
		Select s = new Select(multiple_select);
		s.selectByVisibleText("Apple");
		s.selectByVisibleText("Peach");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.deselectAll();
	}
	
	void enterdata(WebDriver drv) {
		String script = "document.getElementById('"+"disabled_text"+"').value='Welcome to the world of JavaScript';";
		RemoteWebDriver r = (RemoteWebDriver) drv;
		r.executeScript(script);
	}
	
	void scrollToAnElement(WebDriver drv) throws Exception {
		RemoteWebDriver r = (RemoteWebDriver) drv;
		Point position  = mouseover_button.getLocation();
		int y = position.getY();
		String scroll_script = "window.scrollTo(0,"+y+");";
		Thread.sleep(3000);
		r.executeScript(scroll_script);
	}
	
	void performMouseOverAction(WebDriver drv) throws Exception {
		Actions act = new Actions(drv);
		act.moveToElement(mouseover_button).perform();
		Thread.sleep(4000);
		act.moveToElement(top_option).click().perform();
	}
}
