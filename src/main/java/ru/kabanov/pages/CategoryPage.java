package ru.kabanov.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kabanov.steps.BaseSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yasup on 30.11.2019.
 */
public class CategoryPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/..//label[text()='до']/../input")
    public WebElement inputLimitPrice;

    @FindBy(xpath = "(//span[@class='checkmark'])[15]")
    public WebElement highRating;

    @FindBy(xpath = "(//span[@class='checkmark'])[6]")
    public WebElement ram3gb;

    @FindBy(xpath = "//label[@class='checkbox-label']")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    public WebElement checkAllBrands;

    @FindBy(xpath = "//div[contains(text(), 'Бренды')]/..//input[1]")
    public WebElement searchBrand;

    public void limitPrice(String limit) {
        waitElementToBeClickable(inputLimitPrice).click();
        inputLimitPrice.sendKeys(Keys.CONTROL + Keys.chord("a") + Keys.BACK_SPACE + Keys.chord(limit));
//        inputLimitPrice.sendKeys(Keys.ENTER);
    }

    public void clickHighRating() {
        waitElementIsDisplayed(highRating).click();
    }

    public void clicRam3gb() {
        waitElementIsDisplayed(ram3gb).click();
    }

    public void clickCheckBoxes(String checkBoxName) throws InterruptedException {
        if (BaseSteps.getDriver().findElement(By.xpath("//*[@class='block-vertical']")).isDisplayed()) {
            for (WebElement item : checkBoxes) {
                if (item.findElement(By.xpath("//span[contains(text(), '" + checkBoxName + "')]")).getText().equalsIgnoreCase(checkBoxName)) {
                    item.findElement(By.xpath("//label//span[contains(text(), '" + checkBoxName + "')]")).click();
                    waitPageLoaded();
                    return;
                }
            }
            Assert.fail("Не найден чекбокс! " + checkBoxName);
        } else Assert.fail("Элемент не отображается!");
    }

    public void clickAllBrands() {
        waitElementToBeClickable(checkAllBrands).click();
    }

    public void chooseBrands(String nameBrand) throws InterruptedException {
            fieldInput(searchBrand, nameBrand);
            clickCheckBoxes(nameBrand);
    }

    public void waitPageLoaded() {
        new WebDriverWait(BaseSteps.getDriver(), 45)
                .until((ExpectedCondition<Boolean>) webDriver -> !isElementPresent(By.xpath("//div[contains(@class , 'parandja')]")));
    }
}
