package testSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractCase {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        String currentDir = System.getProperty("user.dir");
        String marionetteDriverLocation = currentDir + Config.GECKO_DRIVER_EXE_PATH;
        System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.WEBSITE_URL);
        this.hookBefore();
    }
    
    
    public void hookBefore(){
        return;
    }

    
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
