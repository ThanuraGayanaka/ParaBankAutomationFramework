package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    /**
     * This method reads data from an Excel file and returns it as a 2D Object array.
     *
     * @param filePath  The path to the Excel file.
     * @param sheetName The name of the sheet to read from.
     * @return A 2D Object array containing the data from the sheet.
     */
    public static Object[][] getTestData(String filePath, String sheetName) {
        // Initialize the result data array
        Object[][] data = null;

        try {
            // Load the Excel file
            File file = new File(filePath); // Use the provided file path
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);

            // Access the sheet
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells(); // Assuming first row contains headers

            // Initialize the data array
            data = new Object[rowCount - 1][columnCount]; // Skip header row

            // Iterate through each row
            for (int i = 1; i < rowCount; i++) {  // Start from 1 to skip header
                Row row = sheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    // Handle different cell types (e.g., String, Numeric, etc.)
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                data[i - 1][j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                                break;
                            default:
                                data[i - 1][j] = "";
                        }
                    } else {
                        data[i - 1][j] = ""; // Handle empty cells
                    }
                }
            }

            // Close resources
            workbook.close();
            fis.close();

        } catch (IOException e) {
            System.err.println("IOException occurred while reading the Excel file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }
}
