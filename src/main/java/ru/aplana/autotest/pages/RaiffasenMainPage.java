package ru.aplana.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotest.utils.Init;

import java.util.List;

public class RaiffasenMainPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"main-menu\"]//li")
    public List<WebElement> mainMenu;

    @FindBy(xpath = "//*[contains(@href,'retail/mortgageloans/calculator/')]")
    public WebElement mortageCalc;

    public RaiffasenMainPage() {
        PageFactory.initElements(Init.getDriver(), this);
    }


}
