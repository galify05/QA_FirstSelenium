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
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());// no text

        //find list of elements by tag name
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementBySimpleLocators() {
        // by id
        driver.findElement(By.id("city"));
        //by className
        driver.findElement(By.className("header"));
        //by linkText
        driver.findElement(By.linkText("Let the car work"));
        //by partialLinkText
        driver.findElement(By.partialLinkText("car"));
    }

    @Test
    public void findElementByCssSelectorTest() {
        //tagName == css
        //  driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));
        //id -> css(#)
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));
        //className -> css(.)
        // driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));
        // [attr = 'value']
        driver.findElement(By.cssSelector("[href='/login?url=%2Fsearch']"));
        //contains -> *
        driver.findElement(By.cssSelector("[href*='login']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/log']"));
        //end on-> $
        driver.findElement(By.cssSelector("[href$='search']"));

//tag+id
        driver.findElement(By.cssSelector("input#city"));
        // tag + class
        driver.findElement(By.cssSelector("div.search-card"));

        //tag+id+[attr='value']
        driver.findElement(By.cssSelector("input#city[type='text']"));
    }

    // //*[@attr='value']
    @Test
    public void findElementByXpath() {
        //tag > //tag
        driver.findElement(By.xpath("//h1"));

        //id > xpath - //*[@id='value']
        driver.findElement(By.xpath("//input[@id='city']"));

        // classname "header"
        driver.findElement(By.xpath("//div[@class='header']"));
        // contains = //*[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));

        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));
    driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));

        driver.findElement(By.xpath("//a[@class='navigation-link']/..")); // выйти на уровень назад
        driver.findElement(By.xpath("//h1/parent::*")); // найти элемент родителя (блок div)
//        driver.findElement(By.xpath("//h1/..")); // найти элемент родителя (блок div) тоже самое что выше
        driver.findElement(By.xpath("//h1/ancestor::*")); // все элементиы
        driver.findElement(By.xpath("//h1/ancestor::div")); // тут только 2 варианта
        driver.findElement(By.xpath("//h1/ancestor::div[2]")); // выбрали 1 вариант из двух

        driver.findElement(By.xpath("//h1/following-sibling::form"));
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));

    }
}


