package ru.kabanov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.kabanov.steps.BaseSteps;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by yasup on 30.11.2019.
 */
public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//*[@class='tile m-list m-border']")
    List<WebElement> productList;

    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement cart;

    @FindBy(xpath = ".//div[contains(text(),'В корзину')]")
    private List<WebElement> inCartButtons;

    public void inputInCart(String count, boolean parity) {
        TreeMap<String, String> selectedProducts = BaseSteps.getSelectedProducts();
        if (!parity) {
            for (int i = 0; i < Integer.parseInt(count) * 2; i += 2) {
                String name = productList.get(i).findElement(By.xpath(".//span[@data-test-id='tile-name']")).getText();
                String price = productList.get(i)
                        .findElement(By.xpath(".//span[@data-test-id='tile-price']")).getText();
//                        .replaceAll("[^0-9]", "");
                selectedProducts.put(price, name);
                waitElementToBeClickable(productList.get(i).findElement(By.xpath(".//div[contains(text(),'В корзину')]"))).click();
            }
        } else if (parity && count.equalsIgnoreCase("все")){
            for (int i = 1; i < (productList.size() + 1) / 2; i += 2) {
                String name = productList.get(i).findElement(By.xpath(".//span[@data-test-id='tile-name']")).getText();
                String price = productList.get(i).findElement(By.xpath(".//span[@data-test-id='tile-price']")).getText();
                selectedProducts.put(price, name);
                waitElementToBeClickable(productList.get(i).findElement(By.xpath(".//div[contains(text(),'В корзину')]"))).click();
            }
        }
    }

    public void clickCart() throws InterruptedException {
        scrollIntoView(cart);
        waitElementToBeClickable(cart).click();
    }
}
