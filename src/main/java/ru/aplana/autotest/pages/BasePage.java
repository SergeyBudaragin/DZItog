package ru.aplana.autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotest.utils.Init;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public abstract class BasePage {


    /**
     * Метод проскролливающий до элемента и нажимающий на него
     *
     * @param element веб-элемент
     */
    public void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Метод нажимающий на элемент
     *
     * @param element веб-элемент
     */
    public void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    /**
     * Метод выбирающий пункт меню
     *
     * @param menuItems список элементов меню
     * @param itemName  нужный пункт меню
     */
    public void selectMenuItem(List<WebElement> menuItems, String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }

    /**
     * Метод сравнивающий реальный и ожидаемый результаты строки
     *
     * @param expected ожидаемый результат
     * @param element  веб-элемент в котором ищем актуальный результат
     */
    public void assertPlus(String expected, WebElement element) {
        scroll(element);
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 2000);
        wait.until(ExpectedConditions.textToBePresentInElement(element, expected));
        String actual = element.getText();
        assertEquals("Error instead of expected: " + expected + " found: " + actual, expected, actual);
        if (actual.contains(expected)) {
            System.out.println(expected + "  -  found");
        }
    }

    /**
     * Метод проскролливающий до элемента
     *
     * @param element веб-элемент
     */
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 2000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Метод заполняющий поле
     *
     * @param element поле
     * @param value   значение
     */

    public void fillField(WebElement element, String value) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        element.sendKeys(value);
    }

    /**
     * Метод нажимающий чек-бокс если он не выбран
     *
     * @param element веб-элемент
     */
    public static void clickCheckBox(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * Метод ожидающий загрузки страницы
     */
    public void waitPageLoaded() {
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 30);
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver
                -> !isPresent(By.xpath("//*[@class='helpers-params loading']")));
    }

    public boolean isPresent(By locator) {
        try {
            Init.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            return Init.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            Init.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }

    /**
     * Метод проверяющий содержится ли текст в веб-элементе
     *
     * @param item искомый текст
     */
    public static void assertOzon(String item) {
        Assert.assertTrue("Товар не найден:" + item, Init.getDriver()
                .findElement(By.xpath("//*[contains(@class,'split simple m-first')]/parent::div")).getText().contains(item));
        if (Init.getDriver().findElement(By.xpath("//*[contains(@class,'split simple m-first')]/parent::div")).getText().contains(item)) {
            System.out.println(item + " - found");
        }
    }
}