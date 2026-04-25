package com.example.SleepAnalysis.service.impl;

import com.example.SleepAnalysis.entity.SleepRecord;
import com.example.SleepAnalysis.service.SleepDataService;
import com.example.SleepAnalysis.util.CsvDataLoader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SleepDataServiceImpl implements SleepDataService{

    private List<SleepRecord> records = new ArrayList<>();

    @Override
    public int loadData() {
        records = CsvDataLoader.loadData("data/SleepHealthDataset.csv");
        return records.size();
    }

    @Override
    public List<SleepRecord> getAllRecords() {
        return CsvDataLoader.loadData("data/SleepHealthDataset.csv");
    }

    @Override
    public boolean isDataLoaded() {
        return records != null && !records.isEmpty();
    }

    @Override
    public double getAverageSleepDuration() {
        return records.stream()
                .mapToDouble(SleepRecord::getSleepDuration)
                .average()
                .orElse(0.0);
    }
    @Override
    public double getAverageSleepQuality() {
        return records.stream()
                .mapToInt(SleepRecord::getQualityOfSleep)
                .average()
                .orElse(0.0);
    }
    @Override
    public double getAverageStressLevel() {
        return records.stream()
                .mapToInt(SleepRecord::getStressLevel)
                .average()
                .orElse(0.0);
    }

    @Override
    public double getAverageActivity() {
        return records.stream()
                .mapToInt(SleepRecord::getPhysicalActivityLevel)
                .average()
                .orElse(0.0);
    }


}
