package ru.kabanov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yasup on 27.11.2019.
 */
public class MainPage extends BasePage {


    @FindBy(xpath = "//div[@class='a8x3']/input")
    public WebElement mainSearchLine;

    @FindBy(xpath = "//div[@class='search-button-wrap']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@class='close']")
    public WebElement cookiesCloseButton;

    public void clickCookiesClose() {
        if (cookiesCloseButton.isDisplayed())
        waitElementIsDisplayed(cookiesCloseButton).click();
    }

    public void clickSearch() {
        waitElementToBeClickable(searchButton).click();
    }

    public void searchProduct(String productName) {
        fieldInput(mainSearchLine, productName);
        clickSearch();
    }



}
