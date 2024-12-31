package scenarios.windows_handler;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Implementation {

	public static void main(String[] args) throws Exception{
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/demopage.html");
		DemoPage demo = new DemoPage(drv);
		GoogleHomePage gh = new GoogleHomePage(drv);
		String parent_handle = drv.getWindowHandle();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("1. Open New Tab");
			System.out.println("2. Open New Window");
			System.out.println("3. Open Multiple Windows");
			System.out.println("4. Select Multiple options");
			System.out.println("5. Execute a Javascript code");
			System.out.println("6. Scroll to the end of the page");
			System.out.println("7. Scroll to a specific Element");
			System.out.println("8. MouseOver Action on the menu");
			System.out.println("Enter your choice [1...4]: ");
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				demo.openNewTab();
				Set<String> tab_list = drv.getWindowHandles();
				try {
					for(String tabs:tab_list) {
						if(drv.switchTo().window(tabs).getTitle().equals("Google")) {
							gh.enterSearchText();
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				//closing the newly opened tab
				drv.close();
				//Switching back to the parent window
				drv.switchTo().window(parent_handle);
				break;
			case 2:
				demo.openNewWindow();
				Set<String> single_window = drv.getWindowHandles();
				try {
					for(String win:single_window) {
						if(drv.switchTo().window(win).getTitle().equals("Google")) {
							gh.enterSearchText();
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				//closing the newly opened window
				drv.close();
				drv.switchTo().window(parent_handle);
				break;
			case 3:
				demo.openNewWindow();
				demo.openNewWindows();
				Set<String> multiple_windows = drv.getWindowHandles();
				try {
					for(String win:multiple_windows) {
						if(drv.switchTo().window(win).getTitle().equals("Google")) {
							gh.enterSearchText();
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				//closing the newly opened tab
				//Note this code will not load the Browser where goolge.com page will be opened
				//This code is written with the purpose to ensure that the if condition fails
				//It is a purposefully written code
				drv.close();
				drv.switchTo().window(parent_handle);
				break;
			case 4:
				demo.select_multiple_options();
				break;
			case 5:
				demo.enterdata(drv);
			case 6:
				RemoteWebDriver r = (RemoteWebDriver) drv;
				String script = "window.scrollTo(0,document.body.scrollHeight);";
				Thread.sleep(3000);
				r.executeScript(script);
			case 7:
				demo.scrollToAnElement(drv);
			case 8:
				demo.scrollToAnElement(drv);
				Thread.sleep(2000);
				demo.performMouseOverAction(drv);
			default:
				System.out.println("Invalid choice");
			}
		}while(true);
	}
}











