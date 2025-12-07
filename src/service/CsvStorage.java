package service;

import model.Cloth;
import model.ClothFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvStorage {

    private static final String HEADER = "id,name,quantity,price,color,size,extra,category";


    // Save inventory items in CSV file.
    public static boolean save(String filePath, Iterable<Cloth> items) {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            bw.write(HEADER);
            bw.newLine();
            for (Cloth item : items) {
                // Use subclass toCsv() which includes extra + category
                bw.write(item.toCsv());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Failed to write file: " + filePath);
            System.err.println("Reason: " + e.getMessage());
            return false;
        }
    }

    // Load inventory items from CSV file.
    public static List<Cloth> load(String filePath) {
        List<Cloth> list = new ArrayList<>();
        File f = new File(filePath);
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // Skip header if present
                if (firstLine) {
                    firstLine = false;
                    if (line.equalsIgnoreCase(HEADER)) continue;
                }

                // Simple CSV split (works as long as fields don’t contain commas)
                String[] cols = line.split(",", -1);

                Cloth item = ClothFactory.fromCsvRow(cols);
                if (item != null) list.add(item);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            System.err.println("Reason: " + e.getMessage());
        }
        return list;
    }
}
