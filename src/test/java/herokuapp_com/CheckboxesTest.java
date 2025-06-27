package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseSettings {
    @Test
    public void getCheckboxesValue() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement webElement1 = driver.findElement(By.xpath("(//*[text()=' checkbox 1']//input)[1]"));
        WebElement webElement2 = driver.findElement(By.xpath("(//*[text()=' checkbox 1']//input)[2]"));
        Boolean checkboxes1ValueFalse = Boolean.valueOf(webElement1.getAttribute("checked"));
        softAssert.assertEquals(checkboxes1ValueFalse.booleanValue(), false);
        driver.findElement(By.xpath("(//*[text()=' checkbox 1']//input)[1]")).click();
        Boolean checkboxes1ValueTrue = Boolean.valueOf(webElement1.getAttribute("checked"));
        softAssert.assertEquals(checkboxes1ValueTrue.booleanValue(), true);
        Boolean checkboxes2ValueTrue = Boolean.valueOf(webElement2.getAttribute("checked"));
        softAssert.assertEquals(checkboxes2ValueTrue.booleanValue(), true);
        driver.findElement(By.xpath("(//*[text()=' checkbox 1']//input)[2]")).click();
        Boolean checkboxes2ValueFalse = Boolean.valueOf(webElement2.getAttribute("checked"));
        softAssert.assertEquals(checkboxes2ValueFalse.booleanValue(), false);
    }
}
