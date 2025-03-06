

package utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

    public class CommonUtils implements ITestListener {

        public static WebDriver driver;
        private static Properties properties = new Properties();

        // ============================
        // 1. WebDriver Management
        // ============================
        public static WebDriver getDriver() {
            if (driver == null) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
            return driver;
        }

        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }

        // ============================
        // 2. Explicit Waits
        // ============================
        public static void waitForElementToBeVisible(WebElement element, int timeout) {
            new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOf(element));
        }

        public static void waitForElementToBeClickable(WebElement element, int timeout) {
            new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.elementToBeClickable(element));
        }

        // ============================
        // 3. Screenshot Utility
        // ============================
        public static String takeScreenshot(String screenshotName) {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
            try {
                FileUtils.copyFile(source, new File(destination));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return destination;
        }

        // ============================
        // 4. Excel Data Reader
        // ============================
        public static Object[][] getTestData(String filePath, String sheetName) {
            Object[][] data = null;
            try (FileInputStream file = new FileInputStream(filePath);
                 XSSFWorkbook workbook = new XSSFWorkbook(file)) {

                XSSFSheet sheet = workbook.getSheet(sheetName);
                int rowCount = sheet.getPhysicalNumberOfRows();
                int colCount = sheet.getRow(0).getLastCellNum();

                data = new Object[rowCount - 1][colCount];
                DataFormatter formatter = new DataFormatter();

                for (int i = 1; i < rowCount; i++) {
                    Row row = sheet.getRow(i);
                    for (int j = 0; j < colCount; j++) {
                        data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        // ============================
        // 5. Configuration Reader
        // ============================
        static {
            try (FileInputStream file = new FileInputStream("src/main/resources/config.properties")) {
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getProperty(String key) {
            return properties.getProperty(key);
        }

        // ============================
        // 6. TestNG Listener Methods
        // ============================
        @Override
        public void onTestFailure(ITestResult result) {
            String screenshotPath = takeScreenshot(result.getName());
            System.out.println("Screenshot captured for failed test: " + screenshotPath);
        }

        @Override
        public void onStart(ITestContext context) {
            context.setAttribute("driver", driver);
        }

        @Override
        public void onFinish(ITestContext context) {
            quitDriver();
        }
    }


