package TestClass;

import BaseClass.basetest;
import PageClass.DashboardPage;
import PageClass.RegistrationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardTest extends basetest {
@BeforeMethod
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void regFuntion(){


        DashboardPage regPage= new DashboardPage(driver);

        regPage.click_regBtn();


       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/register.html"));

        */



    }

@Test
    public void validateUrltest() throws InterruptedException {

    DashboardPage dashboardPage = new DashboardPage(driver);


    dashboardPage.click_regBtn();

    String expectedUrl = "https://parabank.parasoft.com/parabank/register.html";
    String actualUrl = dashboardPage.validateUrl();

    Assert.assertNotSame(actualUrl, expectedUrl, "URL validation failed!");


//
    }

@Test
    public void validateTitle(){

    DashboardPage dashboardPage = new DashboardPage(driver);

    dashboardPage.click_regBtn(); // Ensure you're on the registration page

    String expectedTitle = "Signing up is easy!";
    String actualTitle = dashboardPage.validateTitle();

    Assert.assertEquals(actualTitle, expectedTitle, "Title validation failed!");//negative test




    }





@AfterMethod
    @Override
    public void teardown() {
        super.teardown();
    }
}
