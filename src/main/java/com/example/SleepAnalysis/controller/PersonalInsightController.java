package com.example.SleepAnalysis.controller;

import com.example.SleepAnalysis.controller.cmd.UserInputCMD;
import com.example.SleepAnalysis.controller.VO.BaseVO;
import com.example.SleepAnalysis.controller.VO.PersonalResultInsightVO;
import com.example.SleepAnalysis.entity.PersonalResultInsight;
import com.example.SleepAnalysis.service.EmailService;
import com.example.SleepAnalysis.service.PersonalInsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal")
public class PersonalInsightController {

    @Autowired
    private PersonalInsightService personalInsightService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/analyze")
    public PersonalResultInsightVO analyzeUserInput(@RequestBody UserInputCMD userInputCMD) {
        long start = System.currentTimeMillis();

        try {
            PersonalResultInsight result = personalInsightService.analyzeUserInput(userInputCMD);

            long end = System.currentTimeMillis();
            BaseVO baseVO = BaseVO.buildVO(200, end - start, true, null);

            return new PersonalResultInsightVO(baseVO, result);

        } catch (Exception e) {
            long end = System.currentTimeMillis();
            BaseVO baseVO = BaseVO.buildVO(500, end - start, false, e.getMessage());

            return new PersonalResultInsightVO(baseVO, null);
        }
    }
    @PostMapping("/analyze-and-email")
    public PersonalResultInsightVO analyzeAndSendEmail(
            @RequestBody UserInputCMD userInputCMD,
            @RequestParam String email) {

        long start = System.currentTimeMillis();

        try {
            PersonalResultInsight result =
                    personalInsightService.analyzeUserInput(userInputCMD);
            StringBuilder content = new StringBuilder();

            content.append("Your Sleep Analysis Report\n\n");
            content.append("Estimated Sleep Quality: ")
                    .append(result.getEstimatedSleepQuality())
                    .append(" (")
                    .append(result.getSleepQualityCategory())
                    .append(")\n\n");

            content.append("Risk Factors:\n");
            for (String r : result.getRiskFactors()) {
                content.append("- ").append(r).append("\n");
            }

            content.append("\nRecommendations:\n");
            for (String r : result.getRecommendations()) {
                content.append("- ").append(r).append("\n");
            }

            emailService.sendEmail(email, "Your sleep insights is available",content.toString());

            long end = System.currentTimeMillis();
            BaseVO baseVO = BaseVO.buildVO(0, end - start, true, null);

            return new PersonalResultInsightVO(baseVO, result);

        } catch (Exception e) {
            long end = System.currentTimeMillis();
            BaseVO baseVO = BaseVO.buildVO(-1, end - start, false, e.getMessage());

            return new PersonalResultInsightVO(baseVO, null);
        }
    }
}