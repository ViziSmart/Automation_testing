package A_Positive_Testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class D_LogoutForPM {

    @Test
    public void logout() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        // Login process
        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+180@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);

        // Logout process
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Humberger_icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div.z-50.bottom-0.fixed.left-0.w-screen > div > div.flex.px-4.z-10.relative.justify-between.bg-black.p-2.py-4.items-center > div > svg")));
        Humberger_icon.click();
        Reporter.log("Clicked on corner bar to expand menu", true);


        WebElement logout_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/label")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logout_btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout_btn);
        Reporter.log("Clicked on Logout button", true);

        Thread.sleep(2000);
        Reporter.log("Waited for 4 seconds", true);

        driver.close();
        Reporter.log("Closed the browser", true);
    }
}
