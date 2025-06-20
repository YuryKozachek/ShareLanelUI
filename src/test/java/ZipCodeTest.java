import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZipCodeTest {
    @Test
    public void getTextErrorMassage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        String textErrMassage = driver.findElement(By.className("error_message")).getText();
        Assert.assertEquals(textErrMassage, "Oops, error on page. ZIP code should have 5 digits");

        driver.quit();
    }
}
