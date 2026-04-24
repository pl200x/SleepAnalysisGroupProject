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
        records = CsvDataLoader.loadData("data/sleep_health.csv");
        return records.size();
    }

    @Override
    public List<SleepRecord> getAllRecords() {
        return CsvDataLoader.loadData("data/sleep_health.csv");
    }

    @Override
    public boolean isDataLoaded() {
        return records != null && !records.isEmpty();
    }


}
