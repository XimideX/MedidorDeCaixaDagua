package com.example.waterboxanalist.ReportsClasses;

import java.util.Date;

public class WaterBoxHistory {

    private Date timeOfCheck;
    private float height;

    public Date getTimeOfCheck() {
        return timeOfCheck;
    }

    public void setTimeOfCheck(Date timeOfCheck) {
        this.timeOfCheck = timeOfCheck;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
