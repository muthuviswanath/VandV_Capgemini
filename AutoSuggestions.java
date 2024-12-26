package scenarios;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestions  {
	public static void main(String[] args) throws Exception{
		WebDriver drv = new FirefoxDriver();
		drv.manage().window().maximize();
		drv.navigate().to("https://www.google.com");
			WebDriverWait exp_wait = new WebDriverWait(drv, Duration.ofSeconds(10));
			WebElement search_box = exp_wait.until(ExpectedConditions.visibilityOf(drv.findElement(By.name("q"))));
			search_box.sendKeys("selenium");
		
		Thread.sleep(2000);
		List<WebElement> suggestions =  drv.findElements(By.xpath("//ul[@role='listbox']/li"));
		for (WebElement suggest : suggestions) {
			if(suggest.getText().toLowerCase().contains("selenium webdriver")) {
				suggest.click();
			}
		}
		Thread.sleep(2000);
		drv.quit();

	}
}








