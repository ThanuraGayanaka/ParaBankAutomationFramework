package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {


WebDriver driver;


    public DashboardPage(WebDriver driver){

this.driver= driver;
    }

    By registerBtn= By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    By titleBtn= By.xpath("//h1[@class='title']");





    public void click_regBtn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registerBtn))).click();
        String url =driver.getCurrentUrl();
        }


    public String validateTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Wait until the element is visible and then get its text
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleBtn)).getText();

    }


    public String validateUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String expectedUrl = "https://parabank.parasoft.com/parabank/register.html";

        // Wait until the exact URL is loaded
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        return driver.getCurrentUrl();
    }


}






