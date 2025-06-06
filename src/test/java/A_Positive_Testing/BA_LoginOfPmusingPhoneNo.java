package A_Positive_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BA_LoginOfPmusingPhoneNo {
	
	@Test
	public void login_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);

        WebElement PhoneNo = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        PhoneNo.sendKeys("8530921573");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);

        // Wait for the next page or expected element to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]/div[1]/a")));

        // Assert the presence of the success element
        if (successElement.isDisplayed()) {
            System.out.println("Test Passed: Signup process completed successfully.");
        } else {
            System.out.println("Test Failed: Success message not displayed.");
        }
        
        Thread.sleep(3000);
        Reporter.log("Waited for 2 seconds", true);

        driver.close();
        Reporter.log("Closed the browser", true);
    }

}
