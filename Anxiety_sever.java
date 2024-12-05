package Docsy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Anxiety_sever {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("https://staging.mydocsy.com/");
            Thread.sleep(1500); // Waiting for the page to load fully
            driver.manage().window().fullscreen();
            
            // Click on start free test now button
            WebElement startFreeTestButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/d"
                		+ "iv/div[2]/div/a[1]")));
            startFreeTestButton.click();
            
            // Number text field
            WebElement phoneNumberField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/di"
                		+ "v/div/div/div/div/div[2]/div[1]/div[3]/div[1]/form/div/div/input")));
            phoneNumberField.sendKeys("9999999997");
            Thread.sleep(1500);
            // Click on send OTP button
            WebElement sendOtpButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div"
                		+ "/div/div/div/div/div[2]/div[1]/div[3]/div[1]/form/input")));
            sendOtpButton.click();
            Thread.sleep(1500);
            // Enter OTP
            WebElement otpField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div"
                		+ "/div/div/div/div/div[2]/div[1]/div[3]/div[2]/form/div[2]/div/input")));
            otpField.sendKeys("1234567");
            Thread.sleep(1500);
            // Click on submit
            WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div/"
                		+ "div/div/div/div/div[2]/div[1]/div[3]/div[2]/form/input")));
            submitButton.click();
            Thread.sleep(1500);
            // Handle choose hospital
            WebElement chooseHospitalButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div["
                		+ "2]/div/a[1]/div")));
            chooseHospitalButton.click();
            Thread.sleep(1500);
            // click on view past result 
            driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul/li[2]/a")).click();
            
            //  handle the sychart popup if it appears
            driver.findElement(By.xpath("/html/body/section/div[4]/div[7]/a")).click();
            
            
            
            WebElement newSychartButton = driver.findElement(By.xpath("/html/body/section/div[4]/div[7]/a"));
            newSychartButton.click();

            // Handle the sychart popup if it appears
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).isDisplayed()) {
                WebElement startOverButton = driver.findElement(By.xpath("/html/body/section/div[4]/div[4]/div/div/div/div[2]/div[1]/form/input[1]"));
                startOverButton.click();
                System.out.println("Clicked Start Over button on popup.");
            } else {
                System.out.println("No popup appeared. Proceeding with new sychart.");
                // Click on new sychart button again in case popup does not appear
                newSychartButton.click();
            }
            
            
            
            Thread.sleep(1500);
            // Wait for iframe to be available and switch to it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("sychart-iframe")));
            System.out.println("Switched to iframe.");

            // Scroll to make sure elements are in the viewport
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Verify elements inside the iframe
            WebElement iframeContent = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/"
            		+ "body/div[2]/div[3]")));
            System.out.println("Found content inside iframe: " + iframeContent.getText());

            // Scroll to next button and click on next button in intro screen inside the iframe
            WebElement nextButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/"
            		+ "body/div[2]/div[3]/div[3]/div/div[3]/div")));
            js.executeScript("arguments[0].scrollIntoView(true);", nextButtonInIframe);
            nextButtonInIframe.click();
            System.out.println("Clicked next button inside iframe.");
            Thread.sleep(1500);
            // Verify elements inside the iframe after clicking next
            WebElement iframeContent1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/bod"
            		+ "y/div[2]/div[3]")));
            System.out.println("Found content inside iframe: " + iframeContent1.getText());
            Thread.sleep(1500);
            // Scroll to Start button and click on Start button in intro screen inside the iframe
            WebElement startButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/bod"
            		+ "y/div[2]/div[3]/div[2]/div/div/ul/li[2]/button")));
            js.executeScript("arguments[0].scrollIntoView(true);", startButtonInIframe);
            startButtonInIframe.click();
            System.out.println("Clicked Start button inside iframe.");
            Thread.sleep(1500);
            WebElement iframeContent11 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/bod"
            		+ "y/div/div[2]")));
            System.out.println("Found content inside iframe: " + iframeContent11.getText());
            
            
            // Scroll to and click on anxiety department
            WebElement clickonanxietyButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/ht"
            		+ "ml/body/div/div[2]/div[1]/div")));
            js.executeScript("arguments[0].scrollIntoView(true);", clickonanxietyButtonInIframe);
            clickonanxietyButtonInIframe.click();
            System.out.println("Clicked on anxiety department inside iframe.");
            Thread.sleep(1500);
            // Start sychart and answer questions
            WebElement yesButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/"
            		+ "di"
            		+ "v[1]/div/div[4]/div/button[1]")));
            js.executeScript("arguments[0].scrollIntoView(true);", yesButtonInIframe);
            yesButtonInIframe.click();
            System.out.println("Clicked yes button inside sychart.");
            Thread.sleep(1500);
            //1st question
            WebElement question1ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/di"
            		+ "v[4]/div[1]/div[4]/div/div")));
            js.executeScript("arguments[0].scrollIntoView(true);", question1ButtonInIframe);
            question1ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //2nd question
            WebElement question2ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/di"
            		+ "v/div[1]/div/div[4]/div[1]/div[4]/div/div")));
            js.executeScript("arguments[0].scrollIntoView(true);", question2ButtonInIframe);
            question2ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //3rd question
            WebElement question3ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/d"
            		+ "iv[1]/div/div[4]/div[1]/div[4]/div/div")));
            js.executeScript("arguments[0].scrollIntoView(true);", question3ButtonInIframe);
            question3ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //4th question
            WebElement question4ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div"
            		+ "[1]/div/div[4]/div[1]/div[4]/div/div")));
            js.executeScript("arguments[0].scrollIntoView(true);", question4ButtonInIframe);
            question4ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //5th question
            WebElement question5ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div["
            		+ "1]/div/div[4]/div[1]/button[4]")));
            js.executeScript("arguments[0].scrollIntoView(true);", question5ButtonInIframe);
            question5ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //6th question
            WebElement question6ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]"
            		+ "/div/div[4]/div[1]/button[4]")));
            js.executeScript("arguments[0].scrollIntoView(true);", question6ButtonInIframe);
            question6ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //7th question
            WebElement question7ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/"
            		+ "div/div[4]/div[1]/button[4]")));
            js.executeScript("arguments[0].scrollIntoView(true);", question7ButtonInIframe);
            question7ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //8th question
            WebElement question8ButtonInIframe = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]"
            		+ "/div/div[4]/div[1]/button[4]")));
            js.executeScript("arguments[0].scrollIntoView(true);", question8ButtonInIframe);
            question8ButtonInIframe.click();
            System.out.println("Clicked 4th option button inside sychart.");
            Thread.sleep(1500);
            //click on dashboard
            driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul/li[1]/a")).click();
            Thread.sleep(1500);
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Do not close the browser
            // driver.quit();
        }
    }
}
