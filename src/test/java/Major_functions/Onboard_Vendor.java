package Major_functions;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Onboard_Vendor extends BaseTest {
	
		
	    public String generateRandomEmail() {
	        Random random = new Random();
	        int prefixLength = 8 + random.nextInt(5); // Random length between 8 and 12
	        StringBuilder emailPrefix = new StringBuilder();
	        for (int i = 0; i < prefixLength; i++) {
	            char randomChar = (char) ('a' + random.nextInt(26)); // Random lowercase letter
	            emailPrefix.append(randomChar);
	        }
	        return emailPrefix + "@gmail.com";
	    }
	    
	    
	    // Function to generate a random phone number
	    public String generateRandomPhoneNumber() {
	        Random random = new Random();
	        int firstDigit = random.nextInt(9) + 1; // Ensure the first digit is not zero
	        StringBuilder phoneNumber = new StringBuilder(String.valueOf(firstDigit));
	        for (int i = 0; i < 9; i++) {
	            phoneNumber.append(random.nextInt(10));
	        }
	        return phoneNumber.toString();
	    }
		
	    @Test
		public void Onboard() throws InterruptedException {
//	        WebDriverManager.chromedriver().setup();
//	        ChromeDriver driver = new ChromeDriver();
	        Reporter.log("ChromeDriver initialized", true);

	        // Login process...
	        driver.get("https://dev.vizismart.com/login");
	        Reporter.log("Navigated to Login page", true);
	        
	        driver.manage().window().maximize();

	        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/input"));
	        emailField.sendKeys("kalyanideshmukh778+5@gmail.com");
	        Reporter.log("Entered Email", true);

	        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div/input"));
	        password.sendKeys("12345678");
	        Reporter.log("Entered Password", true);
	        

	        WebElement Login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	        Login.click();
	        Reporter.log("Clicked on Login button", true);

	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        Reporter.log("Implicit wait set for 2 seconds", true);

	        // Add vendor process...
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement select_prop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
	        select_prop.click();
	        Reporter.log("Select property to add vendor", true);


	        WebElement vendor_section = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/button[2]"));
	        vendor_section.click();
	        Reporter.log("Clicked on Vendor section", true);

	        WebElement add_Vendor = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/button"));
	        add_Vendor.click();
	        Reporter.log("Clicked on Add Vendor icon", true);
	        
	        WebElement OnboardVendors= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div/button"));
	        OnboardVendors.click();
	        Reporter.log("Clicked on Add onboard Vendor", true);
	        
	        WebElement FirstName= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div[2]/div/div/form/div[1]/input[1]"));
	        FirstName.sendKeys("Automation test");
	        Reporter.log("Entered first name", true);
	        
	        WebElement LastName= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div[2]/div/div/form/div[1]/input[2]"));
	        LastName.sendKeys("Vendor");
	        Reporter.log("Entered last name", true);
	        
	        WebElement Company= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div[2]/div/div/form/div[1]/input[3]"));
	        Company.sendKeys("64 square llc");
	        Reporter.log("Entered company name", true);
	        
	        String randomEmail= generateRandomEmail();
	        WebElement Email= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div[2]/div/div/form/div[1]/input[4]"));
	        Email.sendKeys(randomEmail);
	        Reporter.log("Entered email ", true);
	        
	        String randomPhone= generateRandomPhoneNumber();
	        WebElement PhoneNumber= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div[2]/div/div/form/div[1]/input[5]"));
	        PhoneNumber.sendKeys(randomPhone);
	        Reporter.log("Entered phone number", true);
	        
	        WebElement SaveBtn= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[3]/div[2]/div/div/form/div[2]/button[1]"));
	        SaveBtn.click();
	        Reporter.log("Clicked on Add onboard Vendor", true);
	        
	        Thread.sleep(5000);
	        Reporter.log("Waited for 2 seconds", true);

	        driver.close();
	        Reporter.log("Closed the browser", true);
		}


	
}
