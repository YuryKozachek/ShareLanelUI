package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class InputsTest extends BaseSettings {
    String inputForm = "//input[@type='number']";

    @Test
    public void getInputs() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath(inputForm)).sendKeys("Hi");
        String valueVoid = getValue(inputForm);
        softAssert.assertEquals(valueVoid, "");
        driver.findElement(By.xpath(inputForm)).sendKeys("10");
        driver.findElement(By.xpath(inputForm)).sendKeys(Keys.ARROW_UP);
        String valueUp = getValue(inputForm);
        softAssert.assertEquals(valueUp, "11");
        driver.findElement(By.xpath(inputForm)).sendKeys(Keys.ARROW_DOWN);
        String valueDown = getValue(inputForm);
        softAssert.assertEquals(valueDown, "10");
    }
}
