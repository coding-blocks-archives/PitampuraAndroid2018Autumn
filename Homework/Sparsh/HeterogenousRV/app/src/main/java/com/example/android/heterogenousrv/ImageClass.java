package com.example.android.heterogenousrv;

public class ImageClass {
    private String title,subtitle,url;

    public ImageClass(String title, String subtitle, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getUrl() {
        return url;
    }
}
