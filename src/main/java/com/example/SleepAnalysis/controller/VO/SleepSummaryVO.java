package com.example.SleepAnalysis.controller.VO;

public class SleepSummaryVO {
    private BaseVO baseVO;
    private int totalRecords;
    private double averageSleepDuration;
    private double averageSleepQuality;
    private double averageStressLevel;

    public SleepSummaryVO() {
    }

    public SleepSummaryVO(BaseVO baseVO, int totalRecords,
                          double averageSleepDuration,
                          double averageSleepQuality,
                          double averageStressLevel) {
        this.baseVO = baseVO;
        this.totalRecords = totalRecords;
        this.averageSleepDuration = averageSleepDuration;
        this.averageSleepQuality = averageSleepQuality;
        this.averageStressLevel = averageStressLevel;
    }

    public BaseVO getBaseVO() {
        return baseVO;
    }

    public void setBaseVO(BaseVO baseVO) {
        this.baseVO = baseVO;
    }

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
}