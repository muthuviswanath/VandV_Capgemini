package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindingMultipleElements {
	public static void main(String[] args)throws Exception {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/Checkbox.html");

		List<WebElement> ele= drv.findElements(By.xpath("/html/body/input")); 
		for (int i=0;i<ele.size();i+=2) {
			Thread.sleep(1000);
			ele.get(i).click();
		}
		
		

	}
}
