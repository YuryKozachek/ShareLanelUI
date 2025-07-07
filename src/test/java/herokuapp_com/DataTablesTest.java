package herokuapp_com;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DataTablesTest extends BaseSettings {
    String frank = "//*[@id='table1']//tr[2]//td[2]";
    String jason = "//*[@id='table1']//tr[3]//td[2]";
    String webSiteFrank = "//*[@id='table1']//tr[2]//td[5]";
    String webSiteJason = "//*[@id='table1']//tr[3]//td[5]";

    @Test
    public void getDataTables() {
        driver.get("https://the-internet.herokuapp.com/tables");
        softAssert.assertEquals(driver.findElement(By.xpath(frank)).getText(), "Frank");
        softAssert.assertEquals(driver.findElement(By.xpath(jason)).getText(), "Jason");
        softAssert.assertEquals(driver.findElement(By.xpath(webSiteFrank)).getText(), "http://www.frank.com");
        softAssert.assertEquals(driver.findElement(By.xpath(webSiteJason)).getText(), "http://www.jdoe.com");
    }
}
