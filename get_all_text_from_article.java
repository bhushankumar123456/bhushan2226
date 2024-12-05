package Docsy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class get_all_text_from_article {
           public static void main(String[] args) {
               WebDriver driver = new ChromeDriver();
               driver.manage().window().maximize();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    // Initialize the WebDriver
                       try {
                           // Open the website
                           driver.get("https://staging.mydocsy.com/");

                           // jo dikh raha hai utha le
                           String visibleText = driver.findElement(By.tagName("body")).getText();

                           // Print the visible text content
                           System.out.println("\nVisible Text Content:");
                           System.out.println(visibleText);

                       } finally {
                           // Close the browser
                           driver.quit();
                       }
                   }}

