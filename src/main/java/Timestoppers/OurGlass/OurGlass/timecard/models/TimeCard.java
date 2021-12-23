package Timestoppers.OurGlass.OurGlass.timecard.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TimeCard {

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
    private Long id;




    public TimeCard(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeCard timeCard = (TimeCard) o;
        return Objects.equals(clockIn, timeCard.clockIn) && Objects.equals(clockOut, timeCard.clockOut) && Objects.equals(onBreak, timeCard.onBreak) && Objects.equals(notOnBreak, timeCard.notOnBreak) && Objects.equals(date, timeCard.date) && Objects.equals(time, timeCard.time) && Objects.equals(requestType, timeCard.requestType) && Objects.equals(timeOffRequest, timeCard.timeOffRequest) && Objects.equals(timeBank, timeCard.timeBank) && Objects.equals(id, timeCard.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clockIn, clockOut, onBreak, notOnBreak, date, time, requestType, timeOffRequest, timeBank, id);
    }

    @Override
    public String toString() {
        return "TimeCard{" +
                "clockIn=" + clockIn +
                ", clockOut=" + clockOut +
                ", onBreak=" + onBreak +
                ", notOnBreak=" + notOnBreak +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", requestType='" + requestType + '\'' +
                ", timeOffRequest='" + timeOffRequest + '\'' +
                ", timeBank='" + timeBank + '\'' +
                ", id=" + id +
                '}';
    }
}

