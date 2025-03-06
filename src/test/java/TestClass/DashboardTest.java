package TestClass;

import BaseClass.basetest;
import PageClass.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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



    }

@Test
    public void validateUrl(){

    driver.manage().deleteAllCookies();

    String expectedUrl="https://parabank.parasoft.com/parabank/register.html";
    Assert.assertEquals(driver.getCurrentUrl(),expectedUrl," test no 1 passed");


//
    }





@AfterMethod
    @Override
    public void teardown() {
        super.teardown();
    }
}
