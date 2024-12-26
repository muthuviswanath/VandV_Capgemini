package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {
	public static void main(String[] args) {
		WebDriver drv = new ChromeDriver();
		drv.manage().window().maximize();
		drv.navigate().to("file:///C:/Users/muthu/OneDrive/Desktop/sample_html/Checkbox.html");
		for (int i =1;i<=11;i+=2) {
			drv.findElement(By.xpath("/html/body/input["+i+"]")).click();
		}
	}
}
//generate unique 3 digit number only using the numbers 1,2,3 and 4 (24)
/*
 *	123	124	132	134	142	143
 *	213	214	231	234	241	243
 *	312	314	321	324	341	342
 *	412	413	421	423	431	432 
 * */

//Make use of 3 nested for loops to achieve it. The inner most for loop is the one which should
// have the condition to check for uniqueness











