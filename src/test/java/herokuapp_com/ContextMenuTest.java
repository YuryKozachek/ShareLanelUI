package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseSettings {

    protected final String contextMenu = "//div[@id='hot-spot']";

    @Test
    public void getContextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.xpath(contextMenu));
        actions.moveToElement(element)
                .contextClick()
                .perform();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }
}
