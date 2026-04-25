package com.example.SleepAnalysis.entity;

public class ActivityGroupResult {
    private String activityGroup;
    private int count;
    private double averageSleepQuality;
    private double averageSleepDuration;

    public ActivityGroupResult() {
    }

    public ActivityGroupResult(String activityGroup, int count,
                               double averageSleepQuality,
                               double averageSleepDuration) {
        this.activityGroup = activityGroup;
        this.count = count;
        this.averageSleepQuality = averageSleepQuality;
        this.averageSleepDuration = averageSleepDuration;
    }

    public String getActivityGroup() {
        return activityGroup;
    }

    public void setActivityGroup(String activityGroup) {
        this.activityGroup = activityGroup;
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