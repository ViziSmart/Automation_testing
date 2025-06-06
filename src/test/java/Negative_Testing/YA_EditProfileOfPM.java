package Negative_Testing;

import java.time.Duration; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class YA_EditProfileOfPM {
		
		@Test
		public void edit() {

		    WebDriverManager.chromedriver().setup();
		    ChromeDriver driver = new ChromeDriver();
		    driver.get("https://dev.vizismart.com/login");
		    
		    // Property manager login
		    WebElement emailField = driver.findElement(By.name("email"));
		    emailField.sendKeys("kalyanideshmukh778@gmail.com");
		    
		    WebElement password = driver.findElement(By.name("password"));
		    password.sendKeys("12345678");
		    
		    WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		    Login.click();
		    
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    
		    // Edit profile process
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    
		    // Click on Corner Bar
		    WebElement Corner_bar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div.container.min-h-screen.flex.flex-col > div.fixed.z-40.bottom-0.left-0.w-full > div > div.flex.px-4.z-10.relative.justify-between.bg-black.p-2.py-4.items-center > div > svg > path")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Corner_bar);
		    
		    // Click on Profile Icon
		    WebElement profile_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[3]/a[2]")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", profile_icon);
		    
		    // Click on Edit Icon
		    WebElement edit_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[3]/div/div/div[1]/button")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", edit_icon);

		    // Edit First Name
		    WebElement first_name = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/form/div/div[1]/div[1]/input"));
		    first_name.clear();
		    first_name.sendKeys("abc");
		    
		    // Click on Correct Button (Save)
		    WebElement correct_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div.container.min-h-screen.flex.flex-col > div:nth-child(3) > div > div > div.flex.absolute.right-0.bottom-0.items-center.h-14.justify-between.px-5.py-2 > button > svg > path")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", correct_btn);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", correct_btn);
		    
		    // Try clicking again on profile icon
		    try {
		        profile_icon.click();
		    } catch (Exception e) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", profile_icon);
		    }
		    
		    // Add necessary cleanup actions like driver.quit() after the test execution
		}


}
