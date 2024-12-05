package Docsy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_selling_pay_single_product {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://staging.mydocsy.com/");
            Thread.sleep(1000); // Consider replacing with waits when possible
            
            // Click on login button at home page 
            driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/nav/div/div[2]/a[1]")).click();

            // Enter phone number in text field 
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/form/div[1]/div/input")).sendKeys("9999999993");

            // Click on submit button
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/form/input")).click();

            // Enter OTP 
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[2]/form/div[2]/div/input")).sendKeys("1234567");

            // Click on submit OTP button
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[2]/form/input")).click();

            // At dashboard, click on 'Buy Now' button for the product 
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[6]/div[3]/div[2]/div/div[2]/a[2]")).click();

            // Fill address details
            fillAddressDetails(driver, wait);
            
            // Click on 'Continue' button
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[4]/div[2]/div/form/input[3]")).click();

            // Click on 'Place Order' button 
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[2]/form/div[3]/input[2]")).click();

            // Handle Razorpay redirection
            handleRazorpay(driver, wait);

        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception: " + e.getMessage());
        } finally {
            // Close the browse
        }
    }

    private static void fillAddressDetails(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        try {
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[2]/div[2]/div[1]/div/form/div[1]/div[1]/input")).sendKeys("Gandhi Path West");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[2]/div[2]/div[1]/div/form/div[1]/div[2]/input")).sendKeys("Lalanpura Road near Kiran Marriage Garden");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[2]/div[2]/div[1]/div/form/div[1]/div[3]/input")).sendKeys("Jaipur");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[2]/div[2]/div[1]/div/form/div[1]/div[4]/input")).sendKeys("Rajasthan");
            Thread.sleep(1000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1500)");

            // Add pincode
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[2]/div[2]/div[1]/div/form/div[1]/div[5]/input")).sendKeys("302012");
            Thread.sleep(1000);

            // Click on 'Add Address' button
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div/div[2]/div[2]/div[1]/div/form/div[1]/input[2]")).click();
            Thread.sleep(1000);
            
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable while filling address details: " + e.getMessage());
        }
    }

    private static void handleRazorpay(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        try {
            // Wait for iframe to load
            WebElement razorpayIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(razorpayIframe); // Switch to the iframe

            // Enter test phone number on Razorpay
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[3]/div[2]/div/div/div/form/div[1]/div/label/input")));
            phoneInput.sendKeys("9999999999");

            // Click on proceed after entering phone number
            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[4]/div/button")));
            proceedButton.click();

            // Wait for the dropdown to be clickable and scroll to it if necessary
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[3]/div[2]/div/div/div/div/form/div[3]/div/label[3]/div/div")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
            dropdown.click();

            // Wait for the 'BOB' option to be clickable and scroll to it
            WebElement bobOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mobile-nav > div.overflow-hidden.rounded-xl.border.border-on-surface\\/10.bg-surface.undefined > div > div > div > label:nth-child(1) > div > div")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bobOption);
            bobOption.click();
         // After selecting the BOB option, switch to the new tab
         // Get the current window handle
         String mainWindowHandle = driver.getWindowHandle();

         // Wait for the new tab to open and switch to it
         for (String windowHandle : driver.getWindowHandles()) {
             if (!windowHandle.equals(mainWindowHandle)) {
                 driver.switchTo().window(windowHandle);
                 break;
             }
         }

         // Wait for the success button to be clickable
         WebElement successButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/button[1]")));

         // Click the success button
         successButton.click();
         Thread.sleep(10000); 
         //click on dashboard nav bar
         WebElement Dashboard = wait.until(ExpectedConditions.elementToBeClickable(By.className("primary-hospital-desktop-sidebar-logo")));
         Dashboard.click();
            // Verify that payment was successful
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Payment Successful')]")));
            if (successMessage.isDisplayed()) {
                System.out.println("Payment was successful: " + successMessage.getText());
            } else {
                System.out.println("Payment failed!");
            }

        } catch (NoSuchFrameException e) {
            System.out.println("Could not find the Razorpay iframe: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable while handling Razorpay: " + e.getMessage());
        }
    }
 }

