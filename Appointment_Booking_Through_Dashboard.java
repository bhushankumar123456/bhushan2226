package Docsy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appointment_Booking_Through_Dashboard {

    public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Navigate to the website
            driver.get("https://staging.mydocsy.com/");
            
            // Perform Login
            performLogin(driver);

            // Handle appointment booking
            handleBooking(driver, wait);

            // Handle Razorpay payment
            handleRazorpay(driver, wait);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            driver.quit(); // Close the browser
        }
    }

    private static void performLogin(WebDriver driver) throws InterruptedException {
        // Click on login button at home page
        driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/nav/div/div[2]/a[1]")).click();

        // Enter phone number in text field
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/form/div[1]/div/input"))
              .sendKeys("9999999993");

        // Click on submit button
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/form/input"))
              .click();

        // Enter OTP
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[2]/form/div[2]/div/input"))
              .sendKeys("1234567");

        // Click on submit OTP button
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[3]/div[2]/form/input"))
              .click();
    }

    private static void handleBooking(WebDriver driver, WebDriverWait wait) {
        try {
            // Click on "Schedule Appointment" button
            WebElement scheduleButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/section/div[4]/div[6]/div[1]/div[2]/div[2]/a")));
            scheduleButton.click();

            // Click on "Book Appointment" button
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[6]/div/div[4]/div/div/div[2]/div[2]/div[2]/a"))
                  .click();

            // Click on the next month button
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div[2]/div[2]/div[1]/div/div[3]/div[3]"))
                  .click();

            // Find all available dates
            List<WebElement> availableDates = driver.findElements(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div[2]"));
            if (!availableDates.isEmpty()) {
                // Click on the latest date
                availableDates.get(availableDates.size() - 1).click();
            } else {
                System.out.println("No available dates found!");
                return;
            }

            // Find all available time slots
            List<WebElement> availableTimes = driver.findElements(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div[2]"));
            if (!availableTimes.isEmpty()) {
                // Click on the latest available time slot
                availableTimes.get(availableTimes.size() - 1).click();
            } else {
                System.out.println("No available time slots found!");
                return;
            }

            // Confirm the selected time
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/form/input[2]"))
                  .click();

            // Click on "Pay Now" button
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/section/div[4]/div[5]/div[2]/div/div[2]/form/input[3]"))
                  .click();

        } catch (Exception e) {
            System.out.println("Exception during booking: " + e.getMessage());
        }
    }

    private static void handleRazorpay(WebDriver driver, WebDriverWait wait) {
        try {
            // Wait for Razorpay iframe to load
            WebElement razorpayIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(razorpayIframe);

            // Enter test phone number
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div[1]/div/div[3]/div[2]/div/div/div/form/div[1]/div/label/input")));
            phoneInput.sendKeys("9999999999");

            // Click on proceed button
            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div[1]/div/div[4]/div/button")));
            proceedButton.click();

            // Select payment method
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div[1]/div/div[3]/div[2]/div/div/div/div/form/div[3]/div/label[3]/div/div")));
            dropdown.click();

            // Handle new tab after selecting payment method
            String mainWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Click on success button
            WebElement successButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/form/button[1]")));
            successButton.click();

        } catch (Exception e) {
            System.out.println("Exception during Razorpay handling: " + e.getMessage());
        }
    }
}
