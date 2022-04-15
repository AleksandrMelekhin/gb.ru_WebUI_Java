package ru.example.sixth;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class PhonesPage extends BaseView {
    public PhonesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='http://testerlaru.temp.swtest.ru/index.php?route=product/product&path=24&product_id=40']")
    private WebElement iphoneButton;

    @Step("Перейти к товару айфон")
    public IphonePage iphoneClick() {
        iphoneButton.click();
        IphonePage iphonePage = new IphonePage(driver);
        return iphonePage;
    }
}


