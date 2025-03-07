package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReaderUtil {

    /**
     * Reads data from a CSV file and returns it as a 2D Object array.
     *
     * @param filePath The path to the CSV file.
     * @return A 2D Object array containing the data from the CSV file.
     */
    public static Object[][] getTestData(String filePath) {
        Object[][] data = null;

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> csvData = csvReader.readAll();

            int rowCount = csvData.size();
            int columnCount = csvData.get(0).length;

            data = new Object[rowCount - 1][columnCount];

            // Populate the data array, skipping the header row
            for (int i = 1; i < rowCount; i++) {
                data[i - 1] = csvData.get(i);
            }

            System.out.println("Loaded Test Data: " + (rowCount - 1) + " rows, " + columnCount + " columns.");

        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        return data;
    }
}
