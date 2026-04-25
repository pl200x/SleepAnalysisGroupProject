package com.example.SleepAnalysis.entity;

import java.util.List;

public class AnalysisSummary {
    private int totalRecords;
    private double averageSleepDuration;
    private double averageSleepQuality;
    private double averageStressLevel;
    private List<StressGroupResult> stressGroupResults;
    private List<ActivityGroupResult> activityGroupResults;
    private List<BMIGroupResult> bmiGroupResults;

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public double getAverageSleepDuration() {
        return averageSleepDuration;
    }

    public void setAverageSleepDuration(double averageSleepDuration) {
        this.averageSleepDuration = averageSleepDuration;
    }

    public double getAverageSleepQuality() {
        return averageSleepQuality;
    }

    public void setAverageSleepQuality(double averageSleepQuality) {
        this.averageSleepQuality = averageSleepQuality;
    }

    public double getAverageStressLevel() {
        return averageStressLevel;
    }

    public void setAverageStressLevel(double averageStressLevel) {
        this.averageStressLevel = averageStressLevel;
    }

    public List<StressGroupResult> getStressGroupResults() {
        return stressGroupResults;
    }

    public void setStressGroupResults(List<StressGroupResult> stressGroupResults) {
        this.stressGroupResults = stressGroupResults;
    }

    public List<ActivityGroupResult> getActivityGroupResults() {
        return activityGroupResults;
    }

    public void setActivityGroupResults(List<ActivityGroupResult> activityGroupResults) {
        this.activityGroupResults = activityGroupResults;
    }
    public List<BMIGroupResult> getBmiGroupResults() {
        return bmiGroupResults;
    }

    public void setBmiGroupResults(List<BMIGroupResult> bmiGroupResults) {
        this.bmiGroupResults = bmiGroupResults;
    }
}