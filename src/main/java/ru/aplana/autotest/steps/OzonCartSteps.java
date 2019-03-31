package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import org.openqa.selenium.By;
import ru.aplana.autotest.pages.OzonCartPage;
import ru.aplana.autotest.utils.Init;

public class OzonCartSteps {
    OzonCartPage ozonCartPage = new OzonCartPage();

    @Когда("сравниваем товары в корзине с \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"")
    public void check(String item1, String item2, String item3, String item4, String item5) {
        ozonCartPage.assertOzon(item1);
        ozonCartPage.assertOzon(item2);
        ozonCartPage.assertOzon(item3);
        ozonCartPage.assertOzon(item4);
        ozonCartPage.assertOzon(item5);
    }

    @Когда("очищаем корзину")
    public void deleteItemsFromCart() {
        ozonCartPage.scrollAndClick(ozonCartPage.delete);
        ozonCartPage.scrollAndClick(ozonCartPage.deleteConfirm);
    }


    @Когда("проверяем, что корзина пуста")
    public void checkCartEmpty() {
        ozonCartPage.assertPlus("Корзина пуста", Init.getDriver().findElement(By.xpath("//*[contains(@class,'cart-title')]")));
    }
}


