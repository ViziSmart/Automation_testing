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

public class O_QuoteApproveByVendor {
	
	@Test
	public void approve() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        // Login process
        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh102@gmail.com");
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
