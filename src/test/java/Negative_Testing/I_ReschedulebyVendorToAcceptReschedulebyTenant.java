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

public class I_ReschedulebyVendorToAcceptReschedulebyTenant {
	
		
		@Test(priority = 1)
		public void reschedule() throws InterruptedException {
			  WebDriverManager.chromedriver().setup();
		        ChromeDriver driver = new ChromeDriver();
		        Reporter.log("ChromeDriver initialized", true);

		        driver.get("https://dev.vizismart.com/login");
		        Reporter.log("Navigated to Login page", true);
		        
		        driver.manage().window().maximize();
		        
		        //Login Process...
		        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
		        emailField.sendKeys("deshmukhkalyani2001+182@gmail.com");
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
		        
		        WebElement reschedule_btn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/button[2]")));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reschedule_btn);
		        reschedule_btn.click();
		        
		        WebElement dateAndTime = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/div/div/input")));
		        dateAndTime.sendKeys("01-04-201502:1234");
		        
		        WebElement reason = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/div/div/textarea"));
		        reason.sendKeys("changed the time");
		        
		        WebElement sure_btn= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/button[2]"));
		        sure_btn.click();
		        
		        Thread.sleep(2000);
		        
		        driver.close();
		}
		

		@Test(priority = 2)
		public void approve() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        Reporter.log("ChromeDriver initialized", true);

	        // Login process
	        driver.get("https://dev.vizismart.com/login");
	        Reporter.log("Navigated to Login page", true);

	        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
	        emailField.sendKeys("kalyanideshmukh102+182@gmail.com");
	        Reporter.log("Entered Email: kalyanideshmukh102@gmail.com", true);

	        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
	        password.sendKeys("12345678");
	        Reporter.log("Entered Password", true);

	        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	        Login.click();
	        Reporter.log("Clicked on Login button", true);
	        
	        //quote approve by Vendor (adding amount and message)
	        

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement Notification_icon= wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div.container.min-h-screen.flex.flex-col > div.fixed.z-40.bottom-0.left-0.w-full > div > div.flex.px-4.z-10.relative.justify-between.bg-black.p-2.py-4.items-center > div > div > svg > path")));
	        Notification_icon.click();
	        
	        WebElement notification= driver.findElement(By.xpath("(//h1[@class='null'])[1]"));
	        notification.click();
	        
	        WebElement amount= driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div/div[3]/div/div[1]/input"));
	        amount.sendKeys("110");
	        
	        WebElement message= driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div/div[2]/div/div/textarea"));
	        message.sendKeys("I will repair.");
	        
	        WebElement Accept_btn= driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div/div[2]/div/button"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Accept_btn);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Accept_btn);
	        
	        Thread.sleep(4000);
	        
	        driver.close();
	        

		}

}
