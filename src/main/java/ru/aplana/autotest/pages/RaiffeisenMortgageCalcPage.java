package ru.aplana.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotest.utils.Init;

import java.util.List;

public class RaiffeisenMortgageCalcPage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class,'e-title e-title--h2')]")
    public WebElement titleMorgagePage;

    @FindBy(xpath = "//select[contains(@id, 'form_city')]/parent::div")
    public WebElement city;

    @FindBy(xpath = "//*[contains(@aria-labelledby,'form_city-button')]//li")
    public List<WebElement> cityList;

    @FindBy(xpath = "//*[contains(@class,'checkbox-block__span')]")
    public WebElement checkBoxKnow;

    @FindBy(xpath = "//*[contains(@id,'form_program-button')]/parent::div")
    public WebElement chooseFormProgramBefore;

    @FindBy(xpath = "//*[contains(@aria-labelledby,'orm_program-button')]//li")
    public List<WebElement> formProgramList;

    @FindBy(xpath = "//*[contains(@id,'form_category-button')]/parent::div")
    public WebElement chooseCategoryPerson;

    @FindBy(xpath = "//div[contains(text(),'Новый клиент')]")
    public WebElement newPerson;

    @FindBy(xpath = "//*[contains(@id,'form_documents-button')]")
    public WebElement chooseDocumentConfirmationBefore;

    @FindBy(xpath = "//*[contains(@aria-labelledby,'form_documents-button')]//li")
    public List<WebElement> documentConfirmationList;

    @FindBy(xpath = "//*[contains(@id,'form_credit_amount')]")
    public WebElement creditAmount;

    @FindBy(xpath = "//*[contains(@id,'form_initial')]")
    public WebElement initialAmount;

    @FindBy(xpath = "//*[contains(@id,'form_period')]")
    public WebElement term;

    @FindBy(xpath = "//*[contains(@class,'b-block-row__item b-block-row__item--half')]//input")
    public WebElement buttonCalculate;

    @FindBy(xpath = "//*[contains(@class,'monthly-payment')]")
    public WebElement montlyPayment;

    @FindBy(xpath = "//*[contains(@class,'b-calc-result__text--right total-payment')]")
    public WebElement totalAmount;

    @FindBy(xpath = "//*[contains(@class,'b-calc-result__text--right percent-sum')]")
    public WebElement totalPercent;

    @FindBy(xpath = "//*[contains(@class,'b-calc-result__text--right interest-rate')]")
    public WebElement rate;

    public RaiffeisenMortgageCalcPage() {
        PageFactory.initElements(Init.getDriver(), this);
    }


}