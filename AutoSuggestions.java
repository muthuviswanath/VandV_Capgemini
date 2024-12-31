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
		GoogleHomePage g = new GoogleHomePage(drv);
		g.searchQuery("selenium");

	}
}








