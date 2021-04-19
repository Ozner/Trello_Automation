package tests;

import helpers.ListenerFailure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import pages.BoardsPage;
import pages.LoginPage;


public class LoginTest extends BaseTest{

    private LoginPage loginPage;
    private BoardsPage boardsPage;

    @BeforeMethod
    public void loginBeforeMethod() {
        loginPage = new LoginPage(super.driver);
        boardsPage = new BoardsPage(super.driver);
    }

    @Test(description = "Valid login test")
    @Description("Verify that a valid user can login successfully")
    public void validLoginTest() throws InterruptedException {
        loginPage.login(user1, pass1);
        String currentUserName = boardsPage.getUserNameLogged();
        String currentUserEmail = boardsPage.getTextSpanUserEmail();
        String pageTitle = "Tableros | Trello";

        assertEquals(super.driver.getTitle(), pageTitle);
        assertEquals(currentUserName, userName);
        assertEquals(currentUserEmail, user1);

    }

    @Test(description = "Invalid login test - user")
    @Description("Verify that a invalid user not allow access")
    public void invalidUserLoginTest() {
        loginPage.invalidLogin("unexistuser@unexistuser.com", pass1);
        assertEquals(loginPage.getTextMessageInvalidUser(), "There isn't an account for this email");
    }

    @Test(description = "Invalid login test - pass")
    @Description("Verify that a invalid pass not allow to access")
    public void invalidPassLoginTest() throws InterruptedException {
        loginPage.login(user1, "invalid_password");
        assertEquals(loginPage.getTextSpanLoginError(), "Incorrect email address and / or password.\nDo you need help logging in?");
    }
}
