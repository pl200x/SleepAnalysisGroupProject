package com.example.SleepAnalysis.controller.VO;

import com.example.SleepAnalysis.entity.PersonalResultInsight;

public class PersonalResultInsightVO {
    private BaseVO baseVO;
    private PersonalResultInsight personalResultInsight;

    public PersonalResultInsightVO() {
    }

    public PersonalResultInsightVO(BaseVO baseVO, PersonalResultInsight personalResultInsight) {
        this.baseVO = baseVO;
        this.personalResultInsight = personalResultInsight;
    }

    public BaseVO getBaseVO() {
        return baseVO;
    }

    public void setBaseVO(BaseVO baseVO) {
        this.baseVO = baseVO;
    }

    public PersonalResultInsight getPersonalResultInsight() {
        return personalResultInsight;
    }

    public void setPersonalResultInsight(PersonalResultInsight personalResultInsight) {
        this.personalResultInsight = personalResultInsight;
    }
}