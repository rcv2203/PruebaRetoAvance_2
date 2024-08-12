package com.rcv.solarsportsavance;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable {
    private String url;
    private String title;
    private String description;

    public Video(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    protected Video(Parcel in) {
        url = in.readString();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeString(title);
        parcel.writeString(description);
    }
}

