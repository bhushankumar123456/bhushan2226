package Docsy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class submit_feedback_for_web {
     public static void main(String[] args) throws InterruptedException {
		    	 WebDriver driver = new ChromeDriver();
		         driver.manage().window().maximize();
		         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		         driver.get("https://staging.mydocsy.com/");
	            // Click on login button at home page 
	            driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/nav/div/div"
	            		+ "[2]/a[1]")).click();

	            // Enter phone number in text field 
	            Thread.sleep(1000);
	            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div"
	            		+ "[2]/div[1]/div[3]/div[1]/form/div[1]/div/input")).sendKeys("9999999997");

	            // Click on submit button
	            Thread.sleep(1000);
	            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div"
	            		+ "[2]/div[1]/div[3]/div[1]/form/input")).click();

	            // Enter OTP 
	            Thread.sleep(1000);
	            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div"
	            		+ "[2]/div[1]/div[3]/div[2]/form/div[2]/div/input")).sendKeys("1234567");

	            // Click on submit OTP button
	            Thread.sleep(1000);
	            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]"
	            		+ "/div[1]/div[3]/div[2]/form/input")).click();
	            Thread.sleep(1000);
	            //click on feedback hanging button
	            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/button[2]")).click();
	            Thread.sleep(1000);
	            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[4]/div/form/div/div[2]/div[3]/"
	            		+ "div/textarea")).sendKeys("this is niche website for mental health");
	            Thread.sleep(1000);
	            //click on 5 star rating
	            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[4]/div/form/div/div[2]/div[2]/div/div[5]")).click();
	            Thread.sleep(1000);
	         //click on feedback submit button 
	            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[4]/div/form/div/div[2]/div[4]/input[3]")).click();
	            Thread.sleep(1000);
	            driver.quit();
	            		
	            		
	         
	}
}
