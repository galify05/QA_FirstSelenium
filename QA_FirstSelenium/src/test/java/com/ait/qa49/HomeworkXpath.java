package com.ait.qa49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeworkXpath {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void pathTests() {
        // 1
        driver.findElement(By.xpath("//head"));
        //2
        driver.findElement(By.xpath("//body"));
        //3
        driver.findElement(By.xpath("//html"));
        //4
        driver.findElement(By.xpath("//*[@id='bar-notification']"));
        //5
        driver.findElement(By.xpath("//*[@id='flyout-cart']"));
        //6
        driver.findElement(By.xpath("//*[@class='header-logo']"));
        //7
        driver.findElement(By.xpath("//p[contains(.,'store')]"));
        //8
        driver.findElement(By.xpath("//a[contains(.,'in')]"));
        //9
        driver.findElement(By.xpath("//*[contains(.,'Register')]"));
        //10
        WebElement element = driver.findElement(By.xpath("//h3[contains(., 'Follow')]/.."));
        System.out.println(element.getText());
        //11
        driver.findElement(By.xpath("//h2[@class='product-title']/ancestor::*"));
        //12
        WebElement element1 = driver.findElement(By.xpath("//div[@class='header-logo']/ancestor::div"));
        System.out.println(element1);
        //13
        driver.findElement(By.xpath("//div[@class='header']/following-sibling::*"));
        //14
        driver.findElement(By.xpath("//div[@class='nivo-directionNav']/preceding-sibling::*"));
        //15
        driver.findElement(By.xpath("//div[@class='nivo-directionNav']/preceding-sibling::*[4]"));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
