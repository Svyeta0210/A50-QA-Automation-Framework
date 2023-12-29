package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16_Registration extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Test
    public void registrationNavigationTest() {
        loginPage = new LoginPage(getDriver());
        registrationPage = new RegistrationPage(getDriver());

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//div[2]//a")));
        registrationPage.clickLoginFormRegistrationElement()
                        .registrationPageEmailField().isDisplayed();
        Assert.assertTrue(registrationPage.getRegisterNewAccountElement().isDisplayed());
        }
    }


