package com.altfuns.ica.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by altfuns on 10/8/15.
 */
public class Event {
    public static final int UNA = 1;
    public static final int HEREDIA_SOSTENIBLE = 2;
    public static final int ICA = 3;

    @SerializedName("title")
    private String title;
    @SerializedName("date")
    private String date;
    @SerializedName("location")
    private String location;
    @SerializedName("schedule")
    private String schedule;
    @SerializedName("rating")
    private String rating;
    @SerializedName("organization")
    private int organization;
    @SerializedName("datetime")
    private Date datetime;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getOrganization() {
        return organization;
    }

    public void setOrganization(int organization) {
        this.organization = organization;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
