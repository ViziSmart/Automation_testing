package Negative_Testing;

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

public class FB_DeclineTicketBYPM {
	
	
	@Test
	public void declineByPM() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        driver.manage().window().maximize();
        
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+180@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);
        
        //approve ticket process with bidding off
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement Smart_panel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div[3]/div")));
        Smart_panel.click();
        Reporter.log("Clicked on smart panel", true);
        
        Thread.sleep(6000);
        
        WebElement ticket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/table/tbody/tr[3]/td[1]")));
        ticket.click();
        
        WebElement decline= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/button[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", decline);
        Thread.sleep(1000);
        decline.click();
        
        WebElement Reason = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[6]/textarea"));
        Reason.sendKeys("Automation testing");
        
        WebElement confirm_btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[6]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirm_btn);
        confirm_btn.click();
        
        Thread.sleep(2000);
        
        driver.close();
		
	}

}
