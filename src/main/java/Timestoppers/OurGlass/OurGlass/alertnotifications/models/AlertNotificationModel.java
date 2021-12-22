package Timestoppers.OurGlass.OurGlass.alertnotifications.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlertNotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeNumber;
    private String jobTitle;
    private Boolean onTask;
    private Boolean offTask;
    private Boolean present;
    private Boolean absent;
    private Boolean timeOffRequests;
    private Boolean clockIn;
    private Boolean clockOut;

    public AlertNotificationModel() {
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
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
    public String toString() {
        return "AlertNotificationModel{" +
                "employeeNumber=" + employeeNumber +
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
