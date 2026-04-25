package com.example.SleepAnalysis.controller;

import com.example.SleepAnalysis.controller.VO.AnalysisSummaryVO;
import com.example.SleepAnalysis.controller.VO.BaseVO;
import com.example.SleepAnalysis.entity.AnalysisSummary;
import com.example.SleepAnalysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/summary")
    public AnalysisSummaryVO getAnalysisSummary() {
        long start = System.currentTimeMillis();

        try {
            AnalysisSummary analysisSummary = analysisService.generateAnalysisSummary();

            long end = System.currentTimeMillis();
            BaseVO baseVO = BaseVO.buildVO(200, end - start, true, null);

            return new AnalysisSummaryVO(baseVO, analysisSummary);

        } catch (Exception e) {
            long end = System.currentTimeMillis();
            BaseVO baseVO = BaseVO.buildVO(500, end - start, false, e.getMessage());

            return new AnalysisSummaryVO(baseVO, null);
        }
    }
}