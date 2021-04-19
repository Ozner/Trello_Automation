package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.BoardsPage;
import pages.ListPage;
import pages.LoginPage;
import static helpers.Utils.generateRandomNumber;
import static org.testng.Assert.assertEquals;

public class CreateBoardTest extends BaseTest {

    private LoginPage loginPage;
    private BoardsPage boardsPage;
    private BoardPage boardPage;
    private ListPage listPage;


    @BeforeMethod
    public void createBoardBeforeMethod() {
        loginPage = new LoginPage(super.driver);
        boardsPage = new BoardsPage(super.driver);
        boardPage = new BoardPage(super.driver);
        listPage = new ListPage(super.driver);
    }

    @Test(description = "Verify that a valid user can login to the application")
    @Description("Verify that a valid user can login to the application")
    public void validCreateNewBoard() throws InterruptedException {
        String boardName = "";
        String currentBoardName = "";
        loginPage.login(user1,pass1);
        boardName = "New Board Test - " + generateRandomNumber(7);
        boardsPage.createNewBoard(boardName);
        currentBoardName = boardPage.getTextHeaderBoardName();
        assertEquals(currentBoardName, boardName);
        assertEquals(super.driver.getTitle(), boardName + " | Trello");
        boardPage.deleteBoard();
    }

    @Test(description = "Verify that a valid user can login to the application")
    @Description("Verify that a valid user can login to the application")
    public void validCreateNewList() throws InterruptedException {
        String newListTitle = "New List Test";
        String currentListTitle = "";
        String boardName = "";

        loginPage.login(user1,pass1);
        boardName = "New Board Test - " + generateRandomNumber(7);
        boardsPage.createNewBoard(boardName);
        listPage.createNewList(newListTitle);
        currentListTitle = listPage.getTitleText(0);
        assertEquals(currentListTitle,newListTitle);
        boardPage.deleteBoard();
    }
}
