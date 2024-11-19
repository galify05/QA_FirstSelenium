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

/*
WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
 */

public class TableTests {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void findElementInTable(){
        List<WebElement> trElements = driver.findElements(By.cssSelector("tr"));
        System.out.println(trElements.size());

        for (WebElement el: trElements){
            System.out.println(el.getText());
            System.out.println("*********");
        }

        WebElement element = driver.findElement(By.cssSelector("tr:nth-child(4)"));
            System.out.println(element.getText());

        WebElement trKoeng = driver.findElement(By.cssSelector("tr:nth-child(7) td:nth-child(1)"));
            System.out.println(trKoeng.getText());

        WebElement trKanad = driver.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        System.out.println(trKanad.getText());
    }
}
