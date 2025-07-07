package herokuapp_com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends BaseSettings {

    protected final String buttonClose = "//div[@aria-label='Close']";
    protected final String iframe = "//iframe[@id='mce_0_ifr']";
    protected final String textArea = "//body[@id='tinymce']//p";

    @Test
    public void getIFrameText() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElement(By.xpath(buttonClose)).click();
        driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
        Assert.assertEquals(driver.findElement(By.xpath(textArea)).getText(), "Your content goes here.");
        driver.switchTo().defaultContent();
    }
}
