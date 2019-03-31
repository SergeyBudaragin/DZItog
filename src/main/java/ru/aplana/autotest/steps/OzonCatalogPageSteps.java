package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import ru.aplana.autotest.pages.OzonCatalogPage;

public class OzonCatalogPageSteps {
    OzonCatalogPage ozonCatalogPage = new OzonCatalogPage();


    @Когда("добавляем товары в корзину \"(.*)\"")
    public void addProduct(String itemName) {
        ozonCatalogPage.addProduct(itemName);
    }

    @Когда("переходим в корзину")
    public void goCart() {
        ozonCatalogPage.cart.click();
    }


}

