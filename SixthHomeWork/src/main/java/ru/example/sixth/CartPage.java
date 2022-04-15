package ru.example.sixth;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CartPage extends BaseView {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final static String useCouponXpathLocator = "//a[@href='#collapse-coupon']";

    @FindBy(xpath = useCouponXpathLocator)
    private WebElement successIcon;

    @Step("Проверить наличие кнопки Использоваь купон")
    public void checkSuccess() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(useCouponXpathLocator)));

        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//a[@href='#collapse-coupon']")), isDisplayed())
        );
    }
}


