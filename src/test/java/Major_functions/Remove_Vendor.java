package Major_functions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Remove_Vendor extends BaseTest {
	
	public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    
    @Test
    public void remove() throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        
        Reporter.log("Launching the application", true);
        driver.get("https://dev.vizismart.com/login");
        
        // Login process...
        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+5@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        

        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Reporter.log("Implicit wait set for 2 seconds", true);

        // Add vendor process...
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement select_prop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
        select_prop.click();
        Reporter.log("Select property to add vendor", true);



        By vendor_section_single= By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/button[2]");
        By vendor_section_doublt= By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/button[3]");
        
        
        if (isElementPresent(driver, vendor_section_single)) {
            WebElement firstElement = driver.findElement(vendor_section_single);
            firstElement.click();
            System.out.println("First element clicked.");
        } else {
            WebElement secondElement = driver.findElement(vendor_section_doublt);
            secondElement.click();
            System.out.println("Second element clicked.");
        }
        
        Thread.sleep(1000);
        
        WebElement removeBtn = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[2]/div/div/div[2]/div/button[2]"));

     // Scroll into view
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", removeBtn);

     // Small delay to allow scroll to complete (if needed)
     Thread.sleep(500);

     // Optional: Highlight to verify visibility (for debugging)
     ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", removeBtn);

     // Click the button
     removeBtn.click();
        
        WebElement sureBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        sureBtn.click();
        
        Reporter.log("Vendor removal confirmed", true);
        
        Thread.sleep(3000);
        
        Reporter.log("Closing the browser", true);
        driver.close();
    }

}
