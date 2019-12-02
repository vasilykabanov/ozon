package ru.kabanov.steps;

import ru.kabanov.pages.CategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 30.11.2019.
 */
public class CategorySteps {

    CategoryPage categoryPage = new CategoryPage();

    @Step("Ограничить цену до {0}")
    public void stepLimitPrice(String limit) {
        categoryPage.limitPrice(limit);
    }

    @Step("Отметить чекбокс - {0}")
    public void stepClickCheckBox(String checkBoxName) throws InterruptedException {
        categoryPage.clickCheckBoxes(checkBoxName);
    }

    @Step("Посмотреть все бренды")
    public void stepClickAllBrands() throws InterruptedException {
        categoryPage.clickAllBrands();
    }

    @Step("Выбрать бренд - {0}")
    public void stepChooseBrands(String nameBrand) throws InterruptedException {
        categoryPage.chooseBrands(nameBrand);
    }

}
