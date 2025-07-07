package herokuapp_com;

import org.testng.annotations.Test;

public class TyposTest extends BaseSettings {
    String etalonText = "Sometimes you'll see a typo, other times you won't.";
    String xPath = "(//div[@class='example']//p)[2]";

    @Test
    public void getTyposText() {
        driver.get("https://the-internet.herokuapp.com/typos");
        getText(etalonText, xPath);
    }
}
