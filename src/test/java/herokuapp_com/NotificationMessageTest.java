package herokuapp_com;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NotificationMessageTest extends BaseSettings {
    String link = "//*[text()='Click here']";
    String text = "//div[@id='flash']";

    @Test
    public void getNotificationMessage() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath(link)).click();
        softAssert.assertEquals(driver.findElement(By.xpath(text)).getText().trim(), "Action successful\n×");
    }
}
