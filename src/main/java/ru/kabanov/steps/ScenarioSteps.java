package ru.kabanov.steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

/**
 * Created by yasup on 27.11.2019.
 */
public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    CategorySteps categorySteps = new CategorySteps();
    SearchResultSteps searchResultSteps = new SearchResultSteps();
    CartSteps cartSteps = new CartSteps();
    BaseSteps baseSteps = new BaseSteps();

    @Когда("^закрываем окно с cookies$")
    public void whenClickCookiesClose() {
        mainSteps.stepClickCookiesClose();
    }

    @Тогда("выполняем поиск продукта \"(.*)\"")
    public void thenSearchProduct(String productName) {
        mainSteps.stepSearchProduct(productName);
    }

    @Тогда("ограничиваем цену до \"(.*)\"")
    public void thenLimitPrice(String limit) {
        categorySteps.stepLimitPrice(limit);
    }

    @Тогда("^отмечаем чекбокс - \"(.*)\"$")
    public void thenClickCheckBox(String checkBoxName) throws InterruptedException {
        categorySteps.stepClickCheckBox(checkBoxName);
    }

    @Тогда("^смотрим на все бренды$")
    public void thenClickAllBrands() throws InterruptedException {
        categorySteps.stepClickAllBrands();
    }

    @Тогда("^выбираем бренд - \"(.*)\"$")
    public void thenChooseBrends(String nameBrand) throws InterruptedException {
        categorySteps.stepChooseBrands(nameBrand);
    }

    @Тогда("добавляем в корзину первые \"(.*)\" \"(.*)\" товаров")
    public void thenInputInCart(String count, String parity) {
        searchResultSteps.stepInputInCart(count, parity);
    }

    @Тогда("добавляем в корзину \"(.*)\" \"(.*)\" товары")
    public void thenInputInCart2(String count, String parity) {
        searchResultSteps.stepInputInCart(count, parity);
    }

    @Тогда("^переходим в корзину$")
    public void thenGoToCart() throws InterruptedException {
        searchResultSteps.stepClickCart();
    }

    @Тогда("^проверяем товары в корзине$")
    public void thenCheckItems() {
        cartSteps.stepCheckItems();
    }

    @Тогда("^проверяем текст \"Ваша корзина - \"(.*)\"\"$")
    public void thenCheckCountProduct(String countProduct) {
        cartSteps.stepCheckCountProduct(countProduct);
    }

    @Тогда("^удаляем все товары из корзины$")
    public void thenDeleteAllProducts() {
        cartSteps.stepDeleteAllProducts();
    }

    @Тогда("^проверяем, что корзина пустая$")
    public void thenСheckTextCartIsEmpty() {
        cartSteps.stepСheckTextCartIsEmpty();
    }

    @Тогда("прикладываем файл с информацией о всех добавленных товарах")
    public void attachmentStep() {
        baseSteps.saveText("Cart products", baseSteps.toString() + "\nТовар с максимальной ценой: " + baseSteps.getMaxPrice());
    }
}
