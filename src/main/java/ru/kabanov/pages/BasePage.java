package ru.kabanov.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.kabanov.steps.BaseSteps;

/**
 * Created by yasup on 27.11.2019.
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public WebElement waitElementIsDisplayed(WebElement element) {
        return BaseSteps.getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return BaseSteps.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fieldInput(WebElement element, String value) {
        waitElementToBeClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void scrollIntoView(WebElement element) {
        waitElementIsDisplayed(element);
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
