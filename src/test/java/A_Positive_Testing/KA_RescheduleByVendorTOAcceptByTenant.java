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

public class KA_RescheduleByVendorTOAcceptByTenant {
	
	@Test(priority = 1)
	public void RescheduleByVendor() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh102@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);
        
        //approve ticket process with bidding off
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement maintenance_ticket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/a[2]/div/div[1]")));
        maintenance_ticket.click();
       
        Thread.sleep(5000);
        
        WebElement ticket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/table/tbody/tr[1]/td[1]")));
        ticket.click();
        
        Thread.sleep(2000);
        
        WebElement Reschedule_Ticket= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/button")));
        Reschedule_Ticket.click();
        
        Thread.sleep(2000);
        
        WebElement Reschedule= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[4]/button")));
        Reschedule.click();
        
        Thread.sleep(1000);
        WebElement dateAndTime =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/div/div/input")));
        dateAndTime.sendKeys("01022025010215");
        
        WebElement reason = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/div/div/textarea"));
        reason.sendKeys("Automation Testing");
        
        WebElement final_re= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[4]/button"));
        final_re.click();
        
        Thread.sleep(2000);
        
        driver.close();
	}
	
	
	@Test(priority = 2)
	public void AcceptReschduleByTenant() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("deshmukhkalyani2001+5@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        
        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);
        
        //approve ticket process with bidding off
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement maintenance_ticket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/a[2]/div/div[1]")));
        maintenance_ticket.click();
       
        Thread.sleep(5000);
        
        WebElement ticket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/table/tbody/tr[2]/td[1]")));
        ticket.click();
        
        Thread.sleep(1000);
        WebElement accept_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[5]/button[1]")));
        accept_btn.click();
        
        Thread.sleep(2000);
        
        driver.close();
	}
	

}
