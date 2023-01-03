package com.selenium.pagesTest;

import com.selenium.pages.PageFlights;
import com.selenium.pages.PagesLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlightsPage_Test {
    WebDriver driver;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matia\\OneDrive\\Escritorio\\Selenium Web Driver\\SeleniumWebDriver #3 PageObjects\\OneSelenium\\src\\main\\resources\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://demo.guru99.com/test/newtours/");
    }

    @Test
    public void dropDown(){
        PagesLogin login=new PagesLogin(driver);
        login.login("user2088","user2088");
        PageFlights flights=new PageFlights(driver);
        flights.selectPassengers(2);
        flights.selectFromPort(1);
        flights.selectToPort("London");


    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
