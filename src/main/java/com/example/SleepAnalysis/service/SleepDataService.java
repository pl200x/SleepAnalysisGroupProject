package com.example.SleepAnalysis.service;

import com.example.SleepAnalysis.entity.SleepRecord;

import java.util.List;

public interface SleepDataService {
    List<SleepRecord> getAllRecords();
    int loadData();
    boolean isDataLoaded();
    double getAverageSleepDuration();
    double getAverageSleepQuality();
    double getAverageStressLevel();
    double getAverageActivity();
}
