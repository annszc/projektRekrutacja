package StepDefinition;

import DriverManager.DriverManager;
import Methods.Methods;
import Pages.HomePage;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

public class ProductAddedStepsDef {

    public static DriverManager driverManager = new DriverManager();
    private static WebDriver driver;
    public HomePage homePage = new HomePage(driver);
    public Methods methods = new Methods(driver);

    public ProductAddedStepsDef() {
    }

    public static String startingPrice;
    public static String monthlyPayment;
    public static String itemsInCart = "1";


    @BeforeAll
    public static void startSeleniumSession(){
        driverManager.startSeleniumSession();
        driver = driverManager.getDriver();
        driverManager.configure();
    }


    @When("I go to the page")
    public void I_go_to_the_page(){
        driver.get("https://t-mobile.pl");
    }

    @Then("the home page is visible")
    public void the_home_page_is_visible() {
        this.methods.checkPageLoad();
    }

    @Given("the top menu is visible")
    public void the_top_menu_is_visible() throws InterruptedException {
        Thread.sleep(3000);
        this.methods.checkVisibility(homePage.upperMenu);
    }

    @And("accept cookies")
    public void accept_cookies(){
        homePage.noticeAgreeButton.click();
    }

    @When("I select the Devices tab from the top menu")
    public void select_the_devices_tab() throws InterruptedException {
        Thread.sleep(1000);
        homePage.navbarTop.click();
        Thread.sleep(1000);
        homePage.menu_devices.click();
    }


    @Then("drop-down list visible on the page")
    public void drop_down_list_is_visible(){
        this.methods.checkVisibility(homePage.menu_devices_no_subsciption);
    }

    @Given("no subscription section of the top menu is visible")
    public void no_subscription_section_f_the_top_menu_is_visible() throws InterruptedException {
        Thread.sleep(3000);
        this.methods.checkVisibility(homePage.menu_devices_no_subsciption);
    }

    @When("I click smartphones in the no subscription section")
    public void i_click_smartphones_in_the_no_subscrition_section() throws InterruptedException {
        Thread.sleep(1000);
        homePage.menu_devices_no_subsciption.click();
        Thread.sleep(1000);
        homePage.menu_devices_no_subsciption_smartwatches.click();
    }

    @Then("a list of smartphones visible on the website")
    public void a_list_of_smartphones_is_visible_on_the_website() throws InterruptedException {
        Thread.sleep(1000);
        this.methods.checkListVisibility(homePage.listOfSmartwatches);
    }

    @When("I click on the first item on the list")
    public void i_click_on_the_first_item_on_the_list() throws InterruptedException {
        homePage.noticeDeleteIcon.click();
        Thread.sleep(1000);
        homePage.listOfDevices.get(0).click();
    }

    @Then("product page is visible")
    public void product_page_is_visible(){
        this.methods.checkVisibility(homePage.btnAddToCard);
    }

    @And("get Starting price")
    public void get_Starting_price() throws Exception {
        this.startingPrice =  this.methods.getTextOfElement(homePage.locatorStartingPrice);
    }

    @And("get Monthly Installment")
    public void get_Monthly_Installment() throws Exception {
        this.monthlyPayment = this.methods.getTextOfElement(homePage.locatorMonthlyPayment);
    }

    @When("I add the product to the cart")
    public void I_add_the_product_to_the_cart() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", homePage.btnAddToCard);
    }

    @Then("your cart page is visible")
    public void your_cart_page_is_visible(){
        this.methods.checkVisibility(homePage.cardHeader);
    }

    @And("The Starting price amount equals the amount on the previous page")
    public void The_Starting_price_amount_equals_the_amount_on_the_previous_page() throws Exception {
        this.methods.compareValueOfElements(homePage.locatorStartingPrice2, startingPrice);
    }

    @And("The Monthly Installment amount is the same as the amount on the previous page")
    public void The_Monthly_Installment_amount_is_the_same_as_the_amount_on_the_previous_page() throws Exception {
        this.methods.compareValueOfElements(homePage.locatorMonthlyPayment2, monthlyPayment);
    }

    @Given("the product has been added to the cart")
    public void the_product_has_been_added_to_the_cart(){
        this.methods.checkVisibility(homePage.cardHeader);
    }

    @When("I go to the home page")
    public void I_go_to_the_home_page(){
        homePage.buttonReturnToHomePage.click();
        the_home_page_is_visible();
    }

    @Then("in the upper right corner there is a basket icon with the number of products in the basket")
    public void in_the_upper_right_corner_there_is_a_basket_icon_with_the_number_of_products_in_the_basket() throws Exception {
        Thread.sleep(1000);
        this.methods.compareValueOfElementsWithTestData(homePage.locatorCartHeader, homePage.locatorCart, homePage.locatorCartValue, itemsInCart);
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Scenario name: " +scenario.getName().toString()+ " finished succesfully.");
        driver.quit();
    }

}
