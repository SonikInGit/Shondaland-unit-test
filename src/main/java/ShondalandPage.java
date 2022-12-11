import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class ShondalandPage {
    WebDriver driver;
    public final String URL = "https://www.shondaland.com/";
    private String xpathInputEmail = "//input[@type='email']";
    private String xpathInputPassword = "//input[@type='password']";
    private String xpathButtonGoToLoginPage = "//a[@rel='nofollow']";
    private String xpathButtonLogin = "//button[@type='submit']";
    private String xpathFooterText = "//*[@id='__next']/div[1]/footer/div/p[2]";
    private String xpathResultTextAfterValidLogin = "//span[@data-account='Account']";
    private String xpathErrorMessageInvalidEmail = "//div[@id='email-error']";
    private String xpathErrorMessageInvalidPassword = "//div[@role = 'alert']";
    private String xpathErrorMessageEmptyEmail = "//div[@id='email-error']";
    private String xpathErrorMessageEmptyPassword = "//div[@id='password-error']";

    public final String FOOTER_COPY = "Every item on this page was chosen by a Shondaland editor. We may earn commission on some of the items you choose to buy.";
    public final String ERROR_MESSAGE_EMAIL = "Email is a required field";
    public final String ERROR_MESSAGE_PASSWORD = "Password is a required field";
    public final String ERROR_MESSAGE_INVALID_EMAIL = "Please enter a valid email address";
    public final String ERROR_MESSAGE_USER_NOT_FOUND = "The email or password you entered did not match our records. Please try again.";
    public final String RESULT_TEXT_AFTER_VALID_LOGIN = "ACCOUNT";
    public ShondalandPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTextOfParagraphInFooter(){
        By byXpathFooterText = By.xpath(xpathFooterText);
        WebElement elementFooterText = driver.findElement(byXpathFooterText);
        Util.waiter(1);
        return elementFooterText.getText();
    }

    public void clickGoToLoginPageButton(){
        By byXpathButtonGoToLoginPage = By.xpath(xpathButtonGoToLoginPage);
        WebElement elementButtonGoToLoginPage = driver.findElement(byXpathButtonGoToLoginPage);
        elementButtonGoToLoginPage.click();
        Util.waiter(3);
    }
    public void clickButtonLogin(){
        By byXpathButtonLogin = By.xpath(xpathButtonLogin);
        WebElement elementButtonLogin = driver.findElement(byXpathButtonLogin);
        elementButtonLogin.click();
    }
    public void typeEmail(String email) {
        By byInputEmail = By.xpath(xpathInputEmail);
        WebElement elementInputEmail = driver.findElement(byInputEmail);
        elementInputEmail.sendKeys(email);
    }

    public void typePassword(String password) {
        By byInputPassword = By.xpath(xpathInputPassword);
        WebElement elementInputPassword = driver.findElement(byInputPassword);
        elementInputPassword.sendKeys(password);
    }

    public String getResultMessageOfEmptyEmail() {
        By byErrorMessageEmptyEmail = By.xpath(xpathErrorMessageEmptyEmail);
        WebElement elementErrorMessageEmptyEmail = driver.findElement(byErrorMessageEmptyEmail);
        return elementErrorMessageEmptyEmail.getText();
    }

    public String getResultMessageOfEmptyPassword() {
        By byErrorMessageEmptyPassword = By.xpath(xpathErrorMessageEmptyPassword);
        WebElement elementErrorMessageEmptyPassword = driver.findElement(byErrorMessageEmptyPassword);
        return elementErrorMessageEmptyPassword.getText();
    }
    public String getResultMessageOfIncorrectEmail() {
        By byErrorMessageIncorrectEmail = By.xpath(xpathErrorMessageInvalidEmail);
        WebElement elementErrorMessageIncorrectEmail = driver.findElement(byErrorMessageIncorrectEmail);
        return elementErrorMessageIncorrectEmail.getText();
    }
    public String getResultMessageOfIncorrectPassword() {
        By byErrorMessageIncorrectPassword = By.xpath(xpathErrorMessageInvalidPassword);
        WebElement elementErrorMessageIncorrectPassword = driver.findElement(byErrorMessageIncorrectPassword);
        return elementErrorMessageIncorrectPassword.getText();
    }
    public String getResultTextAfterValidLogin() {
        By byResultTextAfterValidLogin = By.xpath(xpathResultTextAfterValidLogin);
        WebElement elementResultTextAfterValidLogin = driver.findElement(byResultTextAfterValidLogin);
        return elementResultTextAfterValidLogin.getText();
    }
    public void fillEmailAndClickLogin(String email) {
        typeEmail(email);
        Util.waiter(3);
        clickButtonLogin();
        Util.waiter(3);
    }
    public void fillLoginInfo(String email, String password) {
        typePassword(password);
        Util.waiter(3);
        fillEmailAndClickLogin(email);
        Util.waiter(3);
    }
}
