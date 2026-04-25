package com.example.SleepAnalysis.service;

import com.example.SleepAnalysis.entity.PersonalResultInsight;

public interface EmailService {
    void sendEmail(String to, String subject, String content);
}
