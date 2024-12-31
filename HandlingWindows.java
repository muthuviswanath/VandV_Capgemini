package scenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {
	public static void main(String[] args) throws Exception{
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/demopage.html");
		String parent_window = drv.getWindowHandle();
		drv.findElement(By.xpath("//button[contains(text(),'Open Window')]")).click();
		Set<String> windows_names = drv.getWindowHandles();
		drv.switchTo().window(parent_window);
		drv.findElement(By.xpath("//button[contains(text(),'Open New Window')]")).click();
		for(String wname:windows_names) {
			System.out.println(wname);

		}
		Thread.sleep(2000);
		//To switch to another Window:
		for(String win_names:windows_names) {
			if (!win_names.equals(parent_window)) {
				if(drv.switchTo().window(win_names).getTitle().equals("Google")) {
					drv.findElement(By.name("q")).sendKeys("Happy New Year");
				}
			}
		}

	}
}
