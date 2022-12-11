import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class ShondalandTest {

    WebDriver driver;
    ShondalandPage page;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new ShondalandPage(driver);
        driver.get(page.URL);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testOpenShondalandWebSite() {

        String actual = page.getTextOfParagraphInFooter();
        Assert.assertEquals(page.FOOTER_COPY,actual);
    }

    @Test
    public void testShondalandLoginPageEmptyFields() {
        // TODO GIVEN

        page.clickGoToLoginPageButton();

        // TODO WHEN
        page.clickButtonLogin();
        Util.waiter(3);


        String actualErrorMessageEmail = page.getResultMessageOfEmptyEmail();
        String actualErrorMessagePassword = page.getResultMessageOfEmptyPassword();

        // TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_EMAIL, actualErrorMessageEmail);
        Assert.assertEquals(page.ERROR_MESSAGE_PASSWORD, actualErrorMessagePassword);
        Util.waiter(2);
    }

    @Test
    public void testShondalandLoginPageInvalidEmailFilled() throws FileNotFoundException, IOException{
        // TODO GIVEN
        Properties data = page.connectPropertiesClass();
        page.clickGoToLoginPageButton();

        // TODO WHEN

        page.fillEmailAndClickLogin(data.getProperty("invalidemail"));
        String actualErrorMessageEmail = page.getResultMessageOfIncorrectEmail();

        // TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_INVALID_EMAIL, actualErrorMessageEmail);
    }
    @Test
    public void testShondalandLoginPageValidEmailFilled() throws FileNotFoundException, IOException{
        // TODO GIVEN
        Properties data = page.connectPropertiesClass();
        page.clickGoToLoginPageButton();

        //TODO WHEN
        page.fillEmailAndClickLogin(data.getProperty("user2"));
        String actual= page.getResultMessageOfEmptyPassword();

        //TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_PASSWORD, actual);
    }

    @Test
    public void testShondalandLoginPageAndFillEmptyPassword() throws FileNotFoundException, IOException{
        // TODO GIVEN
        Properties data = page.connectPropertiesClass();
        page.clickGoToLoginPageButton();


        //TODO WHEN
        page.fillEmailAndClickLogin(data.getProperty("user2"));
        String actual= page.getResultMessageOfEmptyPassword();

        //TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_PASSWORD, actual);
    }

    @Test
    public void testShondalandLoginPageAndFillIncorrectPassword() throws FileNotFoundException, IOException{
        // TODO GIVEN
        Properties data = page.connectPropertiesClass();
        page.clickGoToLoginPageButton();

        //TODO WHEN
        page.fillLoginInfo(data.getProperty("user"), data.getProperty("invalidpassword"));
        String actual = page.getResultMessageOfIncorrectPassword();

        //TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_USER_NOT_FOUND, actual);
    }

    @Test
    public void testShondalandLoginPageAndFillCorrectPassword() throws FileNotFoundException, IOException {
        // TODO GIVEN
        Properties data = page.connectPropertiesClass();
        page.clickGoToLoginPageButton();

        //TODO WHEN
        page.fillLoginInfo(data.getProperty("user"), data.getProperty("password"));
        Util.waiter(3);
        String actual = page.getResultTextAfterValidLogin();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_AFTER_VALID_LOGIN, actual);
    }
}
