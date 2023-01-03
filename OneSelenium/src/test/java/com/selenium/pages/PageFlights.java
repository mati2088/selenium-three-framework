package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageFlights {
    private WebDriver driver;
    private By passengersDrop;
    private By flightTextPresent;
    private By fromDro;

    private By toDrop;
    public PageFlights(WebDriver driver) {
        this.driver = driver;
        flightTextPresent=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");
        passengersDrop=By.name("passCount");
        fromDro=By.name("fromPort");
        toDrop=By.name("toPort");
    }

    public void assertPage(){
        Assert.assertTrue(driver.findElement(flightTextPresent).isDisplayed());
    }
    public void selectPassengers(int cant){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cantidadPasajeros=wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
        Select selectpasajeros=new Select(cantidadPasajeros);
        selectpasajeros.selectByVisibleText(Integer.toString(cant));

    }

    public void selectFromPort(int index){
        Select selectFrom=new Select(driver.findElement(fromDro));
        selectFrom.selectByIndex(index);
    }
    public void selectToPort(String city){
        Select selectTo=new Select(driver.findElement(toDrop));
        selectTo.selectByValue(city);
    }
}
