import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SingUpTest {
    @Test
    public void getTextCreateAccount() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Jon");
        driver.findElement(By.name("email")).sendKeys("Jon777@mail.com");
        driver.findElement(By.name("password1")).sendKeys("Jon777HJGHJVHJ");
        driver.findElement(By.name("password2")).sendKeys("Jon777HJGHJVHJ");
        driver.findElement(By.cssSelector("[value=Register]")).click();

        String textErrMassage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(textErrMassage, "Account is created!");

        driver.quit();
    }
}
