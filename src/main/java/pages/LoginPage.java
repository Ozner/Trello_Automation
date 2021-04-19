package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;

public class LoginPage extends BasePage {

    private final By linkSignIn = By.cssSelector("a[href^='/login'] ");
    private final By inputEmail = By.id("user");
    private final By inputPass = By.id("password");
    private final By buttonLoginAtlassian = By.id("login");
    private final By buttonLogin = By.id("login-submit");
    private final By divMessageInvalidUser = By.cssSelector("#error p");
    private final By spanLoginError = By.cssSelector("#login-error span");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInLink() {
        super.click(linkSignIn);
    }
    public void typeEmail(String user) {
        super.sendKeys(inputEmail, user);
    }
    public void typePassword(String pass) {
        super.sendKeys(inputPass, pass);
    }
    public void clickButtonLoginAtlassian(){super.click(buttonLoginAtlassian);}
    public void clickButtonLogin(){super.click(buttonLogin);}
    public String getTextMessageInvalidUser(){return super.getTextElement(divMessageInvalidUser);}
    public String getTextSpanLoginError(){return super.getTextElement(spanLoginError);}

    public void login(String user, String pass) throws InterruptedException {
        clickSignInLink();
        typeEmail(user);
        clickButtonLoginAtlassian();
        //super.implicitWait(50);
        Thread.sleep(1000);
        typePassword(pass);
        clickButtonLogin();
    }

    public void invalidLogin(String user, String pass) {
        clickSignInLink();
        typeEmail(user);
        typePassword(pass);
        clickButtonLoginAtlassian();
    }
}
