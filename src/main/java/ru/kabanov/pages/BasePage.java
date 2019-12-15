package ru.kabanov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.kabanov.steps.BaseSteps;

import java.util.concurrent.TimeUnit;

/**
 * Created by yasup on 27.11.2019.
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public WebElement waitVisibilityOfElementLocated(By locator) {
        return BaseSteps.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitElementIsDisplayed(WebElement element) {
        return BaseSteps.getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return BaseSteps.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementPresent(By locator) {
        try{
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            WebElement element = BaseSteps.getDriver().findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            return false;
        }
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
