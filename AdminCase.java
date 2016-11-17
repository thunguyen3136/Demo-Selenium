package testSuite;

import org.openqa.selenium.By;

public class AdminCase extends AbstractCase{
    public void hookBefore(){
        driver.findElement(By.id("user_login")).sendKeys("admin");
        driver.findElement(By.id("user_pass")).sendKeys("admin");
        driver.findElement(By.id("login_btn")).submit();
    }
}
