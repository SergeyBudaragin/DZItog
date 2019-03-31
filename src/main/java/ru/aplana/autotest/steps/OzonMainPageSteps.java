package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import org.openqa.selenium.Keys;
import ru.aplana.autotest.pages.OzonMainPage;

public class OzonMainPageSteps {
    OzonMainPage ozonMainPage = new OzonMainPage();


    @Когда("выполняется авторизация")
    public void autorisation() {
        ozonMainPage.myOzon.click();
        ozonMainPage.enter.click();
        ozonMainPage.enterByEmail.click();
        ozonMainPage.emailField.sendKeys("lestate@rambler.ru");
        ozonMainPage.passwordField.sendKeys("asdasd123");
        ozonMainPage.submitButton.click();
    }

    @Когда("выполняется поиск по \"(.*)\"")
    public void search(String searchItem) {
        ozonMainPage.fillField(ozonMainPage.searchField, searchItem);
        ozonMainPage.searchField.sendKeys(Keys.RETURN);
    }


    @Когда("выходим из учетной записи")
    public void quit() {
        ozonMainPage.scrollAndClick(ozonMainPage.myOzonlogin);
        ozonMainPage.scrollAndClick(ozonMainPage.quit);
    }
}
