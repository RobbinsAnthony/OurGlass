package Timestoppers.OurGlass.OurGlass.TimeCard.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimeCardModel {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Boolean clockIn;
    private Boolean clockOut;
    private Boolean onBreak;
    private Boolean notOnBreak;
    private String date;
    private String time;
    private String requestType;
    private String timeOffRequest;
    private String timeBank;

    public TimeCardModel(){

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

    public Boolean getOnBreak() {
        return onBreak;
    }

    public void setOnBreak(Boolean onBreak) {
        this.onBreak = onBreak;
    }

    public Boolean getNotOnBreak() {
        return notOnBreak;
    }

    public void setNotOnBreak(Boolean notOnBreak) {
        this.notOnBreak = notOnBreak;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getTimeOffRequest() {
        return timeOffRequest;
    }

    public void setTimeOffRequest(String timeOffRequest) {
        this.timeOffRequest = timeOffRequest;
    }

    public String getTimeBank() {
        return timeBank;
    }

    public void setTimeBank(String timeBank) {
        this.timeBank = timeBank;
    }

    @Override
    public String toString() {
        return "TimeCardModel{" +
                "clockIn=" + clockIn +
                ", clockOut=" + clockOut +
                ", onBreak=" + onBreak +
                ", notOnBreak=" + notOnBreak +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", requestType='" + requestType + '\'' +
                ", timeOffRequest='" + timeOffRequest + '\'' +
                ", timeBank='" + timeBank + '\'' +
                '}';
    }
}
