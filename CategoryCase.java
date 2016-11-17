package testSuite;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CategoryCase extends AdminCase{
    
    @Test
    public void testInsertCategorySucess(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        // Click left menu2 -> access to [カテゴリ管�?�] page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("left-navigation-block-products-handle")));
        driver.findElement(By.id("left-navigation-block-products-handle")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("カテゴリ管理")));
        driver.findElement(By.linkText("カテゴリ管理")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

        // Register new category
        driver.findElement(By.name("category_name")).sendKeys("Electronic");
        driver.manage().timeouts().implicitlyWait(900, TimeUnit.SECONDS);
        driver.findElement(By.name("category_code")).sendKeys("24");
        driver.manage().timeouts().implicitlyWait(900, TimeUnit.SECONDS);
        driver.findElement(By.name("button")).submit();
        driver.manage().timeouts().implicitlyWait(90000, TimeUnit.SECONDS);
        
        String category = driver.findElement(By.xpath(".//*[@id='form1']/div[2]/div/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td/span[1]")).getText();
        Assert.assertEquals(category, "");
     
    }
}
