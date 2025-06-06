package A_Positive_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class C_LoginOfVendorUsingEmail {

    @Test
    public void Login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh102@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);

        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);

        Thread.sleep(3000);
        Reporter.log("Waited for 3 seconds", true);

        driver.close();
        Reporter.log("Closed the browser", true);
    }
}
