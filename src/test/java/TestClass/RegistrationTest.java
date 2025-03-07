package TestClass;

import BaseClass.basetest;
import PageClass.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CSVReaderUtil;

import java.io.File;

public class RegistrationTest extends basetest {

    private RegistrationPage registrationPage;

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        registrationPage = new RegistrationPage(driver);
    }

    @AfterMethod
    @Override
    public void teardown() {
        super.teardown();
    }

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        String csvFilePath = new File("src/main/resources/registrationData.csv").getAbsolutePath();
        Object[][] testData = CSVReaderUtil.getTestData(csvFilePath);

        if (testData == null || testData.length == 0) {
            System.err.println("Test data not loaded properly. Check the CSV file path and content.");
        } else {
            System.out.println("Loaded Test Data: " + testData.length + " rows.");
        }

        return testData;
    }

    @Test(dataProvider = "registrationData")
    public void testRegistration(String firstName, String lastName, String address, String city,
                                 String state, String zipCode, String phone, String ssn,
                                 String username, String password) {

        registrationPage.fillRegistrationForm(firstName, lastName, address, city, state, zipCode,
                phone, ssn, username, password);

        registrationPage.clickRegisterButton();

        String successMessage = registrationPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("successfully registered"), "Registration failed!");
    }
}
