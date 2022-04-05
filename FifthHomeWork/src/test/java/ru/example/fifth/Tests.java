package ru.example.fifth;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Tests {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String STORE_URL = "http://automationpractice.com/index.php";

    @BeforeAll
    static void driverRegister () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver () {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(STORE_URL);
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Добавляем футболку в корзину")
    void addTshirtToCartTest() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//a[(@title='Women')]")))
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='T-shirts']")));
        driver.findElement(By.xpath("//a[@title='T-shirts']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='color_to_pick" +
                "_list clearfix']")));
        actions.moveToElement(driver.findElement(By.xpath("//ul[@class='color_to_pick_list clearfix']")))
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button " +
                "ajax_add_to_cart_button btn btn-default']")));
        driver.findElement(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer_cart_product " +
                "col-xs-12 col-md-6']//h2")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='layer_cart_product " +
                "col-xs-12 col-md-6']//h2")).getText(), "Product successfully added to your shopping cart");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
