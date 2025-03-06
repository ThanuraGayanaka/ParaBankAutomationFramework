package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    // Constructor
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    // Method to enter first name
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    // Method to enter last name
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    // Method to enter address
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // Method to enter city
    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    // Method to enter state
    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    // Method to enter zip code
    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    // Method to enter phone number
    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // Method to enter SSN
    public void enterSSN(String ssn) {
        driver.findElement(ssnField).sendKeys(ssn);
    }

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to confirm password
    public void confirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    // Method to click the register button
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // Method to fill the entire registration form
    public void fillRegistrationForm(String firstName, String lastName, String address, String city,
                                     String state, String zipCode, String phone, String ssn,
                                     String username, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        enterZipCode(zipCode);
        enterPhone(phone);
        enterSSN(ssn);
        enterUsername(username);
        enterPassword(password);
        confirmPassword(password);
    }
}
