package com.selenium.pages;

import com.selenium.helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.swing.*;

import static org.testng.AssertJUnit.assertTrue;

public class PagesLogin {
    private WebDriver driver;
    private By userField;
    private By  passwordField;
    private By submitButton;
    private By titleTextSucces;
    private By flightText;

    public PagesLogin(WebDriver driver) {
        this.driver = driver;
        userField=By.name("userName");
        passwordField=By.name("password");
        submitButton=By.name("submit");
        flightText=By.linkText("Flights");
        titleTextSucces=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b");
    }
    public void login(String userName, String password){

        driver.findElement(userField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        Helper helper=new Helper();
        helper.sleepSeconds(4);
        Assert.assertTrue(driver.findElement(titleTextSucces).getText().contains("Thank you for Loggin."));
        driver.findElement(flightText).click();
        helper.sleepSeconds(10);
    }

}
