package herokuapp_com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseSettings {
    WebDriver driver;
    SoftAssert softAssert;
    ChromeOptions chromeOptions;
    Actions actions;
    WebDriverWait wait;
    Alert alert;
    File file;

    @BeforeTest
    public void setSetting() {
        softAssert = new SoftAssert();
        chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public boolean isFoundCheckbox(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return !elements.isEmpty();
    }

    public void getFile(String path) {
        file = new File(path);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
//        driver.quit();
        softAssert.assertAll();
    }
}
