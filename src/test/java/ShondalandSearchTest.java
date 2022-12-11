import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShondalandSearchTest {
    WebDriver driver;
    ShondalandPageSearch page;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new ShondalandPageSearch(driver);
        driver.get(page.URL);
        Util.waiter(3);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testShondalandSearch(){

        //TODO GIVEN
        page.selectSidePanelButton();

        //TODO WHEN
        page.clickButtonSearch();

        page.fillSearchAndClick("bridgerton");

        Util.waiter(3);
        String actual = page.getResultText();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT, actual);
    }
}