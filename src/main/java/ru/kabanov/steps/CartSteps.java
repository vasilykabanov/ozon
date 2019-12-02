package ru.kabanov.steps;


import ru.kabanov.pages.CartPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 01.12.2019.
 */
public class CartSteps {

    CartPage cartPage = new CartPage();

    @Step ("Проверка товаров в корзине")
    public void stepCheckItems() {
        cartPage.productsExist();
    }

    @Step ("Проверка отображения текста {0}")
    public void stepCheckCountProduct(String countProduct) {
        cartPage.checkCountProduct(countProduct);
    }

    @Step ("Удалить все товары из корзины")
    public void stepDeleteAllProducts() {
        cartPage.deleteAllProducts();
    }

    @Step ("Проверка отображения текста пустой корзины")
    public void stepСheckTextCartIsEmpty() {
        cartPage.checkTextCartIsEmpty();
    }

}
