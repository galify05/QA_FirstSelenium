package com.ait.qa49;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver.get("https://yandex.com/");

        // открываем норм окно
        driver.manage().window().maximize();

        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.navigate().to("https://yandex.com/");
        driver.navigate().to("https://habr.com/ru/companies/ruvds/articles/769902/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    // test
    @Test
    public void openYandexTest() {
        System.out.println("Яндекс открыт");
    }

    // after - tearDown
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
