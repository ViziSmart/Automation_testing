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

public class HA_ApproveQuoteByPM {
	
	@Test
	public void ApproveQuote() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        Reporter.log("ChromeDriver initialized", true);

	        driver.get("https://dev.vizismart.com/login");
	        Reporter.log("Navigated to Login page", true);
	        
	        driver.manage().window().maximize();
	        
	        //Login Process...
	        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
	        emailField.sendKeys("kalyanideshmukh778+180@gmail.com");
	        Reporter.log("Entered Email", true);

	        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
	        password.sendKeys("12345678");
	        Reporter.log("Entered Password", true);

	        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	        Login.click();
	        Reporter.log("Clicked on Login button", true);

	        Thread.sleep(3000);
	        Reporter.log("Waited for 3 seconds", true);
	        
	        //Approve quote by vendor process...
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement Notification_icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/div/div")));
	        Notification_icon.click();
	        
	        WebElement ticket =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div.z-50.bottom-0.fixed.left-0.w-screen > div > div.bg-black.p-1.text-white.w-7\\/12.transition-all.top-14.absolute.right-0.h-72.overflow-y-scroll.overflow-hidden.rounded-bl-xl > div:nth-child(1) > div > h1")));
	        ticket.click();
	        
	        Thread.sleep(2000);
	        
	        WebElement approve_btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div[3]/button[1]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve_btn);
	        approve_btn.click();
	        
	        
	        WebElement yes_approve = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[6]/button[1]")));
	        yes_approve.click();
	        
	        
	        Thread.sleep(2000);
	        
	        driver.close();
	}

}
