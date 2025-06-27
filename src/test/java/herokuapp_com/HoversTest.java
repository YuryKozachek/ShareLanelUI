package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HoversTest extends BaseSettings {
    String user1 = "(//div[@class='figure'])[1]";
    String user2 = "(//div[@class='figure'])[2]";
    String user3 = "(//div[@class='figure'])[3]";
    String user1Name = "(//div[@class='figure'])[1]//h5";
    String user2Name = "(//div[@class='figure'])[2]//h5";
    String user3Name = "(//div[@class='figure'])[3]//h5";
    String link1 = "(//div[@class='figure'])[1]//a";
    String link2 = "(//div[@class='figure'])[2]//a";
    String link3 = "(//div[@class='figure'])[3]//a";
    String textNewPage = "h1";

    @Test
    public void getDataTables() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement element1 = driver.findElement(By.xpath(user1));
        actions.moveToElement(element1).perform();
        softAssert.assertEquals(driver.findElement(By.xpath(user1Name)).getText(), "name: user1");
        driver.findElement(By.xpath(link1)).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector(textNewPage)).getText(), "Not Found");
        driver.navigate().back();

        WebElement element2 = driver.findElement(By.xpath(user2));
        actions.moveToElement(element2).perform();
        softAssert.assertEquals(driver.findElement(By.xpath(user2Name)).getText(), "name: user2");
        driver.findElement(By.xpath(link2)).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector(textNewPage)).getText(), "Not Found");
        driver.navigate().back();

        WebElement element3 = driver.findElement(By.xpath(user3));
        actions.moveToElement(element3).perform();
        softAssert.assertEquals(driver.findElement(By.xpath(user3Name)).getText(), "name: user3");
        driver.findElement(By.xpath(link3)).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector(textNewPage)).getText(), "Not Found");
        driver.navigate().back();
    }
}
