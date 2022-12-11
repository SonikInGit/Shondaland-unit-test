import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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
    public void testShondalandLoginPageInvalidEmailFilled() {
        // TODO GIVEN

        page.clickGoToLoginPageButton();

        // TODO WHEN

        page.fillEmailAndClickLogin("wwdwdfre1@mail");
        String actualErrorMessageEmail = page.getResultMessageOfIncorrectEmail();

        // TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_INVALID_EMAIL, actualErrorMessageEmail);
    }
    @Test
    public void testShondalandLoginPageValidEmailFilled() {
        // TODO GIVEN

        page.clickGoToLoginPageButton();

        //TODO WHEN
        page.fillEmailAndClickLogin("fsc.rogalevi@gmail.com");
        String actual= page.getResultMessageOfEmptyPassword();

        //TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_PASSWORD, actual);
    }

    @Test
    public void testShondalandLoginPageAndFillEmptyPassword() {
        // TODO GIVEN

        page.clickGoToLoginPageButton();


        //TODO WHEN
        page.fillEmailAndClickLogin("fsc.rogalevi@gmail.com");
        String actual= page.getResultMessageOfEmptyPassword();

        //TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_PASSWORD, actual);
    }

    @Test
    public void testShondalandLoginPageAndFillIncorrectPassword() {
        // TODO GIVEN

        page.clickGoToLoginPageButton();

        //TODO WHEN
        page.fillLoginInfo("sophi.rogalevich@gmail.com", "njcnde8a_Ki2");
        String actual = page.getResultMessageOfIncorrectPassword();

        //TODO THEN
        Assert.assertEquals(page.ERROR_MESSAGE_USER_NOT_FOUND, actual);
    }

    @Test
    public void testShondalandLoginPageAndFillCorrectPassword() {
        // TODO GIVEN

        page.clickGoToLoginPageButton();

        //TODO WHEN
        page.fillLoginInfo("sophi.rogalevich@gmail.com", "14.09-AR");
        Util.waiter(3);
        String actual = page.getResultTextAfterValidLogin();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_AFTER_VALID_LOGIN, actual);
    }
}
