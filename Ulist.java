package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ulist {
public static void main(String[] args) {
	WebDriver drv = new FirefoxDriver();
	drv.manage().window().maximize();
	drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/Lists.html");
		List<WebElement> suggestions =  drv.findElements(By.xpath("//ul[@role='ulist']/li"));
	for (WebElement suggest : suggestions) {
		System.out.println(suggest.getText());
		}
	}
	

}
