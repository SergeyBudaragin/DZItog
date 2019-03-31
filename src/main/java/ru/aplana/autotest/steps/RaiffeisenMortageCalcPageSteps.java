package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import ru.aplana.autotest.pages.RaiffeisenMortgageCalcPage;

import java.util.Map;

public class RaiffeisenMortageCalcPageSteps {
    RaiffeisenMortgageCalcPage raiffeisenMortgageCalcPage = new RaiffeisenMortgageCalcPage();

    @Тогда("сравнивается заголовок страницы с \"(.*)\"")
    public void titleCheck(String expected) {
        raiffeisenMortgageCalcPage.assertPlus(expected, raiffeisenMortgageCalcPage.titleMorgagePage);
    }

    @Когда("заполняются данные")
    public void doWithParam(DataTable param) {
        Map<String, String> dataMap = param.asMap(String.class, String.class);

        //Выбор города
        raiffeisenMortgageCalcPage.city.click();
        raiffeisenMortgageCalcPage.selectMenuItem(raiffeisenMortgageCalcPage.cityList, dataMap.get("Город"));


        // Чек-бокс Знаю свою ипотечную программу
        if (dataMap.get("Знаю свою ипотечную программу").contains("Да")) {
            raiffeisenMortgageCalcPage.clickCheckBox(raiffeisenMortgageCalcPage.checkBoxKnow);
        }

        // Выбор ипотечной программы
        raiffeisenMortgageCalcPage.waitPageLoaded();
        raiffeisenMortgageCalcPage.chooseFormProgramBefore.click();
        raiffeisenMortgageCalcPage.selectMenuItem(raiffeisenMortgageCalcPage.formProgramList, dataMap.get("Вид ипотечной программы"));


        // Выбор клиента
        raiffeisenMortgageCalcPage.waitPageLoaded();
        if (dataMap.get("Я являюсь").contains("Новый клиент")) {
            raiffeisenMortgageCalcPage.chooseCategoryPerson.click();
            raiffeisenMortgageCalcPage.newPerson.click();
        }

        // Выбор документа
        raiffeisenMortgageCalcPage.waitPageLoaded();
        raiffeisenMortgageCalcPage.chooseDocumentConfirmationBefore.click();
        raiffeisenMortgageCalcPage.selectMenuItem(raiffeisenMortgageCalcPage.documentConfirmationList, dataMap.get("Уровень дохода подтверждаю"));

        raiffeisenMortgageCalcPage.waitPageLoaded();
        // Ввод cуммы ипотеки
        raiffeisenMortgageCalcPage.fillField(raiffeisenMortgageCalcPage.creditAmount, dataMap.get("В банке возьму"));

        // Ввод cуммы первоначального взноса
        raiffeisenMortgageCalcPage.fillField(raiffeisenMortgageCalcPage.initialAmount, dataMap.get("Первоначальный взнос"));

        // Ввод срока кредита
        raiffeisenMortgageCalcPage.fillField(raiffeisenMortgageCalcPage.term, dataMap.get("Срок кредита"));
    }

    @Когда("нажата кнопка \"Рассчитать\"")
    public void calcuate() {
        raiffeisenMortgageCalcPage.waitPageLoaded();
        raiffeisenMortgageCalcPage.buttonCalculate.click();
    }


    @Тогда("сравниваются значения")
    public void Assert(DataTable param) {
        Map<String, String> dataMap = param.asMap(String.class, String.class);

        raiffeisenMortgageCalcPage.assertPlus(dataMap.get("Ежемесячный платеж"), raiffeisenMortgageCalcPage.montlyPayment);
        raiffeisenMortgageCalcPage.assertPlus(dataMap.get("Общая сумма выплат"), raiffeisenMortgageCalcPage.totalAmount);
        raiffeisenMortgageCalcPage.assertPlus(dataMap.get("Cумма выплат по процентам"), raiffeisenMortgageCalcPage.totalPercent);
        raiffeisenMortgageCalcPage.assertPlus(dataMap.get("Процентная ставка"), raiffeisenMortgageCalcPage.rate);
    }

}