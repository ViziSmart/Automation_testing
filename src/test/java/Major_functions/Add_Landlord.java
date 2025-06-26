package Major_functions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_Landlord extends BaseTest{
	

	@Test
	public void add() throws InterruptedException {
		
      	WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Reporter.log("ChromeDriver initialized", true);

        // Login process...
        driver.get("https://dev.vizismart.com/login");
        Reporter.log("Navigated to Login page", true);
        
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
        emailField.sendKeys("kalyanideshmukh778+11@gmail.com");
        Reporter.log("Entered Email", true);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
        password.sendKeys("12345678");
        Reporter.log("Entered Password", true);
        

        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Login.click();
        Reporter.log("Clicked on Login button", true);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Reporter.log("Implicit wait set for 2 seconds", true);
        
        //add landlord process ....
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement select_prop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
        select_prop.click();
        Reporter.log("Select property to add vendor", true);
        
        WebElement landlord_tab= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"details27\"]/button[4]")));
        landlord_tab.click();
        
        WebElement add_landlord= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/button")));
        add_landlord.click();

        Thread.sleep(1000);
        WebElement assign_btn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/button")));
        assign_btn.click();
        
        Thread.sleep(5000);
        
        driver.close();
	}


}
