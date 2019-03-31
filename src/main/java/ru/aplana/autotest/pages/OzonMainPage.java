package ru.aplana.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotest.utils.Init;

public class OzonMainPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Мой')]")
    public WebElement myOzon;

    @FindBy(xpath = "//*[contains(@data-test-id,'header-my-ozon-icon')]")
    public WebElement myOzonlogin;

    @FindBy(xpath = "//*[contains(text(),'Выйти')]")
    public WebElement quit;

    @FindBy(xpath = "//*[contains(text(),'Вход или')]")
    public WebElement enter;

    @FindBy(xpath = "//*[contains(text(),'Войти')]")
    public WebElement enterByEmail;

    @FindBy(xpath = "//*[contains(@data-test-id,'emailField')]")
    public WebElement emailField;

    @FindBy(xpath = "//*[contains(@data-test-id,'pass')]")
    public WebElement passwordField;

    @FindBy(xpath = "//*[contains(@data-test-id,'header-search-input')]")
    public WebElement searchField;

    @FindBy(xpath = "//*[contains(@class,'submit-button')]")
    public WebElement submitButton;

    public OzonMainPage() {
        PageFactory.initElements(Init.getDriver(), this);
    }

}
