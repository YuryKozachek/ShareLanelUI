package herokuapp_com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseSettings {

    protected final String selectFile = "//input[@id='file-upload']";
    protected final String buttonUpload = "//input[@id='file-submit']";
    protected final String nameFile = "//div[@id='uploaded-files']";
    protected final String fileText = "test.txt";

    @Test
    public void getFileUploader() {
        driver.get("https://the-internet.herokuapp.com/upload");
        getFile("src/test/resources/" + fileText);
        driver.findElement(By.xpath(selectFile)).sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath(buttonUpload)).click();
        Assert.assertEquals(driver.findElement(By.xpath(nameFile)).getText(), fileText);
    }
}
