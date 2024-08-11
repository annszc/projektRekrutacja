package Methods;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.junit.Assert;


public class Methods {

    private WebDriver driver;
//    public static String startingPrice;
//    public static String monthlyPayment;
    protected WebDriverWait wait;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public static void checkVisibility() {
    }


    public void waitUntil(String selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

//    public void fluentWait() {
//    Wait<WebDriver> wait =
//            new FluentWait<>(driver)
//                    .withTimeout(Duration.ofSeconds(2))
//                    .pollingEvery(Duration.ofMillis(300))
//                    .ignoring(ElementNotInteractableException.class);
//    }

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



    public void clickElement(WebElement element) {
        element.click();
    }

    public void selectItemFromList(WebElement element, List<WebElement> optionList, int a) {
         Select select = new Select(element);
//         optionList = select.getOptions();
//         optionList = select.getAllSelectedOptions();
//         select.selectByVisibleText("Four");
         select.selectByIndex(a);
//        optionList.selectByIndex(a).click();
    }

    public boolean checkVisibility(WebElement element) {
        return element.isDisplayed();
    }
    public void checkListVisibility(List<WebElement> listOfElements) {
        listOfElements.toString();
    }

    public String getTextOfElement(String locator) throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return this.driver.findElement(By.xpath(locator)).getText();
    }

    public void compareValueOfElements(String locator, String expectedValue) throws Exception {
        String actualValue = driver.findElement(By.xpath(locator)).getText();
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void compareValueOfElementsWithTestData(String locator, String testData) throws Exception {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        WebElement pierwszyLocator = driver.findElement(By.xpath("//header/div/div[2]/div/div/a[1]/div"));
        WebElement drugiLocator = driver.findElement(By.xpath("//header/div/div[2]/div/div/a[1]"));
        //  WebElement trzeciLocator = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div/div[2]/div/div/a[1]/div\""));
//        String searchedTextToCompareWithTestData = driver.findElement(By.cssSelector("#__next header .group/basket")).getText();


//        WebElement pageHeader = driver.findElement(By.cssSelector("#__next header"));
//        WebElement cart = pageHeader.findElement(By.cssSelector("[title='Koszyk']"));
//        WebElement valueOfCart = cart.findElement(By.xpath("div"));
//        String searchedTextToCompareWithTestData = valueOfCart.getText();


//        String searchedTextToCompareWithTestData = pageHeader.findElement(By.cssSelector("[title='Koszyk']")).getText();
        //        String searchedTextToCompareWithTestData = driver.findElement(By.xpath(locator)).getText();


        int attempts = 0;
        String searchedTextToCompareWithTestData = "0";
        while (attempts < 10 && searchedTextToCompareWithTestData == "0") {
            try {
                WebElement pageHeader = driver.findElement(By.cssSelector("#__next header"));
                WebElement cart = pageHeader.findElement(By.cssSelector("[title='Koszyk']"));
                WebElement valueOfCart = cart.findElement(By.xpath("div"));
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
