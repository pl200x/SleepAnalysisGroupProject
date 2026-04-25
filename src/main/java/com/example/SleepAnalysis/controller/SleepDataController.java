package com.example.SleepAnalysis.controller;

import com.example.SleepAnalysis.controller.VO.BaseVO;
import com.example.SleepAnalysis.controller.VO.SleepDataDetailVO;
import com.example.SleepAnalysis.controller.VO.SleepDataPageVO;
import com.example.SleepAnalysis.controller.VO.SleepSummaryVO;
import com.example.SleepAnalysis.service.SleepDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sleep_data")
public class SleepDataController {

    @Autowired
    private SleepDataService sleepDataService;

    @GetMapping("/launch")
    public SleepDataPageVO getAllSleepData() {
        long start = System.currentTimeMillis();

        try {
            int count = sleepDataService.loadData();
            long end = System.currentTimeMillis();

            BaseVO baseVO = BaseVO.buildVO(200, end - start, true, null);
            return new SleepDataPageVO(baseVO, count, true);

        } catch (Exception e) {
            long end = System.currentTimeMillis();

            BaseVO baseVO = BaseVO.buildVO(500, end - start, false, e.getMessage());
            return new SleepDataPageVO(baseVO, 0, false);
        }
    }
    @GetMapping("/summary")
    public SleepSummaryVO getSummary() {
        long start = System.currentTimeMillis();

        try {
            if (!sleepDataService.isDataLoaded()) {
                sleepDataService.loadData();
            }

            long end = System.currentTimeMillis();

            BaseVO baseVO = BaseVO.buildVO(200, end - start, true, null);

            return new SleepSummaryVO(
                    baseVO,
                    sleepDataService.loadData(),
                    sleepDataService.getAverageSleepDuration(),
                    sleepDataService.getAverageSleepQuality(),
                    sleepDataService.getAverageStressLevel()
            );

        } catch (Exception e) {
            long end = System.currentTimeMillis();
            BaseVO baseVO = BaseVO.buildVO(500, end - start, false, e.getMessage());

            return new SleepSummaryVO(baseVO, 0, 0.0, 0.0, 0.0);
        }
    }
}