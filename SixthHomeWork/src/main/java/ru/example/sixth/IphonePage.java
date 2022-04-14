package ru.example.sixth;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class IphonePage extends BaseView {
    public IphonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "button-cart")
    private WebElement addToCartButton;

    @Step("Клик на Купить")
    public IphonePage addToCartClick() {
        addToCartButton.click();
        return this;
    }

    @FindBy(xpath = "//a[@title='Корзина']")
    private WebElement cartButton;

    @Step("Клик на Корзину")
    public CartPage cartClick() {
        cartButton.click();
        return new CartPage(driver);
    }
}