package ru.example.sixth;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BaseView {
    @FindBy(xpath = "//a[@title='Личный кабинет']")
    public WebElement accountButton;

    @Step("Клик на кнопку Личный кабинет")
    public MainPage clickAccountButton() {
        accountButton.click();
        return this;
    }
    @FindBy(xpath = "//a[@href='http://testerlaru.temp.swtest.ru/index.php?route=account/login']")
    public WebElement signInButton;

    @Step("Клик на кнопку авторизации")
    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
        }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
