package com.codingblocks.tododatabase;

public class Note {

    private String title, description, timeStamp;
    private Integer isDone,id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    public Note(String title, String description, String timeStamp, Integer isDone) {
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;
        this.isDone = isDone;
    }

    public Note(String title, String description, String timeStamp, Integer isDone, Integer id) {
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;
        this.isDone = isDone;
        this.id = id;
    }
}
