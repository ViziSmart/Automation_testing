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

public class FA_InProgressTOScheduleTicketWithBiddingOFF {
		
	@Test(priority = 1)
	public void ApproveByPM() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+5@gmail.com");
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
        
        WebElement Maintenance_ticket= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/table/tbody/tr[2]/td[1]"));
        Maintenance_ticket.click();
        Reporter.log("Click on the maintenance ticket", true);

        
        WebElement Approve_btn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Approve_btn);
        Approve_btn.click();
        Reporter.log("clicked on approve button", true);

               
        Thread.sleep(6000);
       
        driver.close();
        
	}
	
	
	@Test(priority = 2)
	public void ApproveByVendor() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh102+1@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);
        
        //approve ticket process with bidding off
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Notification_icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/div/div")));
        Notification_icon.click();
		
        WebElement ticket = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div.z-50.bottom-0.fixed.left-0.w-screen > div > div.bg-black.p-1.text-white.w-7\\/12.transition-all.top-14.absolute.right-0.h-72.overflow-y-scroll.overflow-hidden.rounded-bl-xl > div:nth-child(1) > div > h1")));
        ticket.click();
        
        Thread.sleep(1000);
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[4]/div/div[1]/textarea")));
        message.sendKeys("Aotumation testing");
        
        WebElement accept_btn= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[4]/div/div[2]/button[1]"));
        
        accept_btn.click();
	}

}
