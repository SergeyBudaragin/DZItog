package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import ru.aplana.autotest.pages.RaiffasenMainPage;

public class RaiffeisenMainPageSteps {
    RaiffasenMainPage raiffasenMainPage = new RaiffasenMainPage();

    @Когда("выбран пункт меню \"(.*)\"")
    public void mainMenu(String mainMenuItem) {
        raiffasenMainPage.selectMenuItem(raiffasenMainPage.mainMenu, mainMenuItem);
    }

    @Когда("выбран подпункт меню \"Ипотечный калькулятор\"")
    public void subMenu() {
        raiffasenMainPage.click(raiffasenMainPage.mortageCalc);
    }


}


