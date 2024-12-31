package scenarios.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookTrainTiicket {
	public static void main(String[] args) throws Exception {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("https://www.irctc.co.in/nget/train-search");
		IrctcHomePage ir = new IrctcHomePage(drv);
		ir.searchTrains("BENGALURU", "CHENNAI");
		PageMenu pm = new PageMenu(drv);
		Thread.sleep(2000);
		pm.click_Hotels();
	}
}
