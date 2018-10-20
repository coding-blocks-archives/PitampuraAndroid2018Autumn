package com.codingblocks.firebasedb;

public class Note {

    String title, subtitle, time;

    //Default constructor is needed for Firebase to work
    public Note() {
    }

    public Note(String title, String subtitle, String time) {
        this.title = title;
        this.subtitle = subtitle;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
