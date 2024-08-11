package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id="didomi-notice-agree-button")
    public WebElement noticeAgreeButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/header")
    public WebElement upperMenu;

    @FindBy(css =  "#main-menu > div > ul > li:nth-child(1)")
    public WebElement headerMenu_devices;

    @FindBy(css = "[data-target='#navbar-top']")
    public WebElement navbarTop;

    @FindBy(css = "#__next > div > div > header > div > div.container.overflow-x-hidden.mx-auto.lg\\:hidden > div:nth-child(2) > div.fixed.inset-0.overflow-hidden > div > div > div > div > nav > div > ul > li:nth-child(1)")
    public WebElement menu_devices;

    @FindBy(xpath = "//button[text()='Bez abonamentu']")
    public WebElement menu_devices_no_subsciption;

    @FindBy(xpath = "//a[text()='Smartwatche']")
    public WebElement menu_devices_no_subsciption_smartwatches;

    @FindBy(xpath = "//a[text()='Bez abonamentu']")
    public WebElement headerMenu_devices_no_subscription;

    @FindBy(xpath = "//div/ul/li[1]/div/div/ul/li[4]/ul/li[2]/a/div/span")
    public WebElement headerMenu_devices_smartwatche;

    @FindBys({@FindBy(xpath = "//div[@class='styles__StyledCard-sc-10vwz6i-0 cGNUku styles__StyledProductCard-sc-16ps0q7-7 bvULEG dt_productCards']")})
    public List<WebElement> listOfDevices;

    @FindBy(xpath ="//i[@class='sc-bczRLJ dGIabd dt_icon teaserCloseIcon']")
    public WebElement noticeDeleteIcon;

    @FindBys({@FindBy(xpath = "//li[@class='styles__StyledCard-sc-10vwz6i-0 geHTBt styles__StyledProductCard-sc-16ps0q7-7 dGwMZM dt_productCards']")})
    public List<WebElement> listOfSmartwatches;

    @FindBy(xpath = "/html/body/div[2]/div[4]/main/section/section/div/span/div/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div")
    public WebElement startingPrice;

    @FindBy(xpath = "//*[@id=\"osAppInnerContainer\"]/main/section/section/div/span/div/div[2]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div")
    public WebElement monthlyPayment;

    @FindBy(xpath = "//section/article/div[2]/div/div/div/div[2]/section[1]/button")
    public WebElement btnAddToCard;

    @FindBy(xpath = "//h1[text()='Twój koszyk']")
    public WebElement cardHeader;

    @FindBy(xpath = "//span[@data-qa='BKT_TotalupFront']")
    public WebElement startingPriceFromCard;

    @FindBy(xpath = "//span[@data-qa='BKT_TotalMonthly']")
    public WebElement monthlyPaymentFromCard;

    @FindBy(xpath = "//*[@id=\"osAppInnerContainer\"]/div[2]/div[1]/a/span/div/img")
    public WebElement buttonReturnToHomePage;


    public String locatorStartingPrice = "/html/body/div[2]/div[4]/main/section/section/div/span/div/div[2]/div/div/div/div[1]/div[1]/div/div[2]/div/div";
    public String locatorStartingPrice2 = "//*[@id=\"basketSummary\"]/div/div[2]/div[1]/div/div/div[1]/span[2]/div";
    public String locatorMonthlyPayment = "//*[@id=\"osAppInnerContainer\"]/main/section/section/div/span/div/div[2]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div";
    public String locatorMonthlyPayment2 = "//*[@id=\"basketSummary\"]/div/div[2]/div[1]/section/div/div[1]/article/span/div";
    public String locatorBasketIcon = "//*[@id=\"__next\"]/div/div/header/div/div[2]/div/div/a[1]";


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
