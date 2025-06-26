package A_Positive_Testing;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	
	



	    protected WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();

	        String uniqueProfileDir = System.getProperty("java.io.tmpdir") + "/profile_" + System.currentTimeMillis();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--user-data-dir=" + uniqueProfileDir);
	        options.addArguments("--headless"); // Optional: remove if you want to see the browser locally
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");

	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit(); // Better than driver.close()
	        }
	    }
	}



