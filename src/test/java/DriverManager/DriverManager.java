package DriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.logging.Logger;

public class DriverManager {

    private WebDriver driver;

    public void startSeleniumSession() {
        ChromeOptions options = new ChromeOptions();
        if (driver == null) {
            this.driver = new ChromeDriver(options);
        }
    }

    public void configure() {
        this.driver.manage().deleteAllCookies();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


//        Wait<WebDriver> wait =
//                new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(2))
//                        .pollingEvery(Duration.ofMillis(300))
//                        .ignoring(ElementNotInteractableException.class);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
