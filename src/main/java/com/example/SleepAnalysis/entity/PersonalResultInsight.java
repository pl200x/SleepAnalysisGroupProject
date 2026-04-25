package com.example.SleepAnalysis.entity;

import java.util.List;

public class PersonalResultInsight {
    private double estimatedSleepQuality;
    private String sleepQualityCategory;
    private int similarUserCount;
    private List<String> riskFactors;
    private List<String> recommendations;

    public PersonalResultInsight() {
    }

    public PersonalResultInsight(double estimatedSleepQuality,
                                 String sleepQualityCategory,
                                 int similarUserCount,
                                 List<String> riskFactors,
                                 List<String> recommendations) {
        this.estimatedSleepQuality = estimatedSleepQuality;
        this.sleepQualityCategory = sleepQualityCategory;
        this.similarUserCount = similarUserCount;
        this.riskFactors = riskFactors;
        this.recommendations = recommendations;
    }

    public double getEstimatedSleepQuality() {
        return estimatedSleepQuality;
    }

    public void setEstimatedSleepQuality(double estimatedSleepQuality) {
        this.estimatedSleepQuality = estimatedSleepQuality;
    }

    public String getSleepQualityCategory() {
        return sleepQualityCategory;
    }

    public void setSleepQualityCategory(String sleepQualityCategory) {
        this.sleepQualityCategory = sleepQualityCategory;
    }

    public int getSimilarUserCount() {
        return similarUserCount;
    }

    public void setSimilarUserCount(int similarUserCount) {
        this.similarUserCount = similarUserCount;
    }

    public List<String> getRiskFactors() {
        return riskFactors;
    }

    public void setRiskFactors(List<String> riskFactors) {
        this.riskFactors = riskFactors;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
        return "PersonalResultInsight{" +
                "estimatedSleepQuality=" + estimatedSleepQuality +
                ", sleepQualityCategory='" + sleepQualityCategory + '\'' +
                ", similarUserCount=" + similarUserCount +
                ", riskFactors=" + riskFactors +
                ", recommendations=" + recommendations +
                '}';
    }
}