package TestClass;


import BaseClass.basetest;
import PageClass.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelReader;

public class RegistrationTest extends basetest {

    private RegistrationPage registrationPage;

    // DataProvider to fetch test data from Excel file
    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        // Load test data from Excel
        return ExcelReader.getTestData("src/main/resources/signupData.xlsx", "Sheet1");
    }

    // Test method that takes data from Excel
    @Test(dataProvider = "registrationData")
    public void testRegistration(String firstName, String lastName, String address, String city,
                                 String state, String zipCode, String phone, String ssn,
                                 String username, String password) {
        // Initialize the RegistrationPage object
        registrationPage = new RegistrationPage(driver);

        // Fill the registration form using the provided data
        registrationPage.fillRegistrationForm(firstName, lastName, address, city, state, zipCode,
                phone, ssn, username, password);

        // Click on the Register button
        registrationPage.clickRegisterButton();

        // Add assertions to verify if the registration was successful
        // Example: Check if the URL after registration contains "success" or verify a success message
        String successMessage = driver.getCurrentUrl();
        Assert.assertTrue(successMessage.contains("success"), "Registration failed!");
    }
}
