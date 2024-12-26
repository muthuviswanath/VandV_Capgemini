package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	public static void main(String[] args) {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("https://www.google.com");
		WebElement ele = drv.findElement(By.name("q"));
		ele.sendKeys("Selenium");
		
	}
}
