package ru.aplana.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.aplana.autotest.utils.Init;

public class OzonCatalogPage extends BasePage {

    @FindBy(xpath = "//*[contains(@data-test-id,'header-cart')]")
    public WebElement cart;

    public void addProduct(String productName) {
        scroll(Init.getDriver().findElement(By.xpath("//*[contains(text(),'" + productName + "')]/parent::div/following-sibling::div[contains(@class,'buy-button-container')]")));
        Init.getDriver().findElement(By.xpath("//*[contains(text(),'" + productName + "')]/parent::div/following-sibling::div[contains(@class,'buy-button-container')]")).click();
    }

    public OzonCatalogPage() {
        PageFactory.initElements(Init.getDriver(), this);
    }
}
