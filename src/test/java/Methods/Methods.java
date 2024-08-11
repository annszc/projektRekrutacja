package Methods;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.junit.Assert;


public class Methods {

    private WebDriver driver;
    protected WebDriverWait wait;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntil(String selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void checkPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String states = js.executeScript("return document.readyState").toString();
        switch (states) {
            case "loading": System.out.println("The homepage is still loading.");
                break;
            case "interactive": System.out.println("The homepage has finished loading.But sub-resources such as images, stylesheets and frames are still loading.");
                break;
            case "complete": System.out.println("The homepage is fully loaded.");
                break;
            default:
                break;
        }
    }


    public void selectItemFromList(WebElement element, List<WebElement> optionList, int a) {
         Select select = new Select(element);
         select.selectByIndex(a);
    }

    public boolean checkVisibility(WebElement element) {
        return element.isDisplayed();
    }
    public void checkListVisibility(List<WebElement> listOfElements) {
        listOfElements.toString();
    }

    public String getTextOfElement(String locator) throws Exception {
        return this.driver.findElement(By.xpath(locator)).getText();
    }

    public void compareValueOfElements(String locator, String expectedValue) throws Exception {
        String actualValue = driver.findElement(By.xpath(locator)).getText();
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void compareValueOfElementsWithTestData(String locator1, String locator2, String locator3, String testData) throws Exception {
        int attempts = 0;
        String searchedTextToCompareWithTestData = "0";
        while (attempts < 10 && searchedTextToCompareWithTestData == "0") {
            try {
                WebElement pageHeader = driver.findElement(By.cssSelector(locator1));
                WebElement cart = pageHeader.findElement(By.cssSelector(locator2));
                WebElement valueOfCart = cart.findElement(By.xpath(locator3));
                searchedTextToCompareWithTestData = valueOfCart.getText();
                return;
            } catch (Exception e) {
            } finally {
                attempts++;
                Thread.sleep(1000);
            }
        }
        Assert.assertEquals(testData, searchedTextToCompareWithTestData);
    }

}
