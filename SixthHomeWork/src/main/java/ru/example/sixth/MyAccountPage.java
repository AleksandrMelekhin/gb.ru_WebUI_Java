package ru.example.sixth;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseView {
    public MyAccountPage(WebDriver driver) {
        super(driver);
        phonesPage = new PhonesPage(driver);
    }

    @FindBy(xpath = "//a[@href='http://testerlaru.temp.swtest.ru/index.php?route=product/category&path=24']")
    private WebElement phonesButton;

    @Step("Клик на блок Телефоны")
    public PhonesPage clickPhonesButton() {
        phonesButton.click();
        return new PhonesPage(driver);
    }

    public PhonesPage phonesPage;
}

