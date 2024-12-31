package scenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToTab {
public static void main(String[] args) {
	WebDriver drv = new ChromeDriver();
	drv.manage().window().maximize();
	drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/demopage.html");
	String hometab = drv.getWindowHandle();
	drv.findElement(By.xpath("//button[contains(text(),'Open Tab')]")).click();
	
	Set<String> tabs = drv.getWindowHandles();
	System.out.println(tabs.size());
	for (String handles : tabs) {
		if(drv.switchTo().window(handles).getTitle().equals("Google")) {
			drv.findElement(By.name("q")).sendKeys("Happy New Year");
		}
	}
}
}
