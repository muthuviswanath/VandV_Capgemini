package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExamplePage {
	public static void main(String[] args) {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/example.html");
		WebElement fname = drv.findElement(By.cssSelector("input[placeholder='firstname']"));
		fname.sendKeys("Lingistar");
		WebElement lname = drv.findElement(By.cssSelector("input[placeholder='lastname']"));
		lname.sendKeys("ModiRahulMamta");
		//to identify the css attribute's value using the start with option use ^
		// tagname[attribute^='value']
		//to identify the css attribute's value using the end with option use $
		// tagname[attribute$='value']
		//to identify the css attribute's value using the contains option use *
		// tagname[attribute*='value']
	}
}







