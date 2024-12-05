package Docsy;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class landing_product_resource {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        // Example: System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://staging.mydocsy.com/");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        
        // Home page
        try {
            // Scroll down by 6000 pixels
            js.executeScript("window.scrollBy(0, 6000);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            // Scroll up by 6000 pixels
            js.executeScript("window.scrollBy(0, -6000);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            // Student mental health
            driver.get("https://staging.mydocsy.com/student-mental-health-wellness");
            js.executeScript("window.scrollBy(0, 6000);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, -6000);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            // Employee mental health
            driver.get("https://staging.mydocsy.com/employee-student-mental-health-wellness");
            js.executeScript("window.scrollBy(0, 6000);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, -6000);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            // Resource page (Articles)
            driver.get("https://staging.mydocsy.com/docsy-resources");
            js.executeScript("window.scrollBy(0, 3500);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, -3500);");
            waitForScroll(wait, js);
            Thread.sleep(2000);
            // Return to home page
            driver.get("https://staging.mydocsy.com/");
            wait.until(ExpectedConditions.urlToBe("https://staging.mydocsy.com/"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.quit();
        }
    }

    // Helper method to wait for scroll completion
    private static void waitForScroll(WebDriverWait wait, JavascriptExecutor js) {
        wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
    }
}
