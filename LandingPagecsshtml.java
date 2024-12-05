package Docsy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class LandingPagecsshtml {
    public static void main(String[] args) {
     

        // Initialize WebDriver (ChromeDriver in this case)
        WebDriver driver = new ChromeDriver();

        // Navigate to the landing page URL
        driver.get("https://mydocsy.com/stay-on-combo-power-pack-hi");

        try {
            // Retrieve the HTML content of the landing page
            String pageHTML = driver.getPageSource();
            System.out.println("Page HTML: \n" + pageHTML);

            // Retrieve the CSS (all stylesheets linked to the page)
            // Inline styles
            String inlineCSS = driver.findElement(By.tagName("style")).getText();
            System.out.println("Inline CSS: \n" + inlineCSS);

            // Optionally, retrieve external CSS files or linked resources.
            // You can find all <link> elements for stylesheets and get their href values.
            // This can be useful for downloading linked external CSS files.
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}
