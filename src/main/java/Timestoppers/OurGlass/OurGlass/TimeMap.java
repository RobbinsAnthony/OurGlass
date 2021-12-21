package Timestoppers.OurGlass.OurGlass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeMap {

    private String datetime;

    @JsonProperty("timezone_name")
    private String timeZoneName;

    @JsonProperty("timezone_location")
    private String timeZoneLocation;

    @JsonProperty("timezone_abbreviation")
    private String getTimeZoneAbbreviation;

    @JsonProperty("gmt_offset")
    private Integer gmtOffset;

    @JsonProperty("is_dst")
    private Boolean isDst;

    @JsonProperty("requested_location")
    private String requestedLocation;

    private Double latitude;

    private Double Longitude;


    public TimeMap() {

    }

    public TimeMap(String datetime, String timeZoneName, String timeZoneLocation, String getTimeZoneAbbreviation, Integer gmtOffset, Boolean isDst, String requestedLocation, Double latitude, Double longitude) {
        this.datetime = datetime;
        this.timeZoneName = timeZoneName;
        this.timeZoneLocation = timeZoneLocation;
        this.getTimeZoneAbbreviation = getTimeZoneAbbreviation;
        this.gmtOffset = gmtOffset;
        this.isDst = isDst;
        this.requestedLocation = requestedLocation;
        this.latitude = latitude;
        Longitude = longitude;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public String getTimeZoneLocation() {
        return timeZoneLocation;
    }

    public void setTimeZoneLocation(String timeZoneLocation) {
        this.timeZoneLocation = timeZoneLocation;
    }

    public String getGetTimeZoneAbbreviation() {
        return getTimeZoneAbbreviation;
    }

    public void setGetTimeZoneAbbreviation(String getTimeZoneAbbreviation) {
        this.getTimeZoneAbbreviation = getTimeZoneAbbreviation;
    }

    public Integer getGmtOffset() {
        return gmtOffset;
    }

    public void setGmtOffset(Integer gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public Boolean getDst() {
        return isDst;
    }

    public void setDst(Boolean dst) {
        isDst = dst;
    }

    public String getRequestedLocation() {
        return requestedLocation;
    }

    public void setRequestedLocation(String requestedLocation) {
        this.requestedLocation = requestedLocation;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    @Override
    public String toString() {
        return "TimeMap{" +
                "datetime='" + datetime + '\'' +
                ", timeZoneName='" + timeZoneName + '\'' +
                ", timeZoneLocation='" + timeZoneLocation + '\'' +
                ", getTimeZoneAbbreviation='" + getTimeZoneAbbreviation + '\'' +
                ", gmtOffset=" + gmtOffset +
                ", isDst=" + isDst +
                ", requestedLocation='" + requestedLocation + '\'' +
                ", latitude=" + latitude +
                ", Longitude=" + Longitude +
                '}';
    }
}
