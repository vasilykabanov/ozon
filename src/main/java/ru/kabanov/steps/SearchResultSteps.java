package ru.kabanov.steps;

import ru.kabanov.pages.SearchResultPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 01.12.2019.
 */
public class SearchResultSteps {

    SearchResultPage searchResultPage = new SearchResultPage();

    @Step("Добавить в корзину {0} {1} товары")
    public void stepInputInCart(String count, String parity) {
        if (parity.equalsIgnoreCase("нечетных")) {
            searchResultPage.inputInCart(count, false);
        } else if (parity.equalsIgnoreCase("четные")) {
            searchResultPage.inputInCart(count, true);
        }
    }

    @Step("Перейти в корзину")
    public void stepClickCart() throws InterruptedException {
        searchResultPage.clickCart();
    }
}
