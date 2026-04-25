package com.example.SleepAnalysis.service.impl;

import com.example.SleepAnalysis.entity.AnalysisSummary;
import com.example.SleepAnalysis.entity.SleepRecord;
import com.example.SleepAnalysis.service.AnalysisService;
import com.example.SleepAnalysis.service.SleepDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SleepAnalysis.entity.StressGroupResult;
import com.example.SleepAnalysis.entity.ActivityGroupResult;
import com.example.SleepAnalysis.entity.BMIGroupResult;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private SleepDataService sleepDataService;

    @Override
    public AnalysisSummary generateAnalysisSummary() {
        if (!sleepDataService.isDataLoaded()) {
            sleepDataService.loadData();
        }

        List<SleepRecord> records = sleepDataService.getAllRecords();

        AnalysisSummary summary = new AnalysisSummary();

        summary.setTotalRecords(records.size());
        summary.setAverageSleepDuration(sleepDataService.getAverageSleepDuration());
        summary.setAverageSleepQuality(sleepDataService.getAverageSleepQuality());
        summary.setAverageStressLevel(sleepDataService.getAverageStressLevel());
        //Stress results
        Map<Integer, List<SleepRecord>> stressMap = records.stream()
                .collect(Collectors.groupingBy(SleepRecord::getStressLevel));
        List<StressGroupResult> stressResults = getStressResultAnalysis(stressMap);
        summary.setStressGroupResults(stressResults);

        //Activity results
        Map<String, List<SleepRecord>> activityMap = records.stream()
                .collect(Collectors.groupingBy(
                        record -> getActivityGroup(record.getPhysicalActivityLevel())));
        List<ActivityGroupResult> activityResults = getActivityGroupResultAnalysis(activityMap);
        summary.setActivityGroupResults(activityResults);

        //BMI results
        Map<String, List<SleepRecord>> bmiMap = records.stream()
                .collect(Collectors.groupingBy(SleepRecord::getBmiCategory));

        List<BMIGroupResult> bmiResults = getBMIGroupResultAnalysis(bmiMap);

        summary.setBmiGroupResults(bmiResults);
        return summary;
    }
    public List<StressGroupResult> getStressResultAnalysis(Map<Integer, List<SleepRecord>> stressMap){
        return stressMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    int stressLevel = entry.getKey();
                    List<SleepRecord> group = entry.getValue();

                    double avgQuality = group.stream()
                            .mapToInt(SleepRecord::getQualityOfSleep)
                            .average()
                            .orElse(0.0);

                    double avgDuration = group.stream()
                            .mapToDouble(SleepRecord::getSleepDuration)
                            .average()
                            .orElse(0.0);

                    return new StressGroupResult(
                            stressLevel,
                            group.size(),
                            avgQuality,
                            avgDuration
                    );
                })
                .collect(Collectors.toList());
    }
    public List<ActivityGroupResult> getActivityGroupResultAnalysis(Map<String, List<SleepRecord>> activityMap){
        return activityMap.entrySet().stream()
                .sorted((e1, e2) -> getActivityGroupOrder(e1.getKey()) - getActivityGroupOrder(e2.getKey()))
                .map(entry -> {
                    String activityGroup = entry.getKey();
                    List<SleepRecord> group = entry.getValue();

                    double avgQuality = group.stream()
                            .mapToInt(SleepRecord::getQualityOfSleep)
                            .average()
                            .orElse(0.0);

                    double avgDuration = group.stream()
                            .mapToDouble(SleepRecord::getSleepDuration)
                            .average()
                            .orElse(0.0);

                    return new ActivityGroupResult(
                            activityGroup,
                            group.size(),
                            avgQuality,
                            avgDuration
                    );
                })
                .collect(Collectors.toList());
    }
    public List<BMIGroupResult> getBMIGroupResultAnalysis(Map<String, List<SleepRecord>> bmiMap){
        return bmiMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    String bmiCategory = entry.getKey();
                    List<SleepRecord> group = entry.getValue();

                    double avgQuality = group.stream()
                            .mapToInt(SleepRecord::getQualityOfSleep)
                            .average()
                            .orElse(0.0);

                    long disorderCount = group.stream()
                            .filter(record -> record.getSleepDisorder() != null)
                            .filter(record -> !record.getSleepDisorder().equalsIgnoreCase("None"))
                            .count();

                    double disorderRate = group.isEmpty()
                            ? 0.0
                            : (double) disorderCount / group.size();

                    return new BMIGroupResult(
                            bmiCategory,
                            group.size(),
                            avgQuality,
                            disorderRate
                    );
                })
                .collect(Collectors.toList());
    }

    private String getActivityGroup(int physicalActivityLevel) {
        if (physicalActivityLevel < 40) {
            return "Low Activity";
        } else if (physicalActivityLevel <= 60) {
            return "Medium Activity";
        } else {
            return "High Activity";
        }
    }

    private int getActivityGroupOrder(String activityGroup) {
        switch (activityGroup) {
            case "Low Activity":
                return 1;
            case "Medium Activity":
                return 2;
            case "High Activity":
                return 3;
            default:
                return 99;
        }
    }
}