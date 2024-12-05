package Docsy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class get_in_touch {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://staging.mydocsy.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/nav/div/div[2]/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"contact_request_name\"]")).sendKeys("Bhushan joshi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/div/form/div[1]/div[2]/div/input")).sendKeys("rajat");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"contact_request_email\"]")).sendKeys("joshibhushan425@gmail.com");
        Thread.sleep(2000);
        
        
        WebElement dropdownElement = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/div/form/div[1]/div[5]/select"));
        Thread.sleep(2000);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("India (+91)");
        Thread.sleep(2000);
        WebElement dropdownElement1 = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/div/form/div[1]/div[4]/select"));
        Select dropdown1 = new Select(dropdownElement1);
        dropdown1.selectByVisibleText("Employee Mental Wellness");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"contact_request_number\"]")).sendKeys("1234567890");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/div/form/div[1]/div[7]/div/textarea")).sendKeys("Anxiety specialt"
        		+ "y services within the Psychology division in the Behavioral Health Clinic focus "
        		+ "on specifically on the use of Acceptance and Commitment Therapy (ACT) and exposure"
        		+ " therapy to address issues related to anxiety in youth and adults");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/div/form/div[2]/input")).submit();
        
        
	}

}
