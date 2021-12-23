package Timestoppers.OurGlass.OurGlass.alertnotifications.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alertNotificationId;
    private String jobTitle;
    private Boolean onTask;
    private Boolean offTask;
    private Boolean present;
    private Boolean absent;
    private Boolean timeOffRequests;
    private Boolean clockIn;
    private Boolean clockOut;



    public AlertNotification() {
    }

    public Long getAlertNotificationId() {
        return alertNotificationId;
    }

    public void setAlertNotificationId(Long alertNotificationId) {
        this.alertNotificationId = alertNotificationId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Boolean getOnTask() {
        return onTask;
    }

    public void setOnTask(Boolean onTask) {
        this.onTask = onTask;
    }

    public Boolean getOffTask() {
        return offTask;
    }

    public void setOffTask(Boolean offTask) {
        this.offTask = offTask;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public Boolean getAbsent() {
        return absent;
    }

    public void setAbsent(Boolean absent) {
        this.absent = absent;
    }

    public Boolean getTimeOffRequests() {
        return timeOffRequests;
    }

    public void setTimeOffRequests(Boolean timeOffRequests) {
        this.timeOffRequests = timeOffRequests;
    }

    public Boolean getClockIn() {
        return clockIn;
    }

    public void setClockIn(Boolean clockIn) {
        this.clockIn = clockIn;
    }

    public Boolean getClockOut() {
        return clockOut;
    }

    public void setClockOut(Boolean clockOut) {
        this.clockOut = clockOut;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlertNotification that = (AlertNotification) o;
        return Objects.equals(alertNotificationId, that.alertNotificationId) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(onTask, that.onTask) && Objects.equals(offTask, that.offTask) && Objects.equals(present, that.present) && Objects.equals(absent, that.absent) && Objects.equals(timeOffRequests, that.timeOffRequests) && Objects.equals(clockIn, that.clockIn) && Objects.equals(clockOut, that.clockOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alertNotificationId, jobTitle, onTask, offTask, present, absent, timeOffRequests, clockIn, clockOut);
    }

    @Override
    public String toString() {
        return "AlertNotification{" +
                "alertNotificationId=" + alertNotificationId +
                ", jobTitle='" + jobTitle + '\'' +
                ", onTask=" + onTask +
                ", offTask=" + offTask +
                ", present=" + present +
                ", absent=" + absent +
                ", timeOffRequests=" + timeOffRequests +
                ", clockIn=" + clockIn +
                ", clockOut=" + clockOut +
                '}';
    }
}
