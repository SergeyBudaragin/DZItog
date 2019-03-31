package ru.aplana.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotest.utils.Init;

public class OzonCartPage extends BasePage {


    @FindBy(xpath = "//*[contains(@class,'header-btn hack m-delete button default')]")
    public WebElement delete;

    @FindBy(xpath = "//*[contains(@data-test-id, 'checkcart-confirm-modal-confirm-button')]")
    public WebElement deleteConfirm;

    public OzonCartPage() {
        PageFactory.initElements(Init.getDriver(), this);
    }
}
