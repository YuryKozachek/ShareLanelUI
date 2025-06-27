package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class BaseSettings {
    WebDriver driver;
    SoftAssert softAssert;
    ChromeOptions chromeOptions;
    Actions actions;

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
        actions = new Actions(driver);
    }

    public String getValue(String value) {
        return driver.findElement(By.xpath(value)).getAttribute("value");
    }

    public void getText(String etalonText, String xpath) {
        for (int i = 0; i < 5; i++) {
            String text = driver.findElement(By.xpath(xpath)).getText();
            softAssert.assertEquals(etalonText, text);
            driver.navigate().refresh();
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        softAssert.assertAll();
    }
}
