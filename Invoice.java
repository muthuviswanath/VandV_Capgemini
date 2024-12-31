package scenarios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoice{
	 public static void main(String[] args) {
	        
	        WebDriver driver = new ChromeDriver();

	        String url = "file:///C:/Users/muthu/OneDrive/Desktop/sample_html/demopage.html";  // Update path to your local file
	        driver.get(url);

	        WebElement table = driver.findElement(By.id("product"));
	        List<WebElement> rows = table.findElements(By.tagName("tr"));

	        Map<String, Integer> productPriceMap = new HashMap();
	        Map<String, String> productAuthorMap = new HashMap<>();
	        for (int i = 1; i < rows.size(); i++) {  // Skip header
	            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
	            String author = cols.get(0).getText();
	            String itemDesc = cols.get(1).getText();
	            int amount = Integer.parseInt(cols.get(2).getText());
	            productPriceMap.put(itemDesc, amount);
	            productAuthorMap.put(itemDesc, author);
	        }

	        System.out.println("Available Products:");
	        int index = 1;
	        for (String product : productPriceMap.keySet()) {
	            System.out.println(index + ". " + product + " - Rs. " + productPriceMap.get(product));
	            index++;
	        }

	        Scanner scanner = new Scanner(System.in);
	        List<String> selectedProducts = new ArrayList();
	        List<Integer> quantities = new ArrayList<>();

	        while (true) {
	            System.out.print("Enter the product name (or type 'done' to finish): ");
	            String productName = scanner.nextLine();

	            if (productName.equalsIgnoreCase("done")) {
	                break;
	            }

	            if (productPriceMap.containsKey(productName)) {
	                System.out.print("Enter quantity for " + productName + ": ");
	                int quantity = scanner.nextInt();
	                scanner.nextLine();  // Consume newline

	                selectedProducts.add(productName);
	                quantities.add(quantity);
	            } else {
	                System.out.println("Product not found. Please try again.");
	            }
	        }

	        System.out.println("================================================================================================================");
	        System.out.println("Date: " + "27-Dec-2024"+ "                   CapgeminiPvt Ltd                            GST: 112345678");
	        System.out.println("\n                                    Commercial Invoice");
	        System.out.println("================================================================================================================");
	        System.out.printf("%-10s %-30s %-15s %-15s %-20s %-15s %n", "S.No", "Item Description", "Amount", "Quantity", "Author", "Price");
	        System.out.println("----------------------------------------------------------------------------------------------------------------");

	        double totalPrice = 0;
	        for (int i = 0; i < selectedProducts.size(); i++) {
	            String productName = selectedProducts.get(i);
	            int quantity = quantities.get(i);
	            int amount = productPriceMap.get(productName);
	            double price = amount * quantity;
	            totalPrice += price;
	            System.out.printf("%-10d %-30s %-15d %-15d %-20s %-15.2f %n", (i + 1), productName, amount, quantity, productAuthorMap.get(productName), price);
	        }

	        double cgst = totalPrice * 0.09;
	        double sgst = totalPrice * 0.09;
	        double discount = totalPrice * 0.03;
	        double finalPrice = totalPrice + cgst + sgst - discount;

	        System.out.println("----------------------------------------------------------------------------------------------------------------");
	        System.out.printf("%-50s %-25s %15.2f %n", "", "Grand Total", totalPrice);
	        System.out.printf("%-50s %-25s %15.2f %n", "", "C.GST 9%", cgst);
	        System.out.printf("%-50s %-25s %15.2f %n", "", "S.GST 9%", sgst);
	        System.out.printf("%-50s %-25s %15.2f %n", "", "Discount of 3%", -discount);
	        System.out.println("================================================================================================================");
	        System.out.printf("%-50s %-25s %15.2f %n", "", "Final Price", finalPrice);
	        System.out.println("================================================================================================================");
	        System.out.println("                                    Thank You for your Order");

	        driver.quit();
	    }
	}

