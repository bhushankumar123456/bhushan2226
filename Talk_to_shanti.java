package Docsy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Talk_to_shanti {
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
	            //click on talk to shanti 
	            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[6]/div[1]/div[2]/div[1]/a")).click();
	            Thread.sleep(1000);
	            //click on text input and say something
	            driver.findElement(By.xpath("/html/body/div/div/section/div[2]/div[2]/form/input")).sendKeys("hi janu");
	            Thread.sleep(1000);
	            //click on send 
	            driver.findElement(By.xpath("/html/body/div/div/section/div[2]/div[2]/form/img")).click();
	            Thread.sleep(1000);
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
}}
