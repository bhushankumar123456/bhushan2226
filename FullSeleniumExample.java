package bhushan2226;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FullSeleniumExample {

    public static void main(String[] args) {

        // Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit Wait

        // Open URL
        driver.get("https://www.example.com");

        // --- 1. Finding Elements ---

        // Find element by ID
        WebElement elementById = driver.findElement(By.id("submit"));
        elementById.click();

        // Find element by Name and sending text
        WebElement elementByName = driver.findElement(By.name("username"));
        elementByName.sendKeys("TestUser");

        // Find element by XPath and perform actions
        WebElement elementByXpath = driver.findElement(By.xpath("//button[text()='Click Me']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementByXpath).click().build().perform();


        // --- 2. Explicit Wait ---
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement waitElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("dynamicElement")));
        waitElement.click();

        // --- 3. Handling Alerts ---
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();  // Accept alert
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }

        // --- 4. Switching to Frames ---
        driver.switchTo().frame("frameName"); // Switch to frame by name or ID

        // --- 5. Handling Multiple Windows ---
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle); // Switch to new window
                break;
            }
        }

        // --- 6. Taking Screenshots ---
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- 7. Scrolling the Page ---
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");  // Scroll down 500px

        // --- 8. Handling Dropdown ---
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");  // Select by visible text

        // --- 9. Drag and Drop ---
        WebElement source = driver.findElement(By.id("source"));
        WebElement target = driver.findElement(By.id("target"));
        actions.dragAndDrop(source, target).perform();

        // --- 10. Verifying Page Title ---
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        if (title.equals("Expected Title")) {
            System.out.println("Title matches!");
        } else {
            System.out.println("Title doesn't match.");
        }

        // --- 11. Verifying Current URL ---
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // --- 12. Navigating Browser History ---
        driver.navigate().back();  // Go back in browser history
        driver.navigate().forward();  // Go forward in browser history
        driver.navigate().refresh();  // Refresh the page

        // --- 13. Handling Checkboxes and Radio Buttons ---
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        if (!checkbox.isSelected()) {
            checkbox.click();  // Select checkbox if not already selected
        }

        WebElement radioButton = driver.findElement(By.id("radioButton"));
        if (!radioButton.isSelected()) {
            radioButton.click();  // Select radio button if not already selected
        }

        // --- 14. Handling Multiple Elements ---
        List<WebElement> elements = driver.findElements(By.className("listItem"));
        for (WebElement item : elements) {
            System.out.println("Item: " + item.getText());
        }

        // --- 15. Verifying and Waiting for Elements ---
        WebElement elementToVerify = driver.findElement(By.id("verify"));
        if (elementToVerify.isDisplayed()) {
            System.out.println("Element is displayed.");
        } else {
            System.out.println("Element is not displayed.");
        }

        // --- 16. Handling Dynamic Elements ---
        WebElement dynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dynamicElement")));
        dynamicElement.click();

        // --- 17. Keyboard Actions ---
        WebElement inputField = driver.findElement(By.id("input"));
        actions.sendKeys(inputField, "Test Data").perform();  // Type text into input field
        actions.sendKeys(Keys.ENTER).perform();  // Press ENTER key

        // --- 18. Handling Modals ---
        WebElement modalTrigger = driver.findElement(By.id("modalTrigger"));
        modalTrigger.click();  // Open modal
        WebElement modalCloseButton = driver.findElement(By.id("modalCloseButton"));
        modalCloseButton.click();  // Close modal

        // --- 19. Handling File Uploads ---
        WebElement fileUploadInput = driver.findElement(By.id("fileUpload"));
        fileUploadInput.sendKeys("C:\\path\\to\\file.txt");  // Upload file

        // --- 20. Handling Pop-ups (Non-Alert Popups) ---
        WebElement popupTrigger = driver.findElement(By.id("popupTrigger"));
        popupTrigger.click(); // Trigger non-alert popup
        WebElement popupCloseButton = driver.findElement(By.id("popupCloseButton"));
        popupCloseButton.click(); // Close non-alert popup

        // --- 21. Handling Cookies ---
        // Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Cookie: " + cookie.getName() + " = " + cookie.getValue());
        }

        // Add a new cookie
        Cookie newCookie = new Cookie("myCookie", "cookieValue");
        driver.manage().addCookie(newCookie);

        // Delete a cookie
        driver.manage().deleteCookieNamed("myCookie");

        // --- 22. Handling JavaScript Execution ---
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("alert('This is a custom alert message!');");

        // --- 23. Performance Testing ---
        long startTime = System.currentTimeMillis();
        driver.get("https://www.example.com");
        long endTime = System.currentTimeMillis();
        System.out.println("Page load time: " + (endTime - startTime) + " milliseconds.");

        // --- 24. Handling Shadow DOM ---
        WebElement shadowHost = driver.findElement(By.id("shadowHost"));
        WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].shadowRoot", shadowHost);
        WebElement shadowElement = shadowRootElement.findElement(By.id("shadowElement"));
        shadowElement.click();

        // --- 25. Handling File Downloads ---
        String downloadDir = "C:\\Downloads";
        WebDriverWait waitForDownload = new WebDriverWait(driver, Duration.ofSeconds(30));
        File downloadFile = new File(downloadDir + "\\downloadedFile.extension");

        waitForDownload.until(driver -> downloadFile.exists()); // Wait until the file is downloaded
        System.out.println("File downloaded successfully!");

        // --- 26. Handling Browser Window Resizing ---
        driver.manage().window().setSize(new Dimension(1200, 800)); // Resize browser window

        // --- 27. Handling Keyboard Shortcuts ---
        actions.sendKeys(Keys.chord(Keys.CONTROL, "a")).perform();  // Select All text using Ctrl+A
        actions.sendKeys(Keys.chord(Keys.CONTROL, "c")).perform();  // Copy text using Ctrl+C

        // --- 28. Multi-Threaded Selenium Testing ---
        // This would require TestNG or JUnit framework for parallel testing, which is not shown here.

        // --- 29. Closing the Browser ---
        driver.quit();  // Close all windows and end the session


       

        // --- Hover, Double Click, Right Click (Mouse Actions) ---
        Actions actions = new Actions(driver);
        WebElement hoverElement = driver.findElement(By.id("hoverElement"));
        actions.moveToElement(hoverElement).perform();  // Hover over element

        WebElement doubleClickElement = driver.findElement(By.id("doubleClick"));
        actions.doubleClick(doubleClickElement).perform();  // Double click on element

        WebElement rightClickElement = driver.findElement(By.id("rightClick"));
        actions.contextClick(rightClickElement).perform();  // Right click on element

        // --- Handling JavaScript Disabled Elements ---
        WebElement disabledElement = driver.findElement(By.id("disabledElement"));
        if (disabledElement.isEnabled()) {
            disabledElement.sendKeys("Text");
        } else {
            System.out.println("Element is disabled.");
        }

        // --- Browser Window Management (Maximize, Minimize, Switch) ---
        driver.manage().window().maximize();  // Maximize window
        driver.manage().window().minimize();  // Minimize window

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // --- Handling Alerts (Confirm, Prompt, Dismiss, Send Text to Prompt) ---
        Alert alert = driver.switchTo().alert();
        alert.accept();  // Accept the alert

        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();  // Dismiss the alert

        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Sample text");
        promptAlert.accept();  // Send text to the prompt and accept

        // --- Taking Full Page Screenshots (Including Scrolling) ---
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("fullPageScreenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Handling Hidden Elements (Invisible Elements) ---
        WebElement hiddenElement = driver.findElement(By.id("hiddenElement"));
        if (hiddenElement.isDisplayed()) {
            hiddenElement.click();
        } else {
            System.out.println("Element is hidden.");
        }

        // --- Handling Selectable Text (Selecting Text from Element) ---
        WebElement textElement = driver.findElement(By.id("selectableText"));
        String text = textElement.getText();  // Get text from an element
        System.out.println("Text: " + text);

        // --- File Upload Using SendKeys (Selecting File via Dialog) ---
        WebElement fileUpload = driver.findElement(By.id("fileInput"));
        fileUpload.sendKeys("C:\\path\\to\\file.txt");  // Upload file

        // --- Verifying Element Visibility and Presence (Visibility vs Existence) ---
        WebElement element = driver.findElement(By.id("elementId"));
        if (element.isDisplayed()) {
            System.out.println("Element is visible.");
        } else {
            System.out.println("Element is not visible.");
        }

        // --- Handling Pop-ups (File Upload Popups, Custom Popups) ---
        WebElement uploadButton = driver.findElement(By.id("uploadButton"));
        uploadButton.click();  // Trigger the file upload pop-up

        // --- Handling Timeouts (Implicit, Explicit, Fluent Waits) ---
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicElement")));
        dynamicElement.click();

        // --- Handling Dropdowns and Multi-Select ---
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");  // Select by visible text

        Select multiSelectDropdown = new Select(driver.findElement(By.id("multiSelectDropdown")));
        multiSelectDropdown.selectByIndex(2);  // Multi-select by index

        // --- Working with Action Chains (Multiple Actions in Sequence) ---
        actions.moveToElement(driver.findElement(By.id("element1")))
               .click()
               .moveToElement(driver.findElement(By.id("element2")))
               .click()
               .perform();

        // --- Handling Alerts with JavaScriptExecutor ---
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('This is a JavaScript Alert!');");

        // --- Closing the Browser ---
        driver.quit();


        // --- JavaScript Execution (Alerts, Scroll) ---
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Triggering an alert using JavaScript
        js.executeScript("alert('This is a JavaScript Alert!');");
        
        // Scrolling the page using JavaScript
        js.executeScript("window.scrollBy(0,500)"); // Scroll down by 500px
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // Scroll to bottom of page

        // --- Performance Testing (Page Load Time) ---
        long startTime = System.currentTimeMillis();
        driver.get("https://www.example.com");
        long endTime = System.currentTimeMillis();
        long pageLoadTime = endTime - startTime;
        System.out.println("Page Load Time: " + pageLoadTime + "ms");

        // --- Shadow DOM Handling ---
        WebElement shadowHost = driver.findElement(By.cssSelector("#shadowHostElement"));
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector(".shadowElement"));
        shadowElement.click();  // Interacting with an element inside the shadow DOM

        // --- File Downloads ---
        // Downloading a file by triggering the download link (Assuming file download is automatically handled)
        WebElement downloadLink = driver.findElement(By.id("downloadLink"));
        downloadLink.click();  // Trigger the download

        // Verify file exists in the download directory
        File downloadedFile = new File("C:\\Users\\User\\Downloads\\fileName.ext");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully.");
        } else {
            System.out.println("File not found.");
        }

        // --- Keyboard Shortcuts (Ctrl + A, Ctrl + C) ---
        Actions actions = new Actions(driver);

        // Pressing Ctrl + A (Select All)
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        // Pressing Ctrl + C (Copy)
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        // --- Window Resizing ---
        driver.manage().window().setSize(new Dimension(1024, 768));  // Resizing window to specific dimensions
        driver.manage().window().maximize();  // Maximizing the window

        // --- Handling Multiple Windows ---
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);  // Switch to the new window
                break;
            }
        }

        // --- Handling Alerts (Accept, Dismiss) ---
        Alert alert = driver.switchTo().alert();
        alert.accept();  // Accept the alert
        alert.dismiss(); // Dismiss the alert

        // --- Closing the Browser ---
        driver.quit();
    }
}