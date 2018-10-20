package com.avi.abhishek.notetakingapp;

import java.util.Calendar;
import java.util.Date;

public class Note {
    private String title,time;

    public Note(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }
}
