package DriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

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
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
