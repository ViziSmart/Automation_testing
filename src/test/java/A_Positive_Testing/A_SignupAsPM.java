package A_Positive_Testing;

import java.time.Duration;  
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class A_SignupAsPM {

    // Function to generate a random phone number
    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        int firstDigit = random.nextInt(9) + 1; // Ensure the first digit is not zero
        StringBuilder phoneNumber = new StringBuilder(String.valueOf(firstDigit));
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    // Function to generate a random email address
    public static String generateRandomEmail() {
        Random random = new Random();
        int prefixLength = 8 + random.nextInt(5); // Random length between 8 and 12
        StringBuilder emailPrefix = new StringBuilder();
        for (int i = 0; i < prefixLength; i++) {
            char randomChar = (char) ('a' + random.nextInt(26)); // Random lowercase letter
            emailPrefix.append(randomChar);
        }
        return emailPrefix + "@gmail.com";
    }

    @Test
    public void Signup_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://dev.vizismart.com");
        Reporter.log("Navigated to Signup page", true);

        WebElement FirstName = driver.findElement(By.name("first_name"));
        FirstName.sendKeys("Kalyani");
        Reporter.log("Entered First Name: Kalyani", true);

        WebElement LastName = driver.findElement(By.name("last_name"));
        LastName.sendKeys("Deshmukh");
        Reporter.log("Entered Last Name: Deshmukh", true);

        String email = generateRandomEmail();
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys(email);
        Reporter.log("Entered Email: " + email, true);

        String phoneNumber = generateRandomPhoneNumber();
        WebElement Phone = driver.findElement(By.name("phone_number"));
        Phone.sendKeys(phoneNumber);
        Reporter.log("Entered Phone Number: " + phoneNumber, true);

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("12345678");
        Reporter.log("Entered Password", true);

        WebElement ConfirmPassword = driver.findElement(By.name("confirmPassword"));
        ConfirmPassword.sendKeys("12345678");
        Reporter.log("Entered Confirm Password", true);

        WebElement checkTerms = driver.findElement(By.id("terms"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkTerms);
        js.executeScript("arguments[0].click();", checkTerms);
        Reporter.log("Checked Terms and Conditions", true);

        WebElement NextStep = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);", NextStep);
        js.executeScript("arguments[0].click();", NextStep);
        Reporter.log("Clicked on Submit button", true);

        // Wait for role selection page
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader"))); 
        
        Thread.sleep(1000);
        WebElement selectiondropdown= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div > div:nth-child(1) > div.flex.flex-col.items-center.w-screen.h-14.relative > div")));
        selectiondropdown.click();
        
        
        WebElement SelectRole = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div > div:nth-child(1) > div.flex.flex-col.items-center.w-screen.h-14.relative > div > div > ul > li:nth-child(2)")));
        js.executeScript("arguments[0].scrollIntoView(true);", SelectRole);
        js.executeScript("arguments[0].click();", SelectRole);
        Reporter.log("Selected role", true);

        // Communication preference page
        Thread.sleep(1000);
        

        WebElement DoneButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/button")));
        js.executeScript("arguments[0].scrollIntoView(true);", DoneButton);
        js.executeScript("arguments[0].click();", DoneButton);
        Reporter.log("Selected communication preference successfully", true);
        
        WebElement CommAsSMS = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"notification3\"]/label")));
        js.executeScript("arguments[0].scrollIntoView(true);", CommAsSMS);
        js.executeScript("arguments[0].click();", CommAsSMS);
        Reporter.log("Clicked on email checkbox as preferred communication", true);

        
        WebElement DoneBtn = driver.findElement(By.xpath("//*[@id=\"notification10\"]"));
        DoneBtn.click();
        
        // Wait before closing
        Thread.sleep(4000);
        Reporter.log("Waited for 4 seconds", true);

        driver.close();
        Reporter.log("Closed the browser", true);
    }
}
