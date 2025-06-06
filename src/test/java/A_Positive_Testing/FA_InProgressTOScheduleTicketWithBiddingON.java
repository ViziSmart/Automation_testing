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

public class FA_InProgressTOScheduleTicketWithBiddingON {
	
	 @Test(priority = 1)
	    public void approveByPM() throws InterruptedException {
	        
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
	        
	        //approve ticket process with bidding on
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        WebElement Smart_panel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div[3]/div")));
	        Smart_panel.click();
	        Reporter.log("Clicked on Notification icon", true);
	        
	        Thread.sleep(2000);
	        WebElement Maintenance_ticket= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/table/tbody/tr[1]/td[1]")));
	        Maintenance_ticket.click();
	        Reporter.log("Click on the maintenance ticket", true);
	        
	        WebElement Bidding_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[4]/button")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Bidding_btn);
	        Thread.sleep(1000);
	        Bidding_btn.click();
	        Reporter.log("While approving the ticket make sure bidding is ON", true);
	        
	        
	        WebElement AcceptBidding = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[6]/button[1]")));
	        AcceptBidding.click();
	        Reporter.log("Accept the bidding ON", true);
	        

	        WebElement Approve_btn= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[5]/button[1]"));
	        Approve_btn.click();
	        Reporter.log("clicked on approve button", true);
	        
	        Thread.sleep(10000);

	        
	        driver.close();
	    }
	 
	 
	 @Test(priority = 2)
	 public void addquoteByvendor() throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        Reporter.log("ChromeDriver initialized", true);

	        driver.get("https://dev.vizismart.com/login");
	        Reporter.log("Navigated to Login page", true);
	        
	        driver.manage().window().maximize();
	        
	        //Login Process...
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
	        
	        //Approve ticket by vendor process...
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement Notification_icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/div/div")));
	        Notification_icon.click();
			
	        WebElement ticket = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div.z-50.bottom-0.fixed.left-0.w-screen > div > div.bg-black.p-1.text-white.w-7\\/12.transition-all.top-14.absolute.right-0.h-72.overflow-y-scroll.overflow-hidden.rounded-bl-xl > div:nth-child(1) > div > h1")));
	        ticket.click();
	        
	        WebElement amount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[4]/div/div[1]/input")));
	        amount.sendKeys("111");
	        
	        WebElement message = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[4]/div/div[1]/textarea"));
	        message.sendKeys("Automation testing");
	        
	        WebElement Accept_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[4]/div/div[2]/button[1]")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Accept_btn);
	        Thread.sleep(1000);
	     	Accept_btn.click();

	        
	        Thread.sleep(3000);
	        
	        driver.close();
	 }
	 
	 
	 @Test(priority = 3)
	 public void ApproveQuoteBYPM() throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        Reporter.log("ChromeDriver initialized", true);

	        driver.get("https://dev.vizismart.com/login");
	        Reporter.log("Navigated to Login page", true);
	        
	        driver.manage().window().maximize();
	        
	        //Login Process...
	        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
	        emailField.sendKeys("kalyanideshmukh778+5@gmail.com");
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
