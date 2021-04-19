package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static helpers.Utils.*;

public class BoardsPage extends BasePage{

    private final By liAddNewBoard = By.cssSelector("li[data-test-id='create-board-tile']");
    private final By inputTitleNewBoard = By.cssSelector("input[data-test-id='create-board-title-input']");
    private final By buttonCreateBoard = By.cssSelector("button[data-test-id='create-board-submit-button']");

    private final By buttonAccount = By.cssSelector("button[data-test-id='header-member-menu-button']");
    private final By divUserName = By.className("_1njv2a9PIrnydF");
    private final By spanUserEmail = By.className("_2TvKKP0vwCN5Zd");

    public BoardsPage(WebDriver driver) {
        super(driver);
    }

    public void clickLiAddNewBoard() {
        super.click(liAddNewBoard);
    }
    public  void typeTitleNewBoard(String boardName) { super.sendKeys(inputTitleNewBoard, boardName);}
    public void clickButtonCreateBoard() { super.click(buttonCreateBoard);}
    public void clickButtonAccount() {super.click(buttonAccount);}

    public String getTextDivUserName() {
        return super.getTextElement(divUserName);
    }

    public String getTextSpanUserEmail(){
        return super.getTextElement(spanUserEmail);
    }

    public void createNewBoard(String boardName) {
        clickLiAddNewBoard();
        typeTitleNewBoard(boardName);
        clickButtonCreateBoard();
    }

    public String getUserNameLogged() {
        clickButtonAccount();
        return getTextDivUserName();
    }
}
