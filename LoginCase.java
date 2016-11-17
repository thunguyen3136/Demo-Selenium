package testSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginCase extends AbstractCase{

    @Test(priority = 0)
    public void loginSuccess() {

        driver.findElement(By.id("user_login")).sendKeys("admin");
        driver.findElement(By.id("user_pass")).sendKeys("admin");
        driver.findElement(By.id("login_btn")).submit();

        String logoutText = driver.findElement(By.xpath(".//*[@id='common_header']/div/a")).getText();
        Assert.assertEquals("サイトを見る", logoutText);

    }

    @Test(priority = 1)
    public void emptyUserPass() {

        driver.findElement(By.id("user_login")).sendKeys("");
        driver.findElement(By.id("user_pass")).sendKeys("");
        driver.findElement(By.id("login_btn")).submit();

        String errorMessage = driver.findElement(By.xpath("//div[@class='error']")).getText();
        Assert.assertEquals("ＩＤまたはパスワードが正しくありません。\nもう一度ご確認のうえ、再度入力してください。", errorMessage);

    }
}
