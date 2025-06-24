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

public class Onboard_Landlord {


	// Function to generate a random phone number
    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        int firstDigit = random.nextInt(9) + 1; 
        StringBuilder phoneNumber = new StringBuilder(String.valueOf(firstDigit));
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    // Function to generate a random email address
    public static String generateRandomEmail() {
        Random random = new Random();
        int prefixLength = 8 + random.nextInt(5); 
        StringBuilder emailPrefix = new StringBuilder();
        for (int i = 0; i < prefixLength; i++) {
            char randomChar = (char) ('a' + random.nextInt(26)); 
            emailPrefix.append(randomChar);
        }
        return emailPrefix + "@gmail.com";
    }
	
    @Test
	public void onboard() throws InterruptedException {
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
        
        // add landlord process ...
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement select_prop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")));
        select_prop.click();
        Reporter.log("Select property to add vendor", true);
    
        
        WebElement landlord_tab= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"details27\"]/button[4]")));
        landlord_tab.click();
        
        WebElement add_landlord= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/button")));
        add_landlord.click();
        
        WebElement Onboard_btn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div/button")));
        Onboard_btn.click();
        
        WebElement first_name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[1]/input[1]")));
        first_name.sendKeys("Automation");
        
        WebElement lastname = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[1]/input[2]"));
        lastname.sendKeys("Tester");
        
        WebElement company = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[1]/input[3]"));
        company.sendKeys("Test");
        
        String email_address= generateRandomEmail();
        WebElement email = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[1]/input[4]"));
        email.sendKeys(email_address);
        
        String phone_no= generateRandomPhoneNumber();
        WebElement phone = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[1]/input[5]"));
        phone.sendKeys(phone_no);
        
        WebElement title= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[1]/input[6]"));
        title.sendKeys("landlord1");
        
        WebElement ultimate_decision= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[2]/div[1]/input"));
        ultimate_decision.click();
        
        WebElement min_amount= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[1]/div/input"));
        min_amount.sendKeys("100");
        
        WebElement max_amount= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/input"));
        max_amount.sendKeys("200");
        
        WebElement add_user= driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/div[1]/div/div[2]/div/div/div/div/form/div[5]/button[1]"));
        add_user.click();
        
        Thread.sleep(5000);
        
        driver.close();
	}
}
