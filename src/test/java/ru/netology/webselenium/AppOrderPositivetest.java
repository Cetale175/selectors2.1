package ru.netology.webselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppOrderPositivetest {

    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();}


    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }


    @AfterEach
    void teardown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldBeSuccessfulForm(){
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иваныч-Ивановичев Иван");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+78005553535");
        driver.findElement(By.cssSelector("[data-test-id=argument]")).click();
        driver.findElement(By.cssSelector("[button.button]")).click();
        var actualText = driver.findElement(By.cssSelector("data-test-id-success]")).getText().trim();
        assertEquals("Ваша заяавка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText);
    }
}