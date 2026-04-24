package com.example.SleepAnalysis.entity;


public class SleepRecord {
    private int personId;
    private String gender;
    private int age;
    private String occupation;
    private double sleepDuration;
    private int qualityOfSleep;
    private int physicalActivityLevel;
    private int stressLevel;
    private String bmiCategory;
    private String bloodPressure;
    private int heartRate;
    private int dailySteps;
    private String sleepDisorder;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(double sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public int getQualityOfSleep() {
        return qualityOfSleep;
    }

    public void setQualityOfSleep(int qualityOfSleep) {
        this.qualityOfSleep = qualityOfSleep;
    }

    public int getPhysicalActivityLevel() {
        return physicalActivityLevel;
    }

    public void setPhysicalActivityLevel(int physicalActivityLevel) {
        this.physicalActivityLevel = physicalActivityLevel;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    public String getBmiCategory() {
        return bmiCategory;
    }

    public void setBmiCategory(String bmiCategory) {
        this.bmiCategory = bmiCategory;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getDailySteps() {
        return dailySteps;
    }

    public void setDailySteps(int dailySteps) {
        this.dailySteps = dailySteps;
    }

    public String getSleepDisorder() {
        return sleepDisorder;
    }

    public void setSleepDisorder(String sleepDisorder) {
        this.sleepDisorder = sleepDisorder;
    }

    public SleepRecord(int personId, String gender, int age) {
        this.personId = personId;
        this.gender = gender;
        this.age = age;
    }

    public SleepRecord(int personId, String gender, int age, String occupation, double sleepDuration,
                       int qualityOfSleep, int physicalActivityLevel, int stressLevel, String bmiCategory,
                       String bloodPressure, int heartRate, int dailySteps, String sleepDisorder) {
        this.personId = personId;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.sleepDuration = sleepDuration;
        this.qualityOfSleep = qualityOfSleep;
        this.physicalActivityLevel = physicalActivityLevel;
        this.stressLevel = stressLevel;
        this.bmiCategory = bmiCategory;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.dailySteps = dailySteps;
        this.sleepDisorder = sleepDisorder;
    }

    public SleepRecord() {
    }
}