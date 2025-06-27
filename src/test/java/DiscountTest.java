import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class DiscountTest {

    WebDriver driver;
    SoftAssert softAssert;
    ChromeOptions chromeOptions;

    @BeforeTest
    public void setSetting() {
        softAssert = new SoftAssert();
        chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py?page=2&zip_code=11111&first_name=Jon&last_name=" +
                "&email=Jon777%40mail.com&password1=Jon777HJGHJVHJ&password2=Jon777HJGHJVHJ");
        String email = driver.findElement(By.xpath("//*[text()='Email']/..//b")).getText();
        driver.get("https://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.get("https://sharelane.com/cgi-bin/add_to_cart.py?book_id=10");
        driver.get("https://sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
    }

    @Test
    public void getDiscount0() {
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.xpath("//input[@value='Update']")).click();
        String discountPercentage = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//p")).getText();
        String discountAmount = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//td[6]")).getText();
        String totalAmount = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//td[7]")).getText();
        softAssert.assertEquals(discountPercentage, "0");
        softAssert.assertEquals(discountAmount, "0");
        softAssert.assertEquals(totalAmount, "190");
        driver.findElement(By.name("q")).clear();
    }

    @Test
    public void getDiscount2() {
        driver.findElement(By.name("q")).sendKeys("21");
        driver.findElement(By.xpath("//input[@value='Update']")).click();
        String discountPercentage = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//p")).getText();
        String discountAmount = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//td[6]")).getText();
        String totalAmount = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//td[7]")).getText();
        softAssert.assertEquals(discountPercentage, "2");
        softAssert.assertEquals(discountAmount, "4.2");
        softAssert.assertEquals(totalAmount, "205.8");
        driver.findElement(By.name("q")).clear();
    }

    @Test
    public void getDiscount3() {
        driver.findElement(By.name("q")).sendKeys("99");
        driver.findElement(By.xpath("//input[@value='Update']")).click();
        String discountPercentage = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//p")).getText();
        String discountAmount = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//td[6]")).getText();
        String totalAmount = driver.findElement(By.xpath("(//input[@value='Update']/../../..//tr[@align='center'])[2]//td[7]")).getText();
        softAssert.assertEquals(discountPercentage, "3");
        softAssert.assertEquals(discountAmount, "29.7");
        softAssert.assertEquals(totalAmount, "960.3");
        driver.findElement(By.name("q")).clear();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        softAssert.assertAll();
    }
}
