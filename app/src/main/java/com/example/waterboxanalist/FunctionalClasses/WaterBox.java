package com.example.waterboxanalist.FunctionalClasses;

import com.example.waterboxanalist.ReportsClasses.WaterBoxHistory;

import java.util.List;

public class WaterBox {

    private List<WaterBoxHistory> waterBoxHistory;
    private float totalHeight;
    private float currentHeight;

    public float CalculatePercent(float height) {
        return height * 100 / totalHeight;
    }

    public float getTotalHeight() {
        return totalHeight;
    }

    public void setTotalHeight(float totalHeight) {
        this.totalHeight = totalHeight;
    }

    public float getCurrentHeight() {
        return currentHeight;
    }

    public List<WaterBoxHistory> getWaterBoxHistory() {
        return waterBoxHistory;
    }

    public void addListToWaterBoxHistory(List<WaterBoxHistory> waterBoxHistory) {
        for (WaterBoxHistory waterBox : waterBoxHistory) {
            this.waterBoxHistory.add(waterBox);
        }
    }

    public void setCurrentHeight(float currentHeight) {
        this.currentHeight = currentHeight;
    }
}


