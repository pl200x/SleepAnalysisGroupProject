package com.example.SleepAnalysis.entity;

public class StressGroupResult {
    private int stressLevel;
    private int count;
    private double averageSleepQuality;
    private double averageSleepDuration;

    public StressGroupResult() {
    }

    public StressGroupResult(int stressLevel, int count,
                             double averageSleepQuality,
                             double averageSleepDuration) {
        this.stressLevel = stressLevel;
        this.count = count;
        this.averageSleepQuality = averageSleepQuality;
        this.averageSleepDuration = averageSleepDuration;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAverageSleepQuality() {
        return averageSleepQuality;
    }

    public void setAverageSleepQuality(double averageSleepQuality) {
        this.averageSleepQuality = averageSleepQuality;
    }

    public double getAverageSleepDuration() {
        return averageSleepDuration;
    }

    public void setAverageSleepDuration(double averageSleepDuration) {
        this.averageSleepDuration = averageSleepDuration;
    }
}