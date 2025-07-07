package herokuapp_com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FileDownloaderTest extends BaseSettings {

    String downloadFilePath = "C:/Users/KozachekYury/Desktop/download_here";
    String downloadFile = "//*[text()='test.txt']";

    @Test
    public void getIFrameText() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        List<WebElement> list = driver.findElements(By.xpath(downloadFile));

        WebElement el = list.get(list.size() - 1);
        el.click();
        Thread.sleep(5000);

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("test.txt")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
    }
}
