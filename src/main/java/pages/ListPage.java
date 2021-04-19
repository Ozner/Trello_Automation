package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListPage extends BasePage{

    private final By inputTitleList = By.cssSelector("input[name='name']");
    private final By buttonAddList = By.className("js-save-edit");

    private final By textAreaTitle = By.className("js-list-name-input");

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public void typeTitleList(String listName) { super.sendKeys(inputTitleList, listName);}
    public void clickButtonAddList(){super.click(buttonAddList);}
    public String getTitleText(int listNumber) { return super.getElements(textAreaTitle).get(listNumber).getText(); }

    public void createNewList(String listName) {
        typeTitleList(listName);
        clickButtonAddList();
    }
}
