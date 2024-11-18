package com.ait.qa49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

//находим список элементов
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementBySimpleLocators() {
        //by id
        driver.findElement(By.id("city"));
        //by class name
        driver.findElement(By.className("header"));

        //by link Text
        WebElement carWork = driver.findElement(By.linkText("Let the car work"));
        System.out.println(carWork);

        WebElement car = driver.findElement(By.partialLinkText("car"));
        System.out.println(car);
    }

    @Test
    public void findElementByCssSelectorTest() {
//        tag Name == css
//        driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));
//        id=> css(#)
//    driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

//        classname css
//        driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));


        driver.findElement(By.cssSelector("[href=\"/login?url=%2Fsearch\"]"));
        //contains *
        driver.findElement(By.cssSelector("[href*=\"login\"]"));
//        driver.findElement(By.cssSelector("[href*='login']"));

//start ^ начало
        driver.findElement(By.cssSelector("[href^=\"/log\"]"));

//    end $ конец
        driver.findElement(By.cssSelector("[href$=\"search\"]"));

    }
}

//