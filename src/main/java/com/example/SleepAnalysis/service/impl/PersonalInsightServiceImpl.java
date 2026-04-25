package com.example.SleepAnalysis.service.impl;

import com.example.SleepAnalysis.controller.cmd.UserInputCMD;
import com.example.SleepAnalysis.entity.PersonalResultInsight;
import com.example.SleepAnalysis.entity.SleepRecord;
import com.example.SleepAnalysis.service.PersonalInsightService;
import com.example.SleepAnalysis.service.SleepDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalInsightServiceImpl implements PersonalInsightService {

    @Autowired
    private SleepDataService sleepDataService;

    @Override
    public PersonalResultInsight analyzeUserInput(UserInputCMD userInputCMD) {
        if (!sleepDataService.isDataLoaded()) {
            sleepDataService.loadData();
        }

        List<SleepRecord> records = sleepDataService.getAllRecords();

        List<SleepRecord> similarRecords = records.stream()
                .filter(record -> Math.abs(record.getAge() - userInputCMD.getAge()) <= 5)
                .filter(record -> record.getBmiCategory().equalsIgnoreCase(userInputCMD.getBmiCategory()))
                .filter(record -> Math.abs(record.getStressLevel() - userInputCMD.getStressLevel()) <= 1)
                .collect(Collectors.toList());

        double estimatedSleepQuality;

        if (!similarRecords.isEmpty()) {
            estimatedSleepQuality = similarRecords.stream()
                    .mapToInt(SleepRecord::getQualityOfSleep)
                    .average()
                    .orElse(0.0);
        } else {
            estimatedSleepQuality = records.stream()
                    .mapToInt(SleepRecord::getQualityOfSleep)
                    .average()
                    .orElse(0.0);
        }

        String category = getSleepQualityCategory(estimatedSleepQuality);

        List<String> riskFactors = buildRiskFactors(userInputCMD, records);
        List<String> recommendations = buildRecommendations(userInputCMD);

        return new PersonalResultInsight(
                estimatedSleepQuality,
                category,
                similarRecords.size(),
                riskFactors,
                recommendations
        );
    }

    private String getSleepQualityCategory(double score) {
        if (score >= 8) {
            return "High";
        } else if (score >= 6) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    private List<String> buildRiskFactors(UserInputCMD userInputCMD, List<SleepRecord> records) {
        List<String> riskFactors = new ArrayList<>();

        double avgStress = sleepDataService.getAverageStressLevel();

        double avgActivity = sleepDataService.getAverageActivity();

        double avgSleepDuration = sleepDataService.getAverageSleepDuration();

        if (userInputCMD.getStressLevel() > avgStress) {
            riskFactors.add("Your stress level is higher than the dataset average.");
        }

        if (userInputCMD.getPhysicalActivityLevel() < avgActivity) {
            riskFactors.add("Your physical activity level is lower than the dataset average.");
        }

        if (userInputCMD.getSleepDuration() < avgSleepDuration) {
            riskFactors.add("Your sleep duration is lower than the dataset average.");
        }

        if (userInputCMD.getHeartRate() >= 80) {
            riskFactors.add("Your heart rate is relatively high compared with a typical resting range.");
        }

        if ("Overweight".equalsIgnoreCase(userInputCMD.getBmiCategory())
                || "Obese".equalsIgnoreCase(userInputCMD.getBmiCategory())) {
            riskFactors.add("Your BMI category may be associated with higher sleep disorder risk.");
        }

        return riskFactors;
    }

    private List<String> buildRecommendations(UserInputCMD userInputCMD) {
        List<String> recommendations = new ArrayList<>();

        if (userInputCMD.getStressLevel() >= 7) {
            recommendations.add("Consider stress reduction routines such as relaxation, meditation, or lighter evening schedules.");
        }

        if (userInputCMD.getPhysicalActivityLevel() < 50) {
            recommendations.add("Increasing daily physical activity may be associated with better sleep quality.");
        }

        if (userInputCMD.getSleepDuration() < 7) {
            recommendations.add("Try to move closer to 7 to 8 hours of sleep if your schedule allows.");
        }

        if (userInputCMD.getDailySteps() < 6000) {
            recommendations.add("Increasing daily steps may help improve overall lifestyle balance.");
        }

        if (recommendations.isEmpty()) {
            recommendations.add("Your input does not show obvious lifestyle risk factors based on this dataset.");
        }

        return recommendations;
    }
}