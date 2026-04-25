package com.example.SleepAnalysis.service;

import com.example.SleepAnalysis.controller.cmd.UserInputCMD;
import com.example.SleepAnalysis.entity.PersonalResultInsight;

public interface PersonalInsightService {
    PersonalResultInsight analyzeUserInput(UserInputCMD userInputCMD);
}