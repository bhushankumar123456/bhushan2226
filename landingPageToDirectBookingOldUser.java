package Docsy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class landingPageToDirectBookingOldUser {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/bhushan/chromedriver"); // Update this path
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://staging.mydocsy.com/");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        
        // Home page
        try {
            // Scroll down by 6000 pixels
            js.executeScript("window.scrollBy(0, 6000);");
            Thread.sleep(2000);
            // Scroll up by 6000 pixels
            js.executeScript("window.scrollBy(0, -6000);");
            Thread.sleep(2000);
            
            // Student mental health
            driver.get("https://staging.mydocsy.com/student-mental-health-wellness");
            js.executeScript("window.scrollBy(0, 6000);");
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, -6000);");
            Thread.sleep(2000);
            
            // Employee mental health
            driver.get("https://staging.mydocsy.com/employee-student-mental-health-wellness");
            js.executeScript("window.scrollBy(0, 6000);");
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, -6000);");
            Thread.sleep(2000);
            
            // Resource page (Articles)
            driver.get("https://staging.mydocsy.com/docsy-resources");
            js.executeScript("window.scrollBy(0, 3500);");
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, -3500);");
            Thread.sleep(2000);
            
            driver.get("https://staging.mydocsy.com/");
            Thread.sleep(2000);
            
            // Click on book therapist now button
            driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div/a[2]")).click();
            Thread.sleep(2000);
            
            // Username and password
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div[2]/a")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[2]/form/div/div[1]/input")).sendKeys("lowell_davis"); // Username
            driver.findElement(By.xpath("//*[@id=\"patient_password\"]")).sendKeys("5Vd9ublW9Gs="); // Password
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"new_patient\"]/div/div[3]/input")).click();
            Thread.sleep(2000);
            
            // Click on book now button
            driver.findElement(By.xpath("/html/body/section/div[4]/div[4]/div/div[1]/div/div/div[2]/div[2]/a")).click();
            Thread.sleep(2000);
            
            // Click on next month button
            driver.findElement(By.xpath("/html/body/section/div[4]/div[4]/div[2]/div[2]/div[1]/div/div[3]/div[3]")).click();
            Thread.sleep(2000);
            
            // Click on 14 date
            driver.findElement(By.xpath("/html/body/section/div[4]/div[4]/div[2]/div[2]/div[1]/div/div[5]/div[14]")).click();
            Thread.sleep(2000);
            
            // Click on 10:00 time slot
            driver.findElement(By.xpath("/html/body/section/div[4]/div[4]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]")).click();
            Thread.sleep(2000);
            
            // Click on confirm
            WebElement confirmButton = driver.findElement(By.xpath("/html/body/section/div[4]/div[4]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/form/input[2]"));
            js.executeScript("arguments[0].scrollIntoView(true);", confirmButton); // Scroll to the confirm button
            confirmButton.click();
            Thread.sleep(2000);
            
            // Click on pay now button
            WebElement payNowButton = driver.findElement(By.xpath("/html/body/section/div[4]/div[4]/div[2]/div/div[2]/a"));
            js.executeScript("arguments[0].scrollIntoView(true);", payNowButton); // Scroll to the pay now button
            payNowButton.click();
            Thread.sleep(2000);
            
            // Razorpay payment process
            WebElement phoneNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contact']")));
            if (phoneNumberInput != null) {
                System.out.println("Phone number input field is visible.");
                // Enter a phone number
                phoneNumberInput.sendKeys("9876543210");
            } else {
                System.out.println("Phone number input field is not found.");
            }

            // Wait for the 'Proceed' button to be clickable
            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[4]/form/div[4]/div/button")));
            if (proceedButton != null) {
                System.out.println("Proceed button is clickable.");
                // Click the 'Proceed' button
                proceedButton.click();
            } else {
                System.out.println("Proceed button is not found.");
            }
            
            // Wait for a few seconds to observe the actions
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
