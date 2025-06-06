package A_Positive_Testing;

import java.time.Duration; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AE_ActivateProperty {

    @Test
    @SuppressWarnings("deprecation")
    public void activate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+11@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        

        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Reporter.log("Implicit wait set for 2 seconds", true);
        
        Thread.sleep(2000);
        // Activate Property module
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ActivateAll_toggle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Properties9\"]/div/label/div")));
        ActivateAll_toggle.click();
        Reporter.log("Clicked on Activate toggle button", true);

        WebElement sure_btn = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sure_btn);
        sure_btn.click();
        Reporter.log("Clicked on Sure button to confirm activation", true);

        Thread.sleep(4000);
        Reporter.log("Waited for 4 seconds", true);

        driver.close();
        Reporter.log("Closed the browser", true);
    }
}
