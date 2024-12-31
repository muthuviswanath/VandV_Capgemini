package scenarios;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Selections {
	public static void main(String[] args) throws Exception{
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/demopage.html");
		WebElement ele = drv.findElement(By.xpath("//select[contains(@name,'countries')]"));
		Select county_list = new Select(ele);
		//select an option from the drop down list box using index
		county_list.selectByIndex(3);
		Thread.sleep(2000);
		//select an option from the drop down list box using visible text
		county_list.selectByVisibleText("Bangladesh");
		Thread.sleep(2000);
		//select an option from the drop down list box using value
		county_list.selectByValue("SL");
		Thread.sleep(2000);
		//select an option from the drop down list box using Contains VisibleText
		county_list.selectByContainsVisibleText("Afri");
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(drv)
				.withTimeout(Duration.ofSeconds(10))// maximum time that it waits to  find the element
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		WebElement element = fwait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				return drv.findElement(By.id("name"));
			}
		});
		element.click();//This action will be performed only if the element is loaded within 10 seconds with a polling interval of
		//2 seconds and if not found, it will not throw NoSuchElement Exception
		}
}




