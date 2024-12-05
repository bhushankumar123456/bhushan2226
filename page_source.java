package Docsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class page_source {
	
	    public static void main(String[] args) {
	        // Set the path of the ChromeDriver
	       
	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        // Open the landing page
	        driver.get("https://mydocsy.com/stay-on-combo-power-pack-hi");

	        // Get the page source (HTML code)
	        String pageSource = driver.getPageSource();

	        // Print the page source
	        System.out.println(pageSource);

	        // Close the browser
	        driver.quit();
	    }
	}


