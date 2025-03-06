package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {


WebDriver driver;


    public DashboardPage(WebDriver driver){

this.driver= driver;
    }

    By registerBtn= By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");





    public void click_regBtn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registerBtn))).click();


        };

    }






