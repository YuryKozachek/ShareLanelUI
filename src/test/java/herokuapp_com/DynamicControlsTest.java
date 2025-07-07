package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseSettings {

    protected final String buttonRemove = "//button[@type='button' and text()='Remove']";
    protected final String buttonEnable = "//button[@type='button' and text()='Enable']";
    protected final By messageItsGone = By.xpath("//*[@id='message' and contains(text(), 'gone')]");
    protected final By messageItsEnabled = By.xpath("//*[@id='message' and contains(text(), 'enabled')]");
    protected final By checkbox = By.xpath("//div[@id='checkbox']");
    protected final String input = "//input[@type='text']";

    @Test
    public void getDynamicControls() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath(buttonRemove)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageItsGone));
        softAssert.assertEquals(driver.findElement(messageItsGone).getText(), "It's gone!");
        softAssert.assertFalse(isFoundCheckbox(checkbox));
        softAssert.assertEquals(driver.findElement(By.xpath(input)).getAttribute("disabled"), "true");
        driver.findElement(By.xpath(buttonEnable)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageItsEnabled));
        softAssert.assertEquals(driver.findElement(messageItsEnabled).getText(), "It's enabled!");
        softAssert.assertTrue(driver.findElement(By.xpath(input)).isEnabled());
    }
}
