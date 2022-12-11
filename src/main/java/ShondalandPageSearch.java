import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ShondalandPageSearch {
    WebDriver driver;

    public final String URL = "https://www.shondaland.com/";
    private String xpathInputSearch = "//input[@name='search']";
    private String xpathResultText="//div[@class='search-header-resultsummary']";
    private String xpathSearchInputField = "/html/body/main/div[2]/div/form/input";
    private String xpathSidePanelButton ="//a[@href='#sidepanel']";
    private String xpathButtonSearch="//a[@href='/search/']";
    public final String RESULT_TEXT="100 RESULTS";




    public ShondalandPageSearch(WebDriver driver){
        this.driver = driver;
    }

    public void typeSearch(String searchInfo){
        By byXpathSearchInputField = By.xpath(xpathSearchInputField);
        WebElement elementSearchInputField = driver.findElement(byXpathSearchInputField);
        String js = "arguments[0].setAttribute('value','" + searchInfo + "')";
        ((JavascriptExecutor) driver).executeScript(js, elementSearchInputField);
        Util.waiter(3);
        elementSearchInputField.sendKeys(Keys.ENTER);
    }

    public String getResultText(){
        By byResultText = By.xpath(xpathResultText);
        WebElement elementResultText = driver.findElement(byResultText);
        return elementResultText.getText();
    }

    public void fillSearchAndClick(String searchInfo){
        typeSearch(searchInfo);

    }

    public void selectSidePanelButton(){
        By byXpathSidePanelButton = By.xpath(xpathSidePanelButton);
        WebElement elementSidePanelButton = driver.findElement(byXpathSidePanelButton);
        elementSidePanelButton.click();
        Util.waiter(2);
    }
    public void clickButtonSearch(){
        By byXpathButtonSearch = By.xpath(xpathButtonSearch);
        WebElement elementButtonSearch = driver.findElement(byXpathButtonSearch);
        elementButtonSearch.click();
        Util.waiter(2);
    }
}
