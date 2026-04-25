package com.example.SleepAnalysis.controller.VO;

import java.util.List;

public class StressAnalysisVO {
    private BaseVO baseVO;
    private List<StressGroupVO> stressGroups;

    public StressAnalysisVO() {
    }

    public StressAnalysisVO(BaseVO baseVO, List<StressGroupVO> stressGroups) {
        this.baseVO = baseVO;
        this.stressGroups = stressGroups;
    }

    public BaseVO getBaseVO() {
        return baseVO;
    }

    public void setBaseVO(BaseVO baseVO) {
        this.baseVO = baseVO;
    }

    public List<StressGroupVO> getStressGroups() {
        return stressGroups;
    }

    public void setStressGroups(List<StressGroupVO> stressGroups) {
        this.stressGroups = stressGroups;
    }

    public static class StressGroupVO {
        private int stressLevel;
        private int count;
        private double averageSleepQuality;
        private double averageSleepDuration;

        public StressGroupVO() {
        }

        public StressGroupVO(int stressLevel, int count, double averageSleepQuality, double averageSleepDuration) {
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
}