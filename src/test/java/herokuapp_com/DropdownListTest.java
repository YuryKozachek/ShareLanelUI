package herokuapp_com;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DropdownListTest extends BaseSettings {
    String dropdown = "//*[@id='dropdown']";
    String option1 = "//*[text()='Option 1']";
    String option2 = "//*[text()='Option 2']";

    @Test
    public void getDropdownList() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.xpath(dropdown)).click();
        driver.findElement(By.xpath(option1)).isDisplayed();
        driver.findElement(By.xpath(option2)).isDisplayed();
        driver.findElement(By.xpath(option1)).click();
        driver.findElement(By.xpath(option1)).isDisplayed();
        driver.findElement(By.xpath(dropdown)).click();
        driver.findElement(By.xpath(option2)).click();
        driver.findElement(By.xpath(option2)).isDisplayed();
    }
}
