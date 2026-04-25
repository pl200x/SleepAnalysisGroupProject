package com.example.SleepAnalysis.controller.VO;

public class SleepDataPageVO {
    private BaseVO baseVO;
    private int totalRecords;
    private boolean dataLoaded;

    public SleepDataPageVO() {
    }

    public SleepDataPageVO(BaseVO baseVO, int totalRecords, boolean dataLoaded) {
        this.baseVO = baseVO;
        this.totalRecords = totalRecords;
        this.dataLoaded = dataLoaded;
    }

    public BaseVO getBaseVO() {
        return baseVO;
    }

    public void setBaseVO(BaseVO baseVO) {
        this.baseVO = baseVO;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public boolean isDataLoaded() {
        return dataLoaded;
    }

    public void setDataLoaded(boolean dataLoaded) {
        this.dataLoaded = dataLoaded;
    }
}