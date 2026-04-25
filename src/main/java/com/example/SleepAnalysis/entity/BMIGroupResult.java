package com.example.SleepAnalysis.entity;

public class BMIGroupResult {
    private String bmiCategory;
    private int count;
    private double averageSleepQuality;
    private double sleepDisorderRate;

    public BMIGroupResult() {
    }

    public BMIGroupResult(String bmiCategory, int count,
                          double averageSleepQuality,
                          double sleepDisorderRate) {
        this.bmiCategory = bmiCategory;
        this.count = count;
        this.averageSleepQuality = averageSleepQuality;
        this.sleepDisorderRate = sleepDisorderRate;
    }

    public String getBmiCategory() {
        return bmiCategory;
    }

    public void setBmiCategory(String bmiCategory) {
        this.bmiCategory = bmiCategory;
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

    public double getSleepDisorderRate() {
        return sleepDisorderRate;
    }

    public void setSleepDisorderRate(double sleepDisorderRate) {
        this.sleepDisorderRate = sleepDisorderRate;
    }
}