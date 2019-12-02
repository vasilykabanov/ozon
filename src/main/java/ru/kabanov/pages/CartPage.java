package ru.kabanov.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.kabanov.steps.BaseSteps;

import java.util.List;
import java.util.Map;

/**
 * Created by yasup on 30.11.2019.
 */
public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@class='a5c8']/span")
    public List<WebElement> productsInCart;

    @FindBy(xpath = "//div[@class='ap0']//span[2]")
    public WebElement countProductinCart;

    @FindBy(xpath = "//span[contains(text(), 'Удалить выбранные')]")
    public WebElement deleteAllProducts;

    @FindBy(xpath = "//button[@data-test-id='checkcart-confirm-modal-confirm-button']")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//*[contains(text(), 'Корзина пуста')]")
    public WebElement  cartIsEmpty;

    public boolean productsExist() {
        Map<String, String> selectedProducts = BaseSteps.getSelectedProducts();
        for (WebElement product : productsInCart) {
            if (!selectedProducts.containsValue(product.getText())) {
                return false;
            }
        }
        return true;
    }

    public void checkCountProduct(String countProduct) {
        Assert.assertTrue(waitElementIsDisplayed(countProductinCart).getText().contains(countProduct));
    }

    public void deleteAllProducts(){
        waitElementToBeClickable(deleteAllProducts).click();
        waitElementToBeClickable(confirmDeleteButton).click();
    }

    public void checkTextCartIsEmpty() {
        Assert.assertTrue(waitElementIsDisplayed(cartIsEmpty).isDisplayed());
    }

}
