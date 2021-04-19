package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage extends BasePage{

    private final By linkMore = By.cssSelector(".js-open-more");
    private final By linkCloseBoard = By.cssSelector(".js-close-board");
    private final By buttonCloseBoard = By.cssSelector(".js-confirm");
    private final By linkDeleteBoard = By.cssSelector(".js-delete");

    private final By headerBoardName = By.cssSelector(".js-rename-board h1");

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkMore() {
        super.click(linkMore);
    }
    public void clickLinkCloseBoard() {
        super.click(linkCloseBoard);
    }
    public void clickButtonCloseBoard() {
        super.click(buttonCloseBoard);
    }
    public void clickLinkDeleteBoard() {super.click(linkDeleteBoard);}
    public void clickButtonDeleteBoard() {super.click(buttonCloseBoard);}

    public String getTextHeaderBoardName() { return super.getTextElement(headerBoardName);}

    public void deleteBoard() {
        clickLinkMore();
        clickLinkCloseBoard();
        clickButtonCloseBoard();
        clickLinkDeleteBoard();
        clickButtonDeleteBoard();
    }
}
