package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoPage {
public static void main(String[] args) {
	// Initialize the webdriver
	WebDriver drv = new FirefoxDriver();
	drv.manage().window().maximize();
	drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/demopage.html");
	// CSS Selector Syntax:
	// Tagname[attribute=value]
	WebElement plradio = drv.findElement(By.cssSelector("input[value='Java']"));
	plradio.click();
}
}
