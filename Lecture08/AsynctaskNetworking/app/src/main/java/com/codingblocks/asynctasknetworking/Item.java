package com.codingblocks.asynctasknetworking;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Item implements Parcelable{

    private String login, id, avatar_url, url, score, repos_url;

    public Item(String login, String id, String avatar_url, String url, String score, String repos_url) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.url = url;
        this.score = score;
        this.repos_url = repos_url;
    }

    protected Item(Parcel in) {
        login = in.readString();
        id = in.readString();
        avatar_url = in.readString();
        url = in.readString();
        score = in.readString();
        repos_url = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public String getScore() {
        return score;
    }

    public String getRepos_url() {
        return repos_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(id);
        dest.writeString(avatar_url);
        dest.writeString(url);
        dest.writeString(score);
        dest.writeString(repos_url);
    }
}
