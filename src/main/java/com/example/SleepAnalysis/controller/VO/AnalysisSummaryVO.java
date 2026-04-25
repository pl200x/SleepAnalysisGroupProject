package com.example.SleepAnalysis.controller.VO;


import com.example.SleepAnalysis.entity.AnalysisSummary;

public class AnalysisSummaryVO {
    private BaseVO baseVO;
    private AnalysisSummary analysisSummary;

    public AnalysisSummaryVO() {
    }

    public AnalysisSummaryVO(BaseVO baseVO, AnalysisSummary analysisSummary) {
        this.baseVO = baseVO;
        this.analysisSummary = analysisSummary;
    }

    public BaseVO getBaseVO() {
        return baseVO;
    }

    public void setBaseVO(BaseVO baseVO) {
        this.baseVO = baseVO;
    }

    public AnalysisSummary getAnalysisSummary() {
        return analysisSummary;
    }

    public void setAnalysisSummary(AnalysisSummary analysisSummary) {
        this.analysisSummary = analysisSummary;
    }
}