package com.example.SleepAnalysis.util;

import com.example.SleepAnalysis.entity.SleepRecord;
import com.example.SleepAnalysis.exception.DataFileNotExistException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvDataLoader {
    public static List<SleepRecord> loadData(String filePath) {
        List<SleepRecord> records = new ArrayList<>();

        InputStream inputStream = CsvDataLoader.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new DataFileNotExistException("CSV file not found: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length < 13) continue;

                SleepRecord record = new SleepRecord(
                        Integer.parseInt(values[0].trim()),
                        values[1].trim(),
                        Integer.parseInt(values[2].trim()),
                        values[3].trim(),
                        Double.parseDouble(values[4].trim()),
                        Integer.parseInt(values[5].trim()),
                        Integer.parseInt(values[6].trim()),
                        Integer.parseInt(values[7].trim()),
                        values[8].trim(),
                        values[9].trim(),
                        Integer.parseInt(values[10].trim()),
                        Integer.parseInt(values[11].trim()),
                        values[12].trim()
                );

                records.add(record);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load CSV data: " + e.getMessage(), e);
        }

        return records;
    }
}
