package org.soniakbew.models;
import org.joda.time.DateTime;

public class ProjectProperties {
    private DateTime startDate;
    private DateTime finishDate;
    private float commissionRate;
    private double value;

    public ProjectProperties(
            final DateTime startDate,
            final DateTime finishDate,
            final float commissionRate,
            final double value
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

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }
}
