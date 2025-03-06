package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class basetest {
 protected    WebDriver driver;




    public void setup(){



        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");



    }



    public void teardown(){

       driver.close();



    }



}
