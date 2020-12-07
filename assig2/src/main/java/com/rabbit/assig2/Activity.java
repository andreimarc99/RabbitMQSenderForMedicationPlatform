package com.rabbit.assig2;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Activity {

    private Integer patientId;
    private Date startTime;
    private Date endTime;
    private String activity;

    public Activity() {
    }

    public Activity(Integer patientId, Date startTime, Date endTime, String activity) {
        this.patientId = patientId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Activity {" +
                "patientId = " + patientId +
                ", startTime = " + startTime +
                ", endTime = " + endTime +
                ", activity = '" + activity +
                '}';
    }

}