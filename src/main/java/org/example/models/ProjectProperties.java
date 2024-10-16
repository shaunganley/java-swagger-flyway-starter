package org.example.models;

import org.joda.time.DateTime;


public class ProjectProperties {
    private DateTime startDate;
    private DateTime finishDate;
    private float commissionRate;
    private float value;

    public ProjectProperties(
            final DateTime startDate,
            final DateTime finishDate,
            final float commissionRate,
            final float value
    ) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.commissionRate = commissionRate;
        this.value = value;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(final DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(final DateTime finishDate) {
        this.finishDate = finishDate;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(final float value) {
        this.value = value;
    }
}
