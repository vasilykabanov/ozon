package ru.kabanov.steps;

import ru.kabanov.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 27.11.2019.
 */
public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("Закрыть окно с куками")
    public void stepClickCookiesClose() {
        mainPage.clickCookiesClose();
    }

    @Step("Выполнить поиск продукта {0}")
    public void stepSearchProduct(String productName) {
        mainPage.searchProduct(productName);
    }


}
