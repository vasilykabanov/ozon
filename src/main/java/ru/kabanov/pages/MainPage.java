package ru.kabanov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yasup on 27.11.2019.
 */
public class MainPage extends BasePage {


    @FindBy(xpath = "//input[@placeholder='Искать на Ozon']")
    public WebElement mainSearchLine;

    @FindBy(xpath = "//button[@type='submit'][1]")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@aria-label='Закрыть сообщение']")
    public WebElement cookiesCloseButton;

    public void clickCookiesClose() {
        if (isElementPresent(By.xpath("//button[@aria-label='Закрыть сообщение']"))) {
            waitElementToBeClickable(cookiesCloseButton).click();
        }
    }

    public void clickSearch() {
        waitElementToBeClickable(searchButton).click();
    }

    public void searchProduct(String productName) {
        fieldInput(mainSearchLine, productName);
        clickSearch();
    }



}
