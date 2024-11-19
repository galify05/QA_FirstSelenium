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

public class Homework {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openWebsite() {
        System.out.println("Страница открыта");
    }

    @Test
    public void findElementByTagName() {
        // 1
        List<WebElement> divElements = driver.findElements(By.tagName("div"));
        System.out.println(divElements.size());
        //2
        driver.findElement(By.tagName("a"));
    }

    @Test
    public void findElementBySimpleLocatorsTest() {
        //3
        driver.findElement(By.id("flyout-cart"));
        //4
        driver.findElement(By.className("footer-store-theme"));
        //5
        driver.findElement(By.linkText("Log in"));
        //6
        List<WebElement> logElements = driver.findElements(By.partialLinkText("us"));
        System.out.println("\"us\" on page: " + logElements.size());
        //7
        System.out.println("\"li\" elements on page: " + driver.findElements(By.tagName("li")).size());
        //8
        driver.findElement(By.tagName("head"));
        //9
        driver.findElement(By.id("nivo-slider"));
        //10
        driver.findElement(By.partialLinkText("My"));
    }

    @Test
    public void cssTesting() {
        //1
        driver.findElement(By.cssSelector("#nivo-slider"));
        //2
        driver.findElement(By.cssSelector("#flyout-cart"));
        //3
        driver.findElement(By.cssSelector(".footer-store-theme"));
        //4
        List<WebElement> nivoBoxes = driver.findElements(By.cssSelector(".nivo-box")); // не работает на 2 секундах
        System.out.println("\"nivo-box\" classes on page: " + nivoBoxes.size());
        //5
        driver.findElement(By.cssSelector("span"));
        //6
        driver.findElement(By.cssSelector("body"));
        //7
        System.out.println(driver.findElement(By.cssSelector("[href=\"/cart\"]")).getText());
        //8
        System.out.println(driver.findElement(By.cssSelector("[href=\"/login\"]")).getText());
        //9
        System.out.println(driver.findElement(By.cssSelector("[href$='returns']")).getText());
        //10
        System.out.println(driver.findElement(By.cssSelector("[href^=\"/shipping\"]")).getText());
//      driver.findElement(By.cssSelector("[href*='shipping']"));
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
