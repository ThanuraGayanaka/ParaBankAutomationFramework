package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    // Locators for the registration fields
    private By firstNameField = By.xpath("//input[@id='customer.firstName']");
    private By lastNameField = By.xpath("//input[@id='customer.lastName']");
    private By addressField = By.xpath("//input[@id='customer.address.street']");
    private By cityField = By.xpath("//input[@id='customer.address.city']");
    private By stateField = By.xpath("//input[@id='customer.address.state']");
    private By zipCodeField = By.xpath("//input[@id='customer.address.zipCode']");
    private By phoneField = By.xpath("//input[@id='customer.phoneNumber']");
    private By ssnField = By.xpath("//input[@id='customer.ssn']");
    private By usernameField = By.xpath("//input[@id='customer.username']");
    private By passwordField = By.xpath("//input[@id='customer.password']");
    private By confirmPasswordField = By.xpath("//input[@id='repeatedPassword']");

    // Locator for the submit button
    private By registerButton = By.xpath("//input[@value='Register']");

    // Locator for the success message (Adjust according to your app's success message element)
    private By successMessage = By.xpath("//h1[contains(text(),'Registration Successful')]");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to fill the registration form
    public void fillRegistrationForm(String firstName, String lastName, String address, String city,
                                     String state, String zipCode, String phone, String ssn,
                                     String username, String password) {

        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(ssnField).sendKeys(ssn);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    // Method to click the register button
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // Method to get success message text
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
