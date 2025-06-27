package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseSettings {
    @Test
    public void AddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        WebElement webElement = driver.findElement(By.xpath("//div[@id='elements']"));
        String elementsOnPage = webElement.getAttribute("childElementCount");
        softAssert.assertEquals(elementsOnPage, "2");
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        String elementsOnPageAfterDel = webElement.getAttribute("childElementCount");
        softAssert.assertEquals(elementsOnPageAfterDel, "1");
    }
}
