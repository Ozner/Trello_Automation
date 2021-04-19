package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    final int WAIT_TIME_OUT = 15;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void implicitWait(int seconds) {
        Duration duration = Duration.ofSeconds(seconds);
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public void waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(By by) {
        waitUntilElementClickable(by);
        driver.findElement(by).click();
    }

    public WebElement getElement(By by) {
        waitUntilElementVisible(by);
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by) {
        waitUntilElementVisible(by);
        return driver.findElements(by);
    }

    public void sendKeys(By by, String text) {
        waitUntilElementClickable(by);
        waitUntilElementVisible(by);
        driver.findElement(by).sendKeys(text);
    }

    public String getTextElement(By by) {
        waitUntilElementVisible(by);
        return driver.findElement(by).getText();
    }
}
